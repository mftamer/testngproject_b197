package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_LoginPage {
    //    1. Create constructor and use PageFactory class to initialize the objects of this class
//    2. Locate elements using @Findby annotation

    public BlueRental_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "formBasicEmail")
    public WebElement email;
    @FindBy (id = "formBasicPassword")
    public WebElement password;
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;


    @FindBy (id = "dropdown-basic-button")
    public WebElement dropDown;

    @FindBy (linkText = "Logout")
    public WebElement logoutOption;

    @FindBy (xpath = "//button[text()='OK']")
    public WebElement okOption;

    @FindBy(xpath = "//div[contains(text(),'User')]")
    public WebElement negLoginPopUp;

    @FindBy(xpath = "//div[contains(text(),'Bad')]")
    public WebElement badCredPopUp;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement invalidEmailMessage;

    public void deleteInputText(){
        email.sendKeys(Keys.CONTROL+"a");
        email.sendKeys(Keys.DELETE);
    }






}