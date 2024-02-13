package myapp.tests.medunna_practice;
import myapp.pages.Medunna_HomePage;
import myapp.pages.Medunna_RegistrationPage;
import myapp.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Day21_US001 {
    /*
    US001: Registration should be available using SSN, Firstname and Lastname
        AC001: There should be a valid SSN respecting the "-" after 3rd and 5th digits, it should be 9 digits long
            AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
            AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
            AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
            AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
            AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
        AC002: SSN cannot be left blank
            AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
            AC002TC02: User enters the ssn-only space, there should be "Your SSN is required." message
            AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
        AC003: There should be a valid name that contains any chars and cannot be blank
            AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
            AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
            AC003TC03: User enters the name that contains any chars, there should not be any error message
        AC004: There should be a valid lastname that contains any chars and it is a required field
            AC004TC01: User leaves the lastname blank, there should be "Your LastName is required." message
            AC004TC02: User enters the lastname only space, there should be "Your LastName is required." message
            AC004TC03: User enters the lastname that contains any chars, there should not be any error message
     */
    Medunna_HomePage medunnaHomePage = new Medunna_HomePage();
    Medunna_RegistrationPage medunnaRegistrationPage = new Medunna_RegistrationPage();
    @BeforeTest
    public void setUP(){
//        Driver.getDriver().get("https://www.medunna.com/");
        ExtentReportUtils.createTestReport("Medunna Practice", "Medunna Registration Page");
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
        ExtentReportUtils.pass("User is on Medunna HomePage");
        medunnaHomePage.userIcon.click();
        ExtentReportUtils.pass("User clicks on user icon");
        WaitUtils.waitFor(2);
        medunnaHomePage.registerOption.click();
        ExtentReportUtils.pass("User clicks on register option");
//        BrowserUtils.clickWithTimeOut(medunnaHomePage.userIcon, 2);
//        BrowserUtils.clickWithTimeOut(medunnaHomePage.registerOption, 2);
    }
    @Test
    public void medunnaTest1(){
//        AC001TC01: User enters the ssn 22255-5432, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.sendKeys("22255-5432", Keys.TAB);
        ExtentReportUtils.passAndCaptureScreenshot("User enters invalid ssn not respecting the dash");
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);
        WaitUtils.waitFor(1);
        ExtentReportUtils.passAndCaptureScreenshot("Your SSN is invalid message is displayed.");
//        AC001TC02: User enters the ssn 222-555432, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-555432", Keys.TAB);
        ExtentReportUtils.passAndCaptureScreenshot("User enters invalid ssn not respecting the dash");
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);
        WaitUtils.waitFor(1);
        ExtentReportUtils.passAndCaptureScreenshot("Your SSN is invalid message is displayed.");
//        AC001TC03: User enters the ssn 222-55-543, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-543", Keys.TAB);
        ExtentReportUtils.passAndCaptureScreenshot("User enters invalid ssn not respecting the dash");
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);
        WaitUtils.waitFor(1);
        ExtentReportUtils.passAndCaptureScreenshot("Your SSN is invalid message is displayed.");
//        AC001TC04: User enters the ssn 222-55-543a, there should be "Your SSN is invalid" message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-543a", Keys.TAB);
        ExtentReportUtils.passAndCaptureScreenshot("User enters invalid ssn not respecting the dash");
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.invalidSsnMessage);
        WaitUtils.waitFor(1);
        ExtentReportUtils.passAndCaptureScreenshot("Your SSN is invalid message is displayed.");
//        AC001TC05: User enters the ssn 222-55-5432, there should not be any error message
        medunnaRegistrationPage.ssn.clear();
        medunnaRegistrationPage.ssn.sendKeys("222-55-5432", Keys.TAB);
        ExtentReportUtils.passAndCaptureScreenshot("User enters VALID ssn");
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.invalidSsnMessage);
        WaitUtils.waitFor(1);
        ExtentReportUtils.passAndCaptureScreenshot("Your SSN is invalid message is NOT displayed.");
        ExtentReportUtils.flush();
    }
    @Test
    public void medunnaTest2(){
//        AC002: SSN cannot be left blank
//        AC002TC01: User leaves the ssn blank, there should be "Your SSN is required." message
//        medunnaRegistrationPage.ssn.click(); // we will not send any value
//        WaitUtils.waitFor(2);
        medunnaRegistrationPage.ssn.sendKeys(Keys.TAB);  // makes the driver move out of ssn field
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
//        AC002TC02: User enters the ssn-only space, there should be "Your SSN is required." message
//        medunnaRegistrationPage.ssn.sendKeys(" ", Keys.TAB);  OR
        medunnaRegistrationPage.ssn.sendKeys(Keys.SPACE);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
//        AC002TC03: User enters the ssn 222-55-5432, there should not be any error message
        medunnaRegistrationPage.ssn.clear();
        WaitUtils.waitFor(1);
        medunnaRegistrationPage.ssn.sendKeys("222-55-5432", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
    }
    @Test
    public void medunnaTest3(){
//        AC003: There should be a valid name that contains any chars and cannot be blank
//        AC003TC01: User leaves the FirstName blank, there should be "Your FirstName is required." message
        medunnaRegistrationPage.ssn.sendKeys("222-55-5432", Keys.TAB); // OPTIONAL
        WaitUtils.waitFor(1);
        medunnaRegistrationPage.firstName.sendKeys(Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);
//        AC003TC02: User enters the FirstName only space, there should be "Your FirstName is required." message
        medunnaRegistrationPage.firstName.sendKeys(" ", Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(medunnaRegistrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);
//        AC003TC03: User enters the name that contains any chars, there should not be any error message
        medunnaRegistrationPage.firstName.clear();
        WaitUtils.waitFor(1);
        medunnaRegistrationPage.firstName.sendKeys("John");
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementNotDisplayed(medunnaRegistrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);
    }
}