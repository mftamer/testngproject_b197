package myapp.pages;

import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Techpro_LoginPage {

    public Techpro_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "exampleInputEmail1")
    public WebElement userName;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    public void login(String userID, String pass){
        userName.sendKeys(userID);
        WaitUtils.waitFor(2);
        password.sendKeys(pass);
        WaitUtils.waitFor(2);
        submitButton.click();
    }
}