package com.trycloud.step_definitions;

import com.trycloud.pages.HomePage;
import com.trycloud.pages.TalkPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class TalksModule_StepDefinitions {
    HomePage homePage = new HomePage();
    TalkPage talkPage = new TalkPage();
    String userName = "Group2";
    String message = "Anonymous test !";

    @When("the user clicks the Talk module")
    public void the_user_clicks_the_talk_module() {
        homePage.TalkModule.click();
    }

    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {
        talkPage.conversationsSearchBar.sendKeys(userName);

        if (talkPage.userNamesList.isEmpty()) {
            throw new RuntimeException("Name: (" + userName + ") not found !");

        } else {
            for (WebElement each : talkPage.userNamesList) {
                if (each.getText().equals(userName)) {
                    each.click();
                }
            }
        }

    }

    @When("user write a message")
    public void user_write_a_message() {
        talkPage.messageInputBox.click();
        talkPage.messageInputBox.sendKeys(message);

    }

    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        talkPage.messageSubmitButton.click();
    }

    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() {
        //getting last message from list
        Assert.assertEquals(talkPage.messagesList.get(talkPage.messagesList.size() - 1).getText(), message);

    }
}
