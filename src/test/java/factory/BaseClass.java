package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import context.TestContext;

public class BaseClass {
	WebDriver driver;
	Properties p;
	TestContext testContext;
	public Logger LOGGER = Logger.getLogger(BaseClass.class);

	public BaseClass(TestContext testContext) {
		this.testContext = testContext;
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\log4j.properties");
	}

	public WebDriver initlizeBrowser() {
		p = properties();
		testContext.setProperties(p);

		String browser = testContext.getProperies().getProperty("browser").toLowerCase();
		System.out.print("Browser is :" + browser + "\n");
		LOGGER.info("Browser " + browser + " is launched");

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.print("No driver found");
			driver = null;
			LOGGER.error("No Browser found with name " + browser);
		}

		driver.manage().window().maximize();
		LOGGER.info("Window is maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(p.getProperty("implcitiWait"))));
		LOGGER.info("Implicit wait is applied for " + Integer.parseInt(p.getProperty("implcitiWait")));
		return driver;

	}

	public Properties properties() {
		try {
			FileReader fileReader = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			LOGGER.info("Properties file for config is picked from " + System.getProperty("user.dir")
					+ "\\src\\test\\resources\\config.properties");
			p = new Properties();
			p.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}

}
