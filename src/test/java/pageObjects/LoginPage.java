package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.BaseClass;
import jdk.internal.org.jline.utils.Log;
import utilities.Keywords;


public class LoginPage {

	WebDriver driver;
	Keywords keywords;
	public Logger LOGGER = Logger.getLogger(LoginPage.class);
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		keywords= new Keywords();
		
	}

	@FindBy(id = "userName")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement button_login;
	
	public void send_userName(String user_Name)
	{
		userName.sendKeys(user_Name);
		LOGGER.info("Username "+user_Name+" is entered");
	}
	
	public void send_password(String user_Password)
	{
		password.sendKeys(user_Password);
		LOGGER.info("Password "+user_Password+" is entered");
	}
	
	public void click_button()
	{
		keywords.customCick(button_login, driver);
	}
	public void do_login(String userName, String password)
	{
		send_userName(userName);
		send_password(password);
		click_button();
	}
	
	

}
