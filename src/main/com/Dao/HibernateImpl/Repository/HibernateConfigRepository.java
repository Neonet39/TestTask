package Dao.HibernateImpl.Repository;

import Dao.ApiBaseData.ConfigRepository;
import Modal.AssortmentCoffe;
import Modal.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 15.09.2017.
 */
@Repository
public class HibernateConfigRepository implements ConfigRepository {
    @Autowired
    SessionFactory sessionFactory;

    public int save(Configuration entity) {
        return 0;
    }

    public Configuration findOne(int ID) {
        return null;
    }

    public List<Configuration> getListTable() throws SQLException {

        return null;
    }

    public void delete(Configuration entity) {

    }

    public Configuration getConfigFile() {
        Configuration configuration = new Configuration();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Configuration");
            List cofigList =  query.list();
            if(cofigList!=null) {
                for (int i = 0; i < cofigList.size(); i++) {

                    String id = ((Dao.HibernateImpl.Entity.Configuration)
                            cofigList.get(i)).getId();
                    String value = ((Dao.HibernateImpl.Entity.Configuration)
                            cofigList.get(i)).getValue();
                    configuration.setMap(id,value);
                }
                return configuration;
            } else return null;
        }finally {
            session.getTransaction().commit();
            session.close();
        }

    }
}
