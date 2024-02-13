package myapp.tests.topics;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_ConfigReaderTest {

    @Test
    public void configReaderTest(){

        //driver.get("https://www.amazon.com/"); we were calling the driver from the TestBase class in JUnit framework

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

        //Get the title
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);

        //Verify the title
        //Assert.assertTrue(title.contains("Amazon")); //previously we were doing assertion like this
        Assert.assertTrue(title.contains(ConfigReader.getProperty("amazon_title"))); //keeps it dynamic

        //Close the driver
        Driver.closeDriver();
    }



}
