package context;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class TestContext {
	WebDriver driver;
	Properties p;
	LoginPage loginPage;
	ScenarioContext scenarioContext;

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setProperties(Properties p) {
		this.p = p;
	}

	public Properties getProperies() {
		return p;
	}

	public void initlizePageObjects(WebDriver driver) {
		loginPage = new LoginPage(driver);
		scenarioContext = new ScenarioContext();
	}
}
