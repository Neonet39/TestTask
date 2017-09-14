package Dao.HibernateImpl.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Entity
@Table(name = "coffeeorder")
public class Coffeeorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
    private int id;

    @Column(name = "order_date" ,nullable = false)
    private Date order_date;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "delivery_address", length = 200,nullable = false)
    private String delivery_address;

    @Column(name = "cost")
    private double cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
