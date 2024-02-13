package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablesPage {

    //1. Create constructor and use PageFactory class to initiate elements
    //2. Locate elements using @FindBy annotation

    public DataTablesPage(){
        PageFactory.initElements(Driver.getDriver(), this); //Without this, we will get NullPointerException
    }

    @FindBy (xpath = "(//button[@type='button'])[1]")
    public WebElement newButton;

    @FindBy (id = "DTE_Field_first_name")
    public WebElement firstName;

    @FindBy (id = "DTE_Field_last_name")
    public WebElement lastName;

    @FindBy (id = "DTE_Field_position")
    public WebElement position;

    @FindBy (id = "DTE_Field_office")
    public WebElement office;

    @FindBy (id = "DTE_Field_extn")
    public WebElement extension;

    @FindBy (id = "DTE_Field_start_date")
    public WebElement startDate;

    @FindBy (id = "DTE_Field_salary")
    public WebElement salary;

    @FindBy (xpath = "//button[@class='btn']")
    public WebElement createButton;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement searchBox;


    @FindBy (xpath = "//td[@class='sorting_1']")
    public WebElement nameField;

}
