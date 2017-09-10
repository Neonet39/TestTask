package Dao.JdbcImpl.Repository;

import Dao.ApiBaseData.CheckoutOrderRepository;
import Dao.JdbcImpl.PoolConect;
import Modal.AddressDelivery;
import Modal.AssortmentCoffe;
import Modal.OrderCoffe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Evgeny on 09.09.2017.
 */
public class JdbcCheckoutOrderReposytory implements CheckoutOrderRepository<OrderCoffe, AddressDelivery> {

    private Connection connection = null;

    public boolean TransactionOrder(List<OrderCoffe> orderCoffeList, AddressDelivery addresDelivery) {
        boolean flag = true;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sql = "insert into coffeeorder (order_date,name,delivery_address,cost) VALUES ('" + dateFormat.format(new Date()) + "'," +
                "'" + addresDelivery.getName() + "','" + addresDelivery.getDelivery_address() + "'," + addresDelivery.getCost() + ")";
        try {
            connection = PoolConect.getConection();
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();

            }

            try {
                preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.executeUpdate();
                Long key = null;
                try {
                    resultSet = preparedStatement.getGeneratedKeys();

                    if (resultSet.next()) {
                        key = resultSet.getLong(1);
                    }
                } catch (SQLException e) {
                    flag = false;
                    e.printStackTrace();
                } finally {
                    resultSet.close();
                }

                Integer Ai = Integer.valueOf(String.valueOf(key));

                sql = "insert into coffeeorderitem (type_id,order_id,quantity) VALUES (?,?,?)";

                preparedStatement = connection.prepareStatement(sql);

                for (int i = 0; i < orderCoffeList.size(); i++) {
                    preparedStatement.setInt(1, orderCoffeList.get(i).getId());
                    preparedStatement.setInt(2, Ai);
                    preparedStatement.setInt(3, orderCoffeList.get(i).getQuantity());
                    preparedStatement.executeUpdate();
                }

            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            connection.commit();
        } catch (SQLException e) {

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
     return flag;
    }
}