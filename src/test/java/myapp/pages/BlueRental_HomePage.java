package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueRental_HomePage {

//    1. Create constructor and use PageFactory class to initialize the objects of this class
//    2. Locate elements using @FindBy annotation

    public BlueRental_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (partialLinkText = "Login")
    public WebElement userIcon;
}