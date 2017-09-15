package Dao.HibernateImpl.Repository;

import Dao.ApiBaseData.CoffeTypeRepository;
import Modal.AssortmentCoffe;
import Modal.OrderCoffe;
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
 * Created by Evgeny on 14.09.2017.
 */


@Repository
public class HibernateCoffetTypeRepository implements CoffeTypeRepository {
    @Autowired
    SessionFactory sessionFactory;

    public int save(AssortmentCoffe entity) {
        return 0;
    }

    public AssortmentCoffe findOne(int ID) {
        return null;
    }


    public List<AssortmentCoffe> getListTable(){
       return getAssortmentCoffe("from Coffeetype where ( disabled is null or disabled != 'y')");

    }



    public void delete(AssortmentCoffe entity) {

    }

    public List<AssortmentCoffe> getListTalbe(List<OrderCoffe> orderCoffesList) {
        if(orderCoffesList!=null) {
            StringBuffer sqlWhere = new StringBuffer("");

            for (int i = 0; i < orderCoffesList.size(); i++) {
                if (i == 0)
                    sqlWhere.append(" id=" + orderCoffesList.get(i).getId());
                else sqlWhere.append(" or id=" + orderCoffesList.get(i).getId());
            }
            String sql = "from Coffeetype where " + sqlWhere.toString() + " and ( disabled is null or disabled != 'y')";
            return getAssortmentCoffe(sql);
        } else return null;
    }

    private List<AssortmentCoffe> getAssortmentCoffe(String sql){
        List<AssortmentCoffe> assortmentCoffeList;

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query query = session.createQuery(sql);
            assortmentCoffeList = (ArrayList<AssortmentCoffe>) query.list();
            return assortmentCoffeList;

        }finally {
            session.getTransaction().commit();
            session.close();

        }

    }
}
