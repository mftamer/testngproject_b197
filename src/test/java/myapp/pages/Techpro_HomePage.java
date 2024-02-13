package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Techpro_HomePage {

    public Techpro_HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement homeHeader;

    @FindBy(linkText = "Logout")
    public WebElement homeLogoutButton;
}