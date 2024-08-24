package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks_Defs{
	TestContext testContext;
	WebDriver driver = null;
	Properties p;
	BaseClass baseClass;

	public Hooks_Defs(TestContext testContext) {
		this.testContext = testContext;
		baseClass=new BaseClass(testContext);
	}

	@Before
	public void setUp() {
		System.out.print("Inside setup \n");
		driver = baseClass.initlizeBrowser();
		testContext.setDriver(driver);
		testContext.initlizePageObjects(driver);

	}

	@After
	public void tearDown() {
		testContext.getDriver().quit();
	}

}
