package Dao.JdbcImpl.Repository;

import Dao.ApiBaseData.CheckoutOrderRepository;
import Dao.JdbcImpl.PoolConect;
import Modal.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Evgeny on 09.09.2017.
 */
public class JdbcCheckoutOrderReposytory implements CheckoutOrderRepository<PreOrderCoffe, AddressDelivery,TotalPrice> {

    private Connection connection = null;

    public boolean TransactionOrder(List<PreOrderCoffe> preOrderCoffeList, AddressDelivery addresDelivery, TotalPrice totalPrice) {
        boolean flag = true;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sql = "insert into coffeeorder (order_date,name,delivery_address,cost) VALUES ('" + dateFormat.format(new Date()) + "'," +
                "'" + addresDelivery.getName() + "','" + addresDelivery.getDelivery_address() + "'," + totalPrice.getFullTotal() + ")";
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

                for (int i = 0; i < preOrderCoffeList.size(); i++) {
                    preparedStatement.setInt(1, preOrderCoffeList.get(i).getId());
                    preparedStatement.setInt(2, Ai);
                    preparedStatement.setInt(3, preOrderCoffeList.get(i).getQuantity());
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
            e.printStackTrace();
        }finally {
            try {
                if(connection!=null)
                connection.close();
            } catch (SQLException e) {
                flag = false;
                e.printStackTrace();
            }
        }
     return flag;
    }
}