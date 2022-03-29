package com.trycloud.step_definitions;

import com.trycloud.pages.HomePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactsModule_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login("User2", "Userpass123");
    }
    @When("user click the Contacts module")
    public void user_click_the_module() {
        homePage.contactsModule.click();
    }
    @Then("page title is {string}")
    public void page_title_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
