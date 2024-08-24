package context;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestContext{
	WebDriver driver;
	Properties p;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setProperties(Properties p)
	{
		this.p=p;
	}
	public Properties getProperies() {
		return p;
	}
}
