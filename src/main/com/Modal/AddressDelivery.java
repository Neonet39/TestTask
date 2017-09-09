package Modal;

import java.util.Date;

/**
 * Created by Evgeny on 09.09.2017.
 */
public class AddressDelivery extends StructurModal {
    Date order_date ;
    String name;
    String delivery_address;
    double cost;

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
