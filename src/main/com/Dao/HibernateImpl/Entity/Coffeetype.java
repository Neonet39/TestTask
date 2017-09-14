package Dao.HibernateImpl.Entity;

import javax.persistence.*;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Entity
@Table(name = "coffeetype")
public class Coffeetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
    private int id;

    @Column(name = "type_name",length = 200,nullable = false)
    String type_name;

    @Column(name = "price",nullable = false)
    double price;

    @Column(name = "type_name",length = 1)
    char disabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getDisabled() {
        return disabled;
    }

    public void setDisabled(char disabled) {
        this.disabled = disabled;
    }
}


