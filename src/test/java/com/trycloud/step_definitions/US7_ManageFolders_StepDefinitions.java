package com.trycloud.step_definitions;
import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class US7_ManageFolders_StepDefinitions {
    FilesPage filesPage = new FilesPage();

    Faker faker = new Faker();

    String folderName = "";
    Actions actions = new Actions(Driver.getDriver());

    @When("user click new folder")
    public void user_click_new_folder() {
        List<String> folderList  = new ArrayList<>();
        filesPage.fileTextName.forEach(p->folderList.add(p.getText()));
        do{
            folderName = "MyFolder_" + faker.numerify("###");
        }while (folderList.contains(folderName));
        filesPage.newFolderButton.click();
    }
    @When("user write a folder name")
    public void user_write_a_folder_name() throws AWTException {
        BrowserUtils.sleep(1);
        StringSelection ss = new StringSelection(folderName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        BrowserUtils.sleep(1);

    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.submitButton.click();
    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        for (WebElement each : filesPage.fileTextName) {
            if(each.getText().equals(folderName)){
                Assert.assertTrue(each.isDisplayed());
            }
        }
    }
    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        //looking for specific element (folder) on the page
        for (WebElement each : filesPage.folderElements) {
            BrowserUtils.sleep(1);
            if(each.getAttribute("style").contains("folder")){
                each.click();
                break;
            }
        }
    }

}
