package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.annotations.Test;

public class BadCredentialTest {
    @Test
    public void badCredentialTest() {

//    Go to: https://www.bluerentalcars.com/
        Driver.getDriver().get("https://www.bluerentalcars.com/");

//    Click login button
        BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
        BrowserUtils.clickWithTimeOut(blueRentalHomePage.userIcon, 2);

//    Enter the CORRECT email address but INCORRECT password
        BlueRental_LoginPage blueRental_loginPage = new BlueRental_LoginPage();
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.email, ConfigReader.getProperty("bluerental_email"), 2);
        BrowserUtils.sendKeysWithTimeout(blueRental_loginPage.password, ConfigReader.getProperty("bluerental_fake_customerpassword"), 2);
        BrowserUtils.clickWithTimeOut(blueRental_loginPage.loginButton,2);
        WaitUtils.waitFor(5);

//    Verify error message, "Bad credentials"
        BrowserUtils.verifyExpectedAndActualTextMatch("Bad credentials", blueRental_loginPage.badCredPopUp);

        Driver.closeDriver();
    }
}