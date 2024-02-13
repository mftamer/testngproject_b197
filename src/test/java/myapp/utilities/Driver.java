package myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class Driver {

    /*
    This is a SIMPLE Driver class … created on Singleton design pattern… But we will make it more DYNAMIC later on

    NOTE: This Driver class will work the same way with Sequential tests as well as Parallel Tests

    PLAN:
    1. Create a private Constructor => to prevent any external instantiation
    2. Use ThreadLocal class from Java to create thread-safe variable
    3. Driver.getDriver() will be used the same way as before … This will return us the copy of Driver each time for parallel Testing
    4. Create a separate method for a switch statement called initialiseDriver() and call that method in getDriver() to implement the same
       method in all existing codes
     */

    private Driver (){};  // private Constructor => to prevent any external instantiation


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();  // returns thread-safe Driver instance each time

    public static WebDriver getDriver(){
        if (driver.get()==null) {
            initialiseDriver();  // method call for a switch statement
        }
        return driver.get();
    }


    public static void initialiseDriver(){
        switch (ConfigReader.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                // NOTE: If you're not facing any thread safety related error like this one:
                // "this instance of WebDriver was constructed
                //on thread main (id 1)and is being accessed by thread Thread-1 (id 24)
                //This is not permitted and *will* cause undefined behaviour"
                // Then use this code => driver.set(ThreadGuard.protect(new ChromeDriver()));
                // Otherwise use only this code =>  driver.set(new ChromeDriver());
//                    driver.set(ThreadGuard.protect(new ChromeDriver()));
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(new ChromeOptions().addArguments("--headless=new")));
                break;
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get().manage().window().maximize();

    }



    public static void closeDriver(){
        if (driver.get()!=null){
            driver.get().quit();
            driver.remove();

        }
    }



}