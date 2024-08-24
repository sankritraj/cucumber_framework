package stepsDefinitions;

import java.util.Properties;

import context.Context;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepsDef {
	TestContext testContext;
	Properties p;

	public Login_StepsDef(TestContext testContext) {
		this.testContext = testContext;

	}

	@Given("user is on the Demo login page")
	public void user_is_on_the_demo_login_page() {

		testContext.getDriver().get(testContext.getProperies().getProperty("base_url"));

	}

	@When("user login with valid credentials\\(username: {string}, password: {string})")
	public void user_enters_valid_credentials_username_password(String userName, String password) {

		testContext.getLoginPage().do_login(userName, password);
		testContext.getScenarioContext().setContext(Context.USERNAME, userName);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {

	}

	@Then("user should redrirect to accountpage")
	public void user_should_redrirect_to_accountpage() {
		System.out.println(
				"Logged In Username is : " + testContext.getScenarioContext().getContext(Context.USERNAME));
	}

	@Then("user see bookstore page")
	public void user_see_bookstore_page() {

	}

}
