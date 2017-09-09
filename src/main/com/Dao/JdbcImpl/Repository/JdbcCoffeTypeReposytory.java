package Dao.JdbcImpl.Repository;

import Dao.ApiBaseData.CoffeTypeRepository;
import Dao.JdbcImpl.PoolConect;
import Modal.AssortmentCoffe;
import Modal.OrderCoffe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeny on 08.09.2017.
 */
public class JdbcCoffeTypeReposytory implements CoffeTypeRepository {

    private Connection connection = null;

    public int save(AssortmentCoffe entity) {
        return 0;
    }

    public AssortmentCoffe findOne(int ID) {
        return null;
    }

    public void delete(AssortmentCoffe entity) {

    }

    public List<AssortmentCoffe> getListTable() {
        String sql = "select * from coffeetype where (disabled!='Y' or disabled!='y')";

        return getAssortmentCoffeList(sql);
    }


    public List<AssortmentCoffe> getListTalbe(List<OrderCoffe> orderCoffesList) {
        StringBuffer sqlWhere = new StringBuffer("");

        for (int i = 0; i < orderCoffesList.size(); i++) {
            if (i == 0)
                sqlWhere.append(" id=" + orderCoffesList.get(i).getId());
            else sqlWhere.append(" or id=" + orderCoffesList.get(i).getId());
        }
        String sql = "select * from coffeetype where" + sqlWhere.toString()+" and (disabled!='Y' or disabled!='y')";
        return getAssortmentCoffeList(sql);

    }

    private List<AssortmentCoffe> getAssortmentCoffeList(String sql){
        List assortmentList = new ArrayList<AssortmentCoffe>();
        AssortmentCoffe assortmentCoffe;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = PoolConect.getConection();
            try {
                preparedStatement = connection.prepareStatement(sql);
                try {
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        assortmentCoffe = new AssortmentCoffe();
                        assortmentCoffe.setId(resultSet.getInt(1));
                        assortmentCoffe.setType_name(resultSet.getString(2));
                        assortmentCoffe.setPrice(resultSet.getDouble(3));
                        assortmentList.add(assortmentCoffe);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    resultSet.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                preparedStatement.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return assortmentList;
    }
}
