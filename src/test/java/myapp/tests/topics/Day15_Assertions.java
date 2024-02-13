package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day15_Assertions {

/*
In JUnit, we had only HARD ASSERTION
In TestNG, we have two types of Assertions ==> HARD and SOFT
HARD ASSERTION works the same in TestNg as it works in JUnit.
It stops executing the rest of the test if assertion fails at any point. We get the error message/exception straight away

SOFT ASSERTION is different in a sense that it doesn't stop executing the test if it fails at any point.
It continues executing the test and inform in the end which step the test failed at.
ONLY IF WE USE assertAll() as a last step
assertAll() is mandatory last step.
 */

    @Test (groups = "minor_regression_group")
    public void hardAssert(){
        System.out.println("Checking how hard assertion works");
        Assert.assertTrue(true); //passes
        System.out.println("Line 24");
        Assert.assertTrue(false); //fails at this point, so the rest of the test is not executed
        System.out.println("Line 26");
    }

    @Test
    public void javaAssert(){
        /*
        This comes from Java library. It works the same way as HARD ASSERTION,
        But we (testers) prefer TestNG assertions, specially HARD ASSERTION
         */

        System.out.println("Line 36");
        assert 3<5; //  PASS
        System.out.println("Line 38");
        assert "Apple".toLowerCase().contains("a"); // Pass
        System.out.println("Line 40");
        assert "apple"=="apple"; //Pass
        System.out.println("Line 42");
        assert "java".equals("selenium"); //Fails
        System.out.println("Line 44"); //doesn't print
    }

    @Test
    public void softAssert(){
        /*
        If Soft Assertion fails at any step. It continues to execute the test steps

        1. Create Soft Assertion object
        2. Use the Soft Assertion method such as assertEquals(), assertTrue() etc.
        3. Use assertAll() as a last step, otherwise you can't find out if the test step failed or not
         */
        System.out.println("Line 57");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(5,5);
        System.out.println("Line 60");
        softAssert.assertTrue("Apple".toLowerCase().contains("a"));
        System.out.println("Line 62");
        softAssert.assertTrue("apple".equals("orange"));
        System.out.println("Line 64");

        softAssert.assertTrue("pineapple".equals("grapes"));
        System.out.println("Line 67");
        softAssert.assertAll();
    }
}
