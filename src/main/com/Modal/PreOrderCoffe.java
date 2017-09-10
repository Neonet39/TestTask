package Modal;

/**
 * Created by Evgeny on 08.09.2017.
 */
public class PreOrderCoffe extends PreOrder {
    int id;
    String type_name;
    Double price;
    int quantity;
    Double full_price;

    @Override
    public String toString() {
        return "PreOrderCoffe{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", full_price=" + full_price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getFull_price() {
        return full_price;
    }

    public void setFull_price(Double full_price) {
        this.full_price = full_price;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
