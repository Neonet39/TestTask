package Dao.ApiBaseData;

import Modal.Configuration;

/**
 * Created by Evgeny on 08.09.2017.
 */
public interface ConfigRepository extends CrudRepository<Configuration> {
    Configuration getConfigFile();
}
