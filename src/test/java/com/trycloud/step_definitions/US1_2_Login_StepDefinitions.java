package com.trycloud.step_definitions;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US1_2_Login_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    @Given("user on the login page")
    public void user_on_the_login_page() {
    }

    @When("user use username {string} and password {string}")
    public void user_use_username_and_password(String username, String password) {
        loginPage.userInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.logInButton.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("Dashboard"));
    }

    @When("user use invalid {string} and password {string}")
    public void user_use_invalid_and_password(String username, String password) {
        loginPage.userInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String expectedMessage) {
        String actualMessage = loginPage.invalidLoginMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
