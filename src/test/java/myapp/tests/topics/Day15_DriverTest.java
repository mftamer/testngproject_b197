package myapp.tests.topics;

import myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day15_DriverTest {

    @Test (groups = "minor_regression_group")
    public void driverTest() throws InterruptedException {
    //    driver.get("https://www.amazon.com/"); we were calling the driver from the TestBase class in JUnit framework

        Driver.getDriver().get("https://www.amazon.com/");
        Thread.sleep(2000);
        Driver.getDriver().navigate().refresh();
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("Amazon"));

        //To close the driver
        Driver.closeDriver();


    }


}
