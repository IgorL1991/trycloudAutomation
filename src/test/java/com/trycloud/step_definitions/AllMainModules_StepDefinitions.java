package com.trycloud.step_definitions;

import com.trycloud.pages.HomePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AllMainModules_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @When("users log in with valid credentials")
    public void users_log_in_with_valid_credentials() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
    }

    @Then("verify the user see the following modules")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules = new ArrayList<>();
        //homePage.allMainModules.forEach(BrowserUtils::hover);
        Actions actions = new Actions(Driver.getDriver());
        homePage.allMainModules.forEach(p -> actions.moveToElement(p).perform());
        homePage.allMainModules.forEach(p->actualModules.add(p.getText()));
        Assert.assertEquals(expectedModules, actualModules);
    }
}
