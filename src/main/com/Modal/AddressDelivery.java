package Modal;

import java.util.Date;

/**
 * Created by Evgeny on 09.09.2017.
 */
public class AddressDelivery extends StructurModal {

    String name;
    String delivery_address;


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
}
