package Modal;

/**
 * Created by Evgeny on 10.09.2017.
 */
public class TotalPrice extends PreOrder {
    double delivery;
    double total;

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "TotalPrice{" +
                "delivery=" + delivery +
                ", total=" + total +
                '}';
    }
}
