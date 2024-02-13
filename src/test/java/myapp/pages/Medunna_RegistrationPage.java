package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Medunna_RegistrationPage {

    public Medunna_RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    public WebElement ssn;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")
    public  WebElement invalidSsnMessage;

    @FindBy(xpath = "//div[.='Your SSN is required.']")
    public WebElement ssnRequiredMessage;

    @FindBy (id = "firstName")
    public WebElement firstName;

    @FindBy(xpath = "//div[.='Your FirstName is required.']")
    public WebElement firstNameRequiredMessage;









}