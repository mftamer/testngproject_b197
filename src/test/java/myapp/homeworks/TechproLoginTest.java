package myapp.homeworks;

import myapp.pages.Techpro_HomePage;
import myapp.pages.Techpro_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.testng.annotations.Test;

public class TechproLoginTest {
    @Test
    public void loginTest(){
//      Go to Login page:
        Driver.getDriver().get(ConfigReader.getProperty("techpro_test_url"));

//      Enter username and password:
        Techpro_LoginPage techproLoginPage = new Techpro_LoginPage();
        techproLoginPage.login(ConfigReader.getProperty("techpro_test_username"),ConfigReader.getProperty("techpro_test_password") );

//      Verify login is successful:
        Techpro_HomePage techproHomePage = new Techpro_HomePage();
        BrowserUtils.verifyExpectedAndActualTextMatch("You logged into a secure area!", techproHomePage.homeHeader);

//      Logout
        BrowserUtils.clickWithTimeOut(techproHomePage.homeLogoutButton, 1);

//      Verify logout is successful:
        BrowserUtils.verifyElementDisplayed(techproLoginPage.userName);

        Driver.closeDriver();
    }
}