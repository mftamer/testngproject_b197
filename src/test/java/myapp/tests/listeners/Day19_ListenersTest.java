package myapp.tests.listeners;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Day19_ListenersTest {

    /*
    We can add Listeners capability for Test Methods in two ways:
    1. By using @Listeners in the Test Class
    2. Through xml file - RECOMMENDED WAY
     */

    @Test
    public void listenersTest1(){
        Driver.getDriver().get("https://techproeducation.com/");
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("TechPro Education IT Programs")); //pass
    }

    @Test
    public void listenersTest2(){
        Driver.getDriver().get("https://amazon.com/");
        Driver.getDriver().navigate().refresh();
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertTrue(title.contains("amazon")); //fail
    }

    @Test
    public void listenersTest3(){
        System.out.println("Test SKIPPED");
        throw new SkipException("Skipping Test");
    }

    @Test
    public void listenersTest4(){
        Driver.getDriver().get("https://google.com/");
        String title = Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Driver.getDriver().findElement(By.id("wrong_id")).sendKeys("iPhone 15"); //Test will fail here and throw NoSuchElementException

    }


}
