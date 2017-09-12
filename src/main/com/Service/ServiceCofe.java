package Service;

import Modal.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Evgeny on 08.09.2017.
 */
public interface ServiceCofe {
    List<AssortmentCoffe> getAssortmentCoffe();
    Map<String, PreOrder> getPreOrderCoffe(List<OrderCoffe> OrderCoffeList);
    boolean setOrderCoffe(List<PreOrderCoffe> preOrderCoffeList, AddressDelivery addresDelivery, TotalPrice totalPrice);
}
