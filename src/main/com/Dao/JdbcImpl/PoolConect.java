package Dao.JdbcImpl;

import Setting.*;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Evgeny on 08.09.2017.
 */
public class PoolConect {

    private static BasicDataSource ds = null;
    final static Setting settings = Setting.getInstance();


    private static void createPool(){
        ds = new BasicDataSource();
        ds.setDriverClassName(settings.value("db.driver"));
        ds.setUrl(settings.value("db.url"));
        ds.setUsername(settings.value("db.user"));
        ds.setPassword(settings.value("db.password"));
    }
    public static Connection getConection(){

        if(ds==null)
            createPool();
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public void close(){
        try {
            ds.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
