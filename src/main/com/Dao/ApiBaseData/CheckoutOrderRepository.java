package Dao.ApiBaseData;

import java.util.List;

/**
 * Created by Evgeny on 09.09.2017.
 */
public interface CheckoutOrderRepository<T,U> {
    public boolean TransactionOrder(List<T> orderCoffeLst, U addresDelivery);
}
