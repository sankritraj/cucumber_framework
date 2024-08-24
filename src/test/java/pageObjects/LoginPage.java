package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	}
	
	public void send_password(String user_Password)
	{
		password.sendKeys(user_Password);
	}
	
	public void click_button()
	{
		button_login.click();
	}
	public void do_login(String userName, String password)
	{
		send_userName(userName);
		send_password(password);
		click_button();
	}
	
	

}
