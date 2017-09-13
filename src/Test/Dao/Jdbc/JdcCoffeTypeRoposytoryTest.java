package Dao.Jdbc;

import Dao.JdbcImpl.Repository.JdbcCoffeTypeReposytory;
import Modal.AssortmentCoffe;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Evgeny on 12.09.2017.
 */
public class JdcCoffeTypeRoposytoryTest {
    @Test
    public void getListTableTest(){
        JdbcCoffeTypeReposytory jdbcCoffeTypeReposytory = new JdbcCoffeTypeReposytory();
        List<AssortmentCoffe> assortmentCoffeList = jdbcCoffeTypeReposytory.getListTable();
        Assert.assertTrue(assortmentCoffeList.size()==3);

    }

    @Test
    public void getListTableTestValue(){

        JdbcCoffeTypeReposytory jdbcCoffeTypeReposytory = new JdbcCoffeTypeReposytory();
        List assortmentCoffeListValue = new ArrayList<AssortmentCoffe>();
        AssortmentCoffe assortmentCoffe;

        assortmentCoffe = new AssortmentCoffe();
        assortmentCoffe.setId(1);
        assortmentCoffe.setPrice(5.0);
        assortmentCoffe.setType_name("Coffea arabica");
        assortmentCoffeListValue.add(assortmentCoffe);

        assortmentCoffe = new AssortmentCoffe();
        assortmentCoffe.setId(2);
        assortmentCoffe.setPrice(7.0);
        assortmentCoffe.setType_name("Coffea Canephora");
        assortmentCoffeListValue.add(assortmentCoffe);


        assortmentCoffe = new AssortmentCoffe();
        assortmentCoffe.setId(4);
        assortmentCoffe.setPrice(4.0);
        assortmentCoffe.setType_name("Вкусный кофе");
        assortmentCoffeListValue.add(assortmentCoffe);



        List<AssortmentCoffe> assortmentCoffeList = jdbcCoffeTypeReposytory.getListTable();
        Assert.assertTrue(assortmentCoffeListValue.toString().equals(assortmentCoffeList.toString()));

    }


}
