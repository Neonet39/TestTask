package Dao.HibernateImpl.Entity;

import javax.persistence.*;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Entity
@Table(name = "coffeeorderitem")
public class Coffeeorderitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
    private int id;

    @OneToMany
    @JoinColumn(name = "type_id",nullable = false)
    private Coffeetype type_id;

    @OneToMany
    @JoinColumn(name = "type_id",nullable = false)
    private Coffeeorder order_id;

    @Column(name = "quantity",length = 11)
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coffeetype getType_id() {
        return type_id;
    }

    public void setType_id(Coffeetype type_id) {
        this.type_id = type_id;
    }

    public Coffeeorder getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Coffeeorder order_id) {
        this.order_id = order_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
