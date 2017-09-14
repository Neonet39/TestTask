package Dao.HibernateImpl.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Evgeny on 14.09.2017.
 */
@Entity
public class Configuration {

    @Id
    @Column(length = 20)
    private String  id;

    @Column(length = 30)
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
