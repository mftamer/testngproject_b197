package myapp.homeworks;

import myapp.pages.BlueRental_HomePage;
import myapp.pages.BlueRental_LoginPage;
import myapp.utilities.BrowserUtils;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelTest {
    //    HW: Test the log in functionality of the application with different user profiles (admin, manager, customer services, end user)
//    Test Data URL: https://www.bluerentalcars.com/
//    User Credentials: Excel Sheet
    BlueRental_HomePage blueRentalHomePage;
    BlueRental_LoginPage blueRental_loginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> dataList;

    @Test
    public void excelLoginTest() {
        String pathOfExcelFile = "./resources/data_sheet.xlsx";
        excelUtils = new ExcelUtils(pathOfExcelFile, "admin_credentials");
        dataList = excelUtils.getDataList();

        for (Map<String, String> eachData : dataList) {

            Driver.getDriver().get("https://www.bluerentalcars.com/");
            blueRentalHomePage = new BlueRental_HomePage();
            blueRentalHomePage.userIcon.click();
            WaitUtils.waitFor(2);

            blueRental_loginPage = new BlueRental_LoginPage();
            blueRental_loginPage.email.sendKeys(eachData.get("username"));
            WaitUtils.waitFor(2);

            blueRental_loginPage.password.sendKeys(eachData.get("password"));
            WaitUtils.waitFor(2);

            BrowserUtils.clickWithTimeOut(blueRental_loginPage.loginButton, 2);
            Assert.assertTrue(blueRental_loginPage.dropDown.isDisplayed());
        }
    }
}