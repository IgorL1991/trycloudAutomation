package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.FilesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class US9_CommentFileFolder_StepDefinitions {
    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();
    String expectedMessage = "Test test, cool cool cool" + faker.numerify("-###");
    @When("user choose the Details option")
    public void user_choose_the_option() {
        filesPage.detailsOption.click();
    }
    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        filesPage.commentsFileFolder.click();
        filesPage.commentForm.sendKeys(expectedMessage);
    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filesPage.commentFileInput.click();
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        List<String> actualComments = new ArrayList<>();
        System.out.println(expectedMessage);
        filesPage.commentBody.forEach(p->actualComments.add(p.getText()));
        Assert.assertTrue(actualComments.contains(expectedMessage));

    }
}
