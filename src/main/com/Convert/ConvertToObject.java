package Convert;

import Modal.OrderCoffe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 11.09.2017.
 */
public class ConvertToObject {
    public List<OrderCoffe> ConvetrtToOrderCofe(Map<String, String[]> pair) {
        List orderCoffeList = new ArrayList<OrderCoffe>();

        for (Map.Entry<String, String[]> pir : pair.entrySet()) {
            OrderCoffe orderCoffe = new OrderCoffe();

            String[] value = pir.getValue();
            String key = pir.getKey();

            if (!value[0].equals("")) {
                try {

                    String quantity = new String(value[0].toString());
                    orderCoffe.setId(Integer.valueOf(key.toString()));
                    orderCoffe.setQuantity(Integer.valueOf(quantity.toString()));
                    orderCoffeList.add(orderCoffe);

                }catch (Exception e){
                    return null;
                }

            }


        }
        return orderCoffeList;
    }
}