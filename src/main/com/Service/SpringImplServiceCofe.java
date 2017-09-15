package Service;

import Dao.ApiBaseData.CoffeTypeRepository;
import Dao.ApiBaseData.ConfigRepository;
import Dao.HibernateImpl.Entity.Coffeetype;
import Modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Service
public class SpringImplServiceCofe implements ServiceCofe{

    @Autowired
    CoffeTypeRepository coffeTypeRepository;

    @Autowired
    ConfigRepository configRepository;

    public List<AssortmentCoffe> getAssortmentCoffe() {


        try {
            return coffeTypeRepository.getListTable();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }


    public Map<String, PreOrder> getPreOrderCoffe(List<OrderCoffe> OrderCoffeList) {
        List preOrderCoffeList = new ArrayList<PreOrderCoffe>();
        PreOrderCoffe preOrderCoffe;

        TotalPrice tPrice = new TotalPrice();

        Map preOrder = new HashMap<String,PreOrder>();

        List assortmentCoffeList =
        coffeTypeRepository.getListTalbe(OrderCoffeList);


        if(OrderCoffeList.size()==assortmentCoffeList.size()){
            Configuration configuration = configRepository.getConfigFile();
            String x = configuration.getMap("x");
            String m = configuration.getMap("m");
            String n = configuration.getMap("n");

            if(x!=null&&m!=null&&n!=null){
                double totalPrice = 0;
                int everyFreeCup = Integer.valueOf(n);
                double costDelivery = Double.valueOf(m);
                double freeDelivery = Double.valueOf(x);

                for(int i=0;i<assortmentCoffeList.size();i++){
                    String type_name = ((Coffeetype)assortmentCoffeList.get(i)).getType_name();
                    int id = ((Coffeetype )assortmentCoffeList.get(i)).getId();
                    double price = ((Coffeetype )assortmentCoffeList.get(i)).getPrice();

                    preOrderCoffe = new PreOrderCoffe();
                    preOrderCoffe.setType_name(type_name);
                    preOrderCoffe.setId(id);
                    preOrderCoffe.setPrice(price);

                    for (int quantity=0;quantity<OrderCoffeList.size();quantity++){
                        if (OrderCoffeList.get(quantity).getId()==id){
                            preOrderCoffe.setQuantity(OrderCoffeList.get(quantity).getQuantity());
                            break;
                        }
                    }

                    preOrderCoffe.setFull_price(
                            preOrderCoffe.getPrice()*(preOrderCoffe.getQuantity()-
                                    (preOrderCoffe.getQuantity()/everyFreeCup)));


                    totalPrice+=preOrderCoffe.getFull_price();
                    preOrderCoffeList.add(preOrderCoffe);
                }
                if(totalPrice>freeDelivery){
                    costDelivery = 0;
                }
                tPrice.setDelivery(costDelivery);
                tPrice.setTotal(totalPrice);

                preOrder.put("preOrderCoffeList",preOrderCoffeList);
                preOrder.put("tPrice",tPrice);
                return preOrder;
            }
        }
        return preOrder;
    }


    public boolean setOrderCoffe(List<PreOrderCoffe> preOrderCoffeList, AddressDelivery addresDelivery, TotalPrice totalPrice) {
        return false;
    }
}
