package com.trycloud.step_definitions;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class EditFavoriteFiles_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    String expectedFileName = "";
    int i = 0;
    String path = "C:\\Users\\leahu\\Desktop\\anonymous.jpg";
    @When("user click action-icon from any file on the page to remove")
    public void user_click_action_icon_from_any_file_on_the_page_to_remove() {
        for (WebElement each : filesPage.actionIcon) {
            each.click();
            if (filesPage.starFavoriteIcon.getAttribute("class").contains("dark")) {
                break;
            }
            i++;
            each.click();
        }
    }

    @When("user choose the Remove from favorites option")
    public void user_choose_the_remove_from_favorites_option() {
        expectedFileName = filesPage.fileTextName.get(i).getText();
        filesPage.clickAdd_RemoveFavorite.click();
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        List<String> actualFavoriteFileNames = new ArrayList<>();
        filesPage.fileTextName.forEach(p -> actualFavoriteFileNames.add(p.getText()));
        System.out.println("Recent file name added to Favorite: " + expectedFileName);
        Assert.assertFalse(actualFavoriteFileNames.contains(expectedFileName));
    }


    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.addFileButton.click();
        BrowserUtils.sleep(1);
    }
    //Uploading File from computer
    @When("users uploads file with the upload file option")
    public void users_uploads_file_with_the_upload_file_option() throws AWTException {
        filesPage.upload.click();
        BrowserUtils.sleep(1);
        StringSelection ss = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //native key strokes for CTRL, V and ENTER keys
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        BrowserUtils.sleep(1);
    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        String uploadedFileName = path.substring(path.lastIndexOf('\\')+1,path.indexOf('.'));
        BrowserUtils.sleep(1);
        List<String> actualNames = new ArrayList<>();
        filesPage.fileTextName.forEach(p->actualNames.add(p.getText()));
        Assert.assertTrue(actualNames.contains(uploadedFileName));
    }
}
