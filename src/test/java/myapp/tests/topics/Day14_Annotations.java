package myapp.tests.topics;

import org.testng.annotations.*;

public class Day14_Annotations {

    /*
    @Test: is the most used annotation to create test cases - just like JUnit
    @Before and @After annotations: there are 5 before and after annotations

    Hierarchy: suite > test > group > class > method ………… this provides better control on the flow

    @Ignore: used to ignore/skip a test
    @Test (enabled = false): disables the test; another way of ignoring the test method (stronger way)

    By default, test run from top to bottom, following ascending / alphabetical order,
    So, if we want to run any particular test first, we can mention priority for the test case
    @Test (priority = 3) will run this test case at number 3.
    We can also sue negative number; but that's not common and recommended

    We can also group tests together by passing group = "name of the group" in @Test parameter to run all tests under one group
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite ...");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class...");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups....");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test...");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method...");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite....");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class....");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("After groups....");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test....");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method....");
    }

    @Test (priority = 2, groups = "Smoke Test")
    public void test1(){
        System.out.println("Test case 1 ......");
    }
    @Test @Ignore
    public void test2(){
        System.out.println("Test case 2 ......");
    }
    @Test (enabled = false) //this is a strong way to disable test
    public void test3(){
        System.out.println("Test case 3 ......");
    }
    @Test (priority = 3)
    public void test4(){
        System.out.println("Test case 4 ......");
    }
    @Test (priority = 1, groups = "Smoke Test")
    public void test5(){
        System.out.println("Test case 5 ......");
    }
}
