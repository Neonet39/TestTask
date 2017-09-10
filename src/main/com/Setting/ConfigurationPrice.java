package Setting;

import Dao.ApiBaseData.ConfigRepository;
import Dao.JdbcImpl.Repository.JdbcConfigRepository;
import Modal.Configuration;

import java.sql.SQLException;

/**
 * Created by Evgeny on 09.09.2017.
 */
public class ConfigurationPrice {
    ConfigRepository configRepository = new JdbcConfigRepository();

    public  Configuration getConfigPrice(){
           return (Configuration) configRepository.getConfigFile();
    }
}
