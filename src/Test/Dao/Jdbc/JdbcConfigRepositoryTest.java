package Dao.Jdbc;

import Dao.JdbcImpl.Repository.JdbcConfigRepository;
import Modal.Configuration;

import org.junit.Assert;
import org.junit.Test;




public class JdbcConfigRepositoryTest {


    @Test
    public void getConfigFileTest(){
        JdbcConfigRepository jdbcConfigRepository = new JdbcConfigRepository();
        Configuration configuration;
        configuration = jdbcConfigRepository.getConfigFile();
        String x = configuration.getMap("x");
        String n = configuration.getMap("n");
        String m = configuration.getMap("m");
        Assert.assertTrue(x.equals("10")&&n.equals("5")&&m.equals("12"));
    }
}
