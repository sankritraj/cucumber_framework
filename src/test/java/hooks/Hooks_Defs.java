package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.TestContext;
import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks_Defs {
	TestContext testContext;
	WebDriver driver = null;
	Properties p;
	BaseClass baseClass;

	public Hooks_Defs(TestContext testContext) {
		this.testContext = testContext;
		baseClass = new BaseClass(testContext);
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

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) testContext.getDriver();
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
