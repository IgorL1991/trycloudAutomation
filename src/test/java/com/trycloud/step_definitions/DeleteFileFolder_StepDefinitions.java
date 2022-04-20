package com.trycloud.step_definitions;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeleteFileFolder_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    String deletedFileName = "";
    Random random = new Random();
    int randomFileIndex = random.nextInt(filesPage.actionIcon.size());
    @And("user clicks action-icon from any file on page")
    public void user_Clicks_ActionIcon_FromAnyFileOnPage() {
        if (filesPage.actionIcon.isEmpty()) {
            throw new RuntimeException("There is no files at all");
        } else {
            System.out.println(randomFileIndex);
            //getting name of a deleted file
            deletedFileName = filesPage.fileTextName.get(randomFileIndex).getText();
            //scroll down to selected File
            BrowserUtils.scrollToElement(filesPage.actionIcon.get(randomFileIndex));
            //click action Icon on selected File
            filesPage.actionIcon.get(randomFileIndex).click();
            BrowserUtils.sleep(2);

        }
    }

    @When("user choose the Delete file option")
    public void user_choose_the_delete_file_option() {
        //click on Delete button
        filesPage.deleteOption.click();
    }

    @When("the user clicks the Deleted files sub-module on the left side")
    public void the_user_clicks_the_deleted_files_sub_module_on_the_left_side() {
        //click to Delete
        filesPage.deletedFilesSubModule.click();
    }

    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {
        System.out.println("Deleted file name: " + deletedFileName);
        List<String> allDeletedFiles = new ArrayList<>();
        filesPage.fileTextName.forEach(p -> allDeletedFiles.add(p.getText()));
        //checking if the deleted file name is in list of "Deleted Files"
        Assert.assertTrue(allDeletedFiles.contains(deletedFileName));
    }
}
