package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medunna_HomePage {

    public Medunna_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "account-menu")
    public WebElement userIcon;

    @FindBy(linkText = "Register")
    public WebElement registerOption;







}