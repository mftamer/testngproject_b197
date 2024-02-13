package myapp.tests.extentreport;
import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day20_AdminLogin {
    /*
    ADD EXTENT REPORT CAPABILITY
    1. Use createTestReport(String name,String description) first for creating an extent report for this test
    2. Then use all methods to log the information on the extent report e.g., pass, info, fail etc.
    3. Use flush() method in the end ... MANDATORY
     */
    /*
    ADD LOGGER CAPABILITY
    Uses any method from LoggerUtils class
     */
    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
    @Test
    public void blueRentalLoginTest() {
        // Using Logger
        LoggerUtils.info("Starting login Test... ");
//        1.
        ExtentReportUtils.createTestReport("Smoke Test Report", "Login Function");
        // 2.
        ExtentReportUtils.info("User is logging on to https://www.bluerentalcars.com/ ");
//    Given user is on the application home page https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("bluerental_url"));  // Dynamic way
//    Then clicks on a login link
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 1); // Dynamic way
        // 2.
        ExtentReportUtils.pass("User clicks on login icon");
//    Then enters admin email, password
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.email, ConfigReader.getProperty("bluerental_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRentalLoginPage.password, ConfigReader.getProperty("bluerental_password"), 2);
        // 2.
        ExtentReportUtils.pass("User entered email and password successfully!!");
//    Then click on the login button
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.loginButton, 1);
        // 2.
        ExtentReportUtils.passAndCaptureScreenshot("User clicked on log in button");
//    Then verify the login is successful
        Assert.assertTrue(blueRentalLoginPage.dropDown.isDisplayed());
        LoggerUtils.info("Login is successful!");
        // 2.
        ExtentReportUtils.passAndCaptureScreenshot("User has logged in successfully ");
//        Then logout and verify logout are successful
//        First we need to click on dropdown, so we can see a logout option
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.dropDown, 2);
//        Then we click on logout
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.logoutOption, 2);
        WaitUtils.waitFor(3);
        // 2.
        ExtentReportUtils.info("User clicked on logout option");
        BrowserUtils.clickWithTimeOut(blueRentalLoginPage.okOption, 2);
        // 2.
        ExtentReportUtils.info("User clicked on OK option");
//        verify logout is successful
        WaitUtils.waitFor(2);
        BrowserUtils.verifyElementDisplayed(blueRentalHomePage.userIcon);
        // 2.
        ExtentReportUtils.passAndCaptureScreenshot("Logout is successful! ");
        LoggerUtils.info("Logout is successful!");
//        Close the driver
        Driver.closeDriver();
        // 2.
        ExtentReportUtils.pass("Driver is closed");
        // 3.
        ExtentReportUtils.flush();
    }
}