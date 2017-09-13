package Dao.JdbcImpl.Repository;

import Dao.ApiBaseData.ConfigRepository;
import Dao.JdbcImpl.PoolConect;
import Modal.AssortmentCoffe;
import Modal.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Evgeny on 08.09.2017.
 */
public class JdbcConfigRepository implements ConfigRepository {
    Connection connection = null;


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
        List configurationList = new ArrayList<Configuration>();
        Configuration configuration = new Configuration();

        String sql = "select * from configuration";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = PoolConect.getConection();
            try {
                preparedStatement = connection.prepareStatement(sql);
                try {
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {

                        configuration.setMap(resultSet.getString(1),resultSet.getString(2));

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
        return configuration;
    }
}
