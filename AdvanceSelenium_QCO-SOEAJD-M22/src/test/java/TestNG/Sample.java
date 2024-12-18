package TestNG;

public class Sample {
	/*
	 TestNG:
Unit testing framework which supports java and .net
TestNG = Junit + Nunit

TestNG for developers:
-> Developers will make use of TESTNG for Unit testing of the source code

TestNG for Automation Testers:
-> Automation Testers will make use of TESTNG for developing the test scripts
   in a more optimised way.

Annotations in TestNG:
-> @Test
-> @BeforeMethod
-> @AfterMethod
-> @BeforeClass
-> @AfterClass
-> @BeforeTest
-> @AfterTest
-> @BeforeSuite
-> @AFterSuite
-> @DataProvider
-> @Listeners
-> @Parameters

@Test Annotation:
-> Will drive the test script execution hence the framework is called TDD- test driven development
-> All annotation method should have access specifier as public and return type as void
-> @Test annotation acts like a main method which is identified by JVM to start the execution
-> One class can consists of multiple @Test annotations
-> Test class name and Test method name should end with TEST
-> Test class name is usually module name
-> Test method name is usually test case name with ID
-> In a Test Class all the @Test will be execute in default execxution order - 
-> default execution order of @Test is alphabetical/ ASCII value
=> To change the execution order of @Test annotations inside a test class: priority in testNg

@Test(priority = int)
-> Lowest priority will execute first
-> Default priority will be 0
-> Negetive priorities are allowed.
-------------------------------------------------------------------------------------------------------------------

public class Sample {

	@Test(priority = 0)
	public void createContact()
	{

	System.out.println("contact created");

	}
    @Test(priority = -1)
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(priority = 1)
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
modify contact
contact created
delete contact
PASSED: createContact
PASSED: modifyContact
PASSED: deleteContact

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================
--------------------------------------------------------------------------------------------------------------------------------------------

=> To run the same test script/ @Test mutiple Times:invocation count in TestNG
@Test(invocationCount = int)
-> Default invocation count is 1
-> If we want to run the same test script more than once then provide invocation count
-> If invocation count is given 0 or negetive values, Then that @Test will not be executed

we can give both invocation count and priority for the same test script
@Test(invocationCount = 4, priority = 2) - priority is given first preference
---------------------------------------------------------------------------------------------------------------------------------------
public class Sample {

	@Test
	public void createContact()
	{

	System.out.println("contact created");

	}
    @Test
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(invocationCount = 2)
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}

contact created
delete contact
delete contact
modify contact
PASSED: deleteContact
PASSED: createContact
PASSED: deleteContact
PASSED: modifyContact

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 4, Passes: 4, Failures: 0, Skips: 0
===============================================
----------------------------------------------------------------------------------------------------------------------------------------------



=> To make the execution of one test script depend on the status(pass/fail) of other test sript
   - DependsOnMethods in TestNG
     @Test(dependsOnMethods = "method name")
   - if one test script should depend on execution status of multiple test scripts like
     @Test(dependsOnMethods = {"method name 1","method name 2"})

public class Sample {

	@Test
	public void createContact()
	{

	System.out.println("contact created");

	}

	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
[RemoteTestNG] detected TestNG version 7.4.0
contact created
delete contact
modify contact
PASSED: modifyContact
PASSED: createContact
PASSED: deleteContact

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================
-------------------------------------------------------------------------------------------------------------------------

public class Sample {

	@Test
	public void createContact()
	{
		int []arr= {1,2,3};
		System.out.println(arr[5]);
	System.out.println("contact created");

	}

	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
===============================================
    Default test
    Tests run: 3, Failures: 1, Skips: 2
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 0, Failures: 1, Skips: 2
===============================================
-------------------------------------------------------------------------------------------------------------------------
	 */

}
