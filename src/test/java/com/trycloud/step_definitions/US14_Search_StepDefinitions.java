package com.trycloud.step_definitions;

import com.trycloud.pages.HomePage;
import com.trycloud.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US14_Search_StepDefinitions {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    @When("the user click the search icon on the right top")
    public void the_user_click_the_search_icon_on_the_right_top() {
        homePage.searchIcon.click();
    }
    @And("users {string} any existing file, folder or user name")
    public void users_search_any_existing_file_folder_user_name(String search) {
        searchPage.searchInput.sendKeys(search);
    }
    @Then("verify the app displays the expected {string} option.")
    public void verify_the_app_displays_the_expected_result_option(String expectedResult) {
        List<String> actualSearchList = new ArrayList<>();
        searchPage.searchList.forEach(p->actualSearchList.add(p.getText()));
        System.out.println("actualSearchList = " + actualSearchList);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertTrue(actualSearchList.contains(expectedResult));
    }
}
