package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keywords {
	public Logger LOGGER = Logger.getLogger(Keywords.class);

	public void customCick(WebElement element, WebDriver driver) {
		try {
			element.click();
			LOGGER.info(element + " is clicked");
		} catch (Exception e) {
			LOGGER.error("Unable to click " + element + " Using Javascript executor now");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			LOGGER.info(element + " is clicked by Javascript executor");
		}
	}

}
