package Service;

import Dao.ApiBaseData.CheckoutOrderRepository;
import Dao.ApiBaseData.CoffeTypeRepository;

import Dao.JdbcImpl.Repository.JdbcCheckoutOrderReposytory;
import Dao.JdbcImpl.Repository.JdbcCoffeTypeReposytory;

import Modal.*;
import Setting.ConfigurationPrice;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 08.09.2017.
 */
public class ImplServiceCofe implements ServiceCofe {

    CoffeTypeRepository coffeTypeRepository = new JdbcCoffeTypeReposytory();
    CheckoutOrderRepository checkoutOrderRepository = new JdbcCheckoutOrderReposytory();

    Configuration configuration = new ConfigurationPrice().getConfigPrice();



    public List<AssortmentCoffe> getAssortmentCoffe() {
        List assortmentCoffe = new ArrayList<AssortmentCoffe>();
        try {
           assortmentCoffe =  coffeTypeRepository.getListTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assortmentCoffe;
    }





    public Map<String, PreOrder> getPreOrderCoffe(List<OrderCoffe> OrderCoffeList)  {
        List preOrderCoffeList = new  ArrayList<PreOrderCoffe>();
        PreOrderCoffe preOrderCoffe;

        TotalPrice tPrice = new TotalPrice();

        Map preOrder = new HashMap<String,PreOrder>();

        List<AssortmentCoffe> assortmentCoffeList =  coffeTypeRepository.getListTalbe(OrderCoffeList);

        if(OrderCoffeList.size()==assortmentCoffeList.size()){
            String x = configuration.getMap("x");
            String m = configuration.getMap("m");
            String n = configuration.getMap("n");

            if(x!=null&&m!=null&&n!=null){
                double totalPrice = 0;
                int everyFreeCup = Integer.valueOf(n);
                double costDelivery = Double.valueOf(m);
                double freeDelivery = Double.valueOf(x);

                for(AssortmentCoffe coffeList: assortmentCoffeList){
                    preOrderCoffe = new PreOrderCoffe();
                    preOrderCoffe.setType_name(coffeList.getType_name());
                    preOrderCoffe.setId(coffeList.getId());
                    preOrderCoffe.setPrice(coffeList.getPrice());

                    for (int quantity=0;quantity<OrderCoffeList.size();quantity++){
                        if (OrderCoffeList.get(quantity).getId()==coffeList.getId()){
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
        return null;
    }

    public boolean setOrderCoffe(List<PreOrderCoffe> preOrderCoffeList, AddressDelivery addresDelivery, TotalPrice totalPrice) {
      return  checkoutOrderRepository.TransactionOrder(preOrderCoffeList,addresDelivery,totalPrice);
    }


}
