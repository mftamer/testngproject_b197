package myapp.tests.dataprovider;
import myapp.utilities.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Day17_DataProvider1 {
    //    DataProvider Method works with 2D Array
//    We don't need TO LOOP to pass all data sets…
//    DataProvider annotation ensures that all data sets are provided to test method one by one
//    DataProvider Method 1
    @DataProvider
    public Object[][] productListProvider(){
        Object[][] productList = {{"BMW"}, {"volvo"}, {"Toyota"} ,{"Tesla"}, {"Mercedes"}};
        return productList;
    }
    //    Test Method 1
    @Test (dataProvider = "productListProvider")  // call the DataProvider Method by its name and connect with the test method
    public void test1(String data){
        System.out.println(data);
    }
    //    DataProvider Method 2
    @DataProvider (name= "employee_credentials")  // you can also give a customized name to @DataProvider and use that to connect with TEST METHOD
    public Object[][] credentialProvider(){
        Object[][] credentialList = {
                {"admin1", "pass1", "CEO", "52"},
                {"admin2", "pass2", "SDET", "45"},
                {"admin3", "pass3", "PM", "38"},
                {"admin4", "pass4", "QA", "30"}
        };
        return credentialList;
    }
    //    Test Method 2
    // call the DataProvider Method by its name and connect with the test method
    // If the DataProvider Method has a customised name, we cant use its original method name
//    @Test (dataProvider = "credentialProvider")
//    public void test2(String username, String password, String title, String age){
//        System.out.println("UserName: " + username+ " | Password: " + password+ " | Title: " +title+ " | Age: "+ age);
//    }
    //    Test Method 3
    @Test (dataProvider = "employee_credentials") // You can ALSO call the DataProvider Method by its customized name
    public void test3(String username, String password, String title, String age){
        System.out.println("UserName: " + username+ " | Password: " + password+ " | Title: " +title+ " | Age: "+ age);
    }
    //    NOTE: we should write DataProvider methods in UTILS class to implement DRY Rule (Don't Repeat Yourself)
//    When DataProvider methods are stored in a different class (like in UTILS class), we have to provide the NAME OF THAT CLASS too
//    Test Method 4 => works with DataProviderUtils class
    @Test (dataProvider = "employeeCredentialsProvider" , dataProviderClass = DataProviderUtils.class)
    public void test4(String email, String password){
        System.out.println("Email: " + email+ " | Password: " + password);
    }
    //    Test Method 5 => works with DataProviderUtils class + Excel-sheet
    @Test (dataProvider = "excelEmployeeData" , dataProviderClass = DataProviderUtils.class)
    public void test5(String email, String password){
        System.out.println("Email: " + email+ " | Password: " + password);
    }
}
