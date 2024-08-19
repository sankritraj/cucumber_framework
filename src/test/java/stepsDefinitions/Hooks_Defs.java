package stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Defs {
	TestContext testContext;
	WebDriver driver=null;
	public Hooks_Defs(TestContext testContext)
	{
		this.testContext=testContext;
	}
	@Before
	public void setUp()
	{
		System.out.print("Inside setup");
		driver= new ChromeDriver();
		testContext.setDriver(driver);

	}
	@After
	public void tearDown() {
		testContext.getDriver().quit();
	}


}
