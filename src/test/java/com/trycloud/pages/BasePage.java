package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class  BasePage {

    /*
    In this class will store WebElements common to all pages
     */

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@data-id='contacts'])[1]")
    public WebElement contactsModule;

    @FindBy(xpath = "//li[@tabindex='-1']//span")
    public List<WebElement> allMainModules;

    @FindBy(xpath = "//ul[@id='appmenu']//li[2]")
    public WebElement filesModule;
}
