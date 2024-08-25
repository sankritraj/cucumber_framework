package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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

	@SuppressWarnings("deprecation")
	public WebDriver initlizeBrowser() {
		p = properties();
		testContext.setProperties(p);

		String browser = testContext.getProperies().getProperty("browser").toLowerCase();
		System.out.print("Browser is :" + browser + "\n");
		LOGGER.info("Browser " + browser + " is launched");

		/* checking execution location */
		String location = testContext.getProperies().getProperty("environment").toLowerCase();
		if (location.equalsIgnoreCase("remote")) {
			String hubUrl = testContext.getProperies().getProperty("hubUrl");
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			String platformName = testContext.getProperies().getProperty("platform").toUpperCase();

			switch (platformName) {
			case "WINDOW":
				desiredCapabilities.setPlatform(Platform.WIN11);
				break;
			default:
				System.out.print("No platfrom found");
				driver = null;
				LOGGER.error("No platfrom found with name " + platformName);

			}
			switch (browser) {
			case "chrome":
				desiredCapabilities.setBrowserName("chrome");
				LOGGER.info("The thread ID for Chrome is "+ Thread.currentThread().threadId());
				break;
			case "firefox":
				desiredCapabilities.setBrowserName("firefox");
			case "edge":
				desiredCapabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.print("No driver found");
				driver = null;
				LOGGER.error("No Browser found with name " + browser);
			}
			try {
				driver = new RemoteWebDriver(new URL(hubUrl), desiredCapabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (location.equalsIgnoreCase("local")) {

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
