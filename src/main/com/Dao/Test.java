package Dao;

import Dao.ApiBaseData.CheckoutOrderRepository;
import Dao.JdbcImpl.Repository.JdbcCheckoutOrderReposytory;
import Modal.AddressDelivery;
import Modal.OrderCoffe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 09.09.2017.
 */
public class Test {
    public static void main(String[] args) {
        CheckoutOrderRepository orderRepository = new JdbcCheckoutOrderReposytory();

        AddressDelivery addressDelivery = new AddressDelivery();
        addressDelivery.setName("Evgeny");
        addressDelivery.setDelivery_address("Pushkina 28");
        addressDelivery.setCost(6);

        List orderCoffeList = new ArrayList<OrderCoffe>();
        OrderCoffe orderCoffe = new OrderCoffe();
        orderCoffe.setId(1);
        orderCoffe.setQuantity(4);
        orderCoffeList.add(orderCoffe);

        orderCoffe = new OrderCoffe();
        orderCoffe.setId(2);
        orderCoffe.setQuantity(5);
        orderCoffeList.add(orderCoffe);

        orderCoffe = new OrderCoffe();
        orderCoffe.setId(3);
        orderCoffe.setQuantity(2);
        orderCoffeList.add(orderCoffe);

        System.out.println(orderRepository.TransactionOrder(orderCoffeList,addressDelivery));
    }


}