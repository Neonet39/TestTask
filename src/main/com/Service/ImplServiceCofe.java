package Service;

import Dao.ApiBaseData.CoffeTypeRepository;
import Dao.JdbcImpl.Repository.JdbcCoffeTypeReposytory;
import Modal.AssortmentCoffe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 08.09.2017.
 */
public class ImplServiceCofe implements ServiceCofe {

    CoffeTypeRepository coffeTypeRepository = new JdbcCoffeTypeReposytory();

    public List<AssortmentCoffe> getAssortmentCoffe() {
        List assortmentCoffe = new ArrayList<AssortmentCoffe>();
        try {
           assortmentCoffe =  coffeTypeRepository.getListTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assortmentCoffe;
    }

    public void setOrderCoffe(Object orderCoffe) {

    }


}
