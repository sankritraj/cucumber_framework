package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import context.TestContext;

public class BaseClass {
	WebDriver driver;
	Properties p;
	TestContext testContext;

	public BaseClass(TestContext testContext) {
		this.testContext = testContext;
	}

	public WebDriver initlizeBrowser() {
		p = properties();
		testContext.setProperties(p);
		String browser = testContext.getProperies().getProperty("browser").toLowerCase();
		System.out.print("Browser is :" + browser+"\n");
		
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
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	public Properties properties() {
		try {
			FileReader fileReader = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			p = new Properties();
			p.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}

}
