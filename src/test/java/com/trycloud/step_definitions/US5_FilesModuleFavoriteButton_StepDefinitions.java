package com.trycloud.step_definitions;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class US5_FilesModuleFavoriteButton_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    String expectedFileName = "";
    int i = 0;
    @Then("the user clicks action-icon from any file on page")
    public void the_user_clicks_action_icon_from_any_file_on_page() {
        if(filesPage.actionIcon.isEmpty()){
            System.out.println("There is no files at all");
            System.exit(0);
        }else{
            for (WebElement each : filesPage.actionIcon) {
                each.click();
                if (filesPage.starFavoriteIcon.getAttribute("class").contains("starred")) {
                    break;
                }
                i++;
                each.click();
            }
        }

    }
    @Then("user choose Add to favorites option")
    public void user_choose_add_to_favorites_option() {
        expectedFileName = filesPage.fileTextName.get(i).getText();
        filesPage.clickAdd_RemoveFavorite.click();
    }
    @Then("user click the Favorites sub-module on the left side")
    public void user_click_the_favorites_sub_module_on_the_left_side() {
        filesPage.favorite.click();
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        List<String> actualFavoriteFileNames = new ArrayList<>();
        filesPage.fileTextName.forEach(p -> actualFavoriteFileNames.add(p.getText()));
        System.out.println("Recent file name added to Favorite: " + expectedFileName);
        Assert.assertTrue(actualFavoriteFileNames.contains(expectedFileName));
    }

}
