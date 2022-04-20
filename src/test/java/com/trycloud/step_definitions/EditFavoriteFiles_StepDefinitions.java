package com.trycloud.step_definitions;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


public class EditFavoriteFiles_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    String expectedFileName = "";
    int i = 0;
    //String path = "C:\\Users\\leahu\\Desktop\\anonymous.jpg";
    String path = "C:\\Users\\leahu\\Desktop\\QA Image.png";
    Actions actions = new Actions(Driver.getDriver());
    @When("user click action-icon from any file on the page to remove")
    public void user_click_action_icon_from_any_file_on_the_page_to_remove() {
        if(filesPage.actionIcon.isEmpty()){
            System.out.println("There is no files at all");
            System.exit(0);
        }else {
            for (WebElement each : filesPage.actionIcon) {
                each.click();
                if (filesPage.starFavoriteIcon.getAttribute("class").contains("dark")) {
                    break;
                }
                i++;
                each.click();
            }
        }
    }

    @When("user choose the Remove from favorites option")
    public void user_choose_the_remove_from_favorites_option() {
        if(i == filesPage.actionIcon.size()){
            throw new RuntimeException("There is no files in favorite at all !");
        }
        expectedFileName = filesPage.fileTextName.get(i).getText();
        filesPage.clickAdd_RemoveFavorite.click();
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        List<String> actualFavoriteFileNames = new ArrayList<>();
        filesPage.fileTextName.forEach(p -> actualFavoriteFileNames.add(p.getText()));
        System.out.println("Recent file name removed from Favorite: " + expectedFileName);
        Assert.assertFalse(actualFavoriteFileNames.contains(expectedFileName));
    }


    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        //checking for existing File with same name if yes delete it to avoid conflicts
        for (WebElement each : filesPage.fileTextName) {
            if(each.getText().equals(path.substring(path.lastIndexOf('\\')+1,path.indexOf('.')))){
                BrowserUtils.sleep(1);
                actions.contextClick(each).perform();
                BrowserUtils.sleep(1);
                filesPage.rightClickDeleteOption.click();
            }
        }
        filesPage.addFileButton.click();
    }
    //Uploading File from computer
    @When("users uploads file with the upload file option")
    public void users_uploads_file_with_the_upload_file_option(){
        filesPage.upload.sendKeys(path);
        BrowserUtils.sleep(2);
        Driver.getDriver().navigate().refresh();
    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        String uploadedFileName = path.substring(path.lastIndexOf('\\')+1,path.indexOf('.'));
        BrowserUtils.sleep(1);
        List<String> actualNames = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

        filesPage.fileTextName.forEach(p->actualNames.add(p.getText()));
        //wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//*[.='+uploadedFileName+']"))));
        System.out.println("File uploaded: " + uploadedFileName);
        Assert.assertTrue(actualNames.contains(uploadedFileName));
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
