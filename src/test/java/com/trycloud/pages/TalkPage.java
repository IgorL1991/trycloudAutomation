package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage {
    public TalkPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Search conversations or users']")
    public WebElement conversationsSearchBar;

    @FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public List<WebElement> userNamesList;

    @FindBy(xpath = "//div[@class='new-message-form__advancedinput']")
    public WebElement messageInputBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement messageSubmitButton;

    @FindBy(xpath = "//div[@class='message-group']//div[@class='rich-text--wrapper']")
    public List<WebElement> messagesList;
}
