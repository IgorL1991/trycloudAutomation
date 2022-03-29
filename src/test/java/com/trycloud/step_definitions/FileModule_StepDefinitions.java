package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.pages.HomePage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileModule_StepDefinitions {
    HomePage homePage = new HomePage();
    FilesPage filesPage = new FilesPage();

    @When("the user clicks the Files module")
    public void the_user_clicks_the_files_module() {
        homePage.filesModule.click();
    }
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.selectAllCheckBox.click();
    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        filesPage.checkBoxList.forEach(p-> Assert.assertTrue(p.isSelected()));
    }
}
