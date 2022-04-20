package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UpdateSettings_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    double storageBefore = 0;
    double storageAfter = 0;

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settingsButton.click();
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        int index = 0;
        //getting all 3 checkBoxes from Settings
        for (WebElement each : filesPage.settingCheckBoxes) {
            if (each.isSelected()) {
                filesPage.settingButtons.get(index++).click();
                Assert.assertFalse(each.isSelected());
            } else {
                filesPage.settingButtons.get(index++).click();
                Assert.assertTrue(each.isSelected());
            }
        }
    }

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        String before = filesPage.storageMonitor.getText().substring(0,filesPage.storageMonitor.getText().indexOf(" "));
        storageBefore = Double.parseDouble(before);
        System.out.println("Before storage: " + storageBefore);
        filesPage.addFileButton.click();
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        String after = filesPage.storageMonitor.getText().substring(0,filesPage.storageMonitor.getText().indexOf(" "));
        storageAfter = Double.parseDouble(after);
        System.out.println("Before storage: " + storageAfter);
        Assert.assertTrue(storageAfter>storageBefore);

        //checking for existing File with same name if yes delete it to avoid conflicts
        String path = "C:\\Users\\leahu\\Desktop\\QA Image.png";
        Actions actions = new Actions(Driver.getDriver());
        for (WebElement each : filesPage.fileTextName) {
            if(each.getText().equals(path.substring(path.lastIndexOf('\\')+1,path.indexOf('.')))){
                BrowserUtils.sleep(1);
                actions.contextClick(each).perform();
                BrowserUtils.sleep(1);
                filesPage.rightClickDeleteOption.click();
            }
        }
    }

}
