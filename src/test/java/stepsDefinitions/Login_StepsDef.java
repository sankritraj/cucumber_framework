package stepsDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepsDef {
	TestContext testContext;

	public Login_StepsDef(TestContext testContext)
	{
		this.testContext=testContext;
	}

	@Given("user is on the Demo login page")
	public void user_is_on_the_demo_login_page() {
		testContext.getDriver().get("https://demoqa.com/login");

	}

	@When("user enters valid credentials\\(username: {string}, password: {string})")
	public void user_enters_valid_credentials_username_password(String string, String string2) {

	}

	@When("click on the login button")
	public void click_on_the_login_button() {

	}


	@Then("user should redrirect to accountpage")
	public void user_should_redrirect_to_accountpage() {

	}

	@Then("user see bookstore page")
	public void user_see_bookstore_page() {

	}


}
