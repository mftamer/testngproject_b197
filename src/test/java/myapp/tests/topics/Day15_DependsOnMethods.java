package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class Day15_DependsOnMethods {

    //DependsOnMethods parameter is used to make tests dependent on each other
    //If the test (on which other tests are dependent) fails, the other tests will be skipped

    @Test
    public void homePageTest(){
        System.out.println("Home Page test....");
    }

    @Test (dependsOnMethods = "homePageTest")
    public void searchTest(){
        System.out.println("Searching something....");
        Assert.assertTrue(false); //test fails at this step
    }

    @Test (dependsOnMethods = "searchTest")
    public void checkOutTest(){
        System.out.println("User is checking out....");
    }




}
