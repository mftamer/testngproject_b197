package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

public class InvalidEmailTest {
    @Test
    public void invalidEmailTest(){

//    Go to: https://www.bluerentalcars.com/
        Driver.getDriver().get("https://www.bluerentalcars.com/");

//    Click login button
        BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 2);

//    Enter INCORRECT email address but CORRECT password
        BlueRental_LoginPage blueRental_loginPage = new BlueRental_LoginPage();
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_incomplete_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.password, ConfigReader.getProperty("bluerental_password"), 2);

//    Verify error message, "email must be a valid email"
        BrowserUtils.verifyExpectedAndActualTextMatch("email must be a valid email", blueRental_loginPage.invalidEmailMessage);

//    Enter valid email domain
        WaitUtils.waitFor(2);
        blueRental_loginPage.deleteInputText();
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_email"), 2);

//    Verify the error message no longer appears
        BrowserUtils.verifyElementNotDisplayed(blueRental_loginPage.invalidEmailMessage);

        Driver.closeDriver();
    }
}