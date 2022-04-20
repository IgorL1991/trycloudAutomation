package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage extends BasePage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckBox;

    @FindBy(xpath = "//td[@class='selection']//input[@type='checkbox']")
    public List<WebElement> checkBoxList;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionIcon;

    @FindBy(xpath = "//a[@data-action='Favorite']//span[1]")
    public WebElement starFavoriteIcon;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> fileTextName;

    @FindBy(xpath = "//a[@data-action='Favorite']//span[1]/..")
    public WebElement clickAdd_RemoveFavorite;

    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement favorite;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addFileButton;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement upload;
    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement UploadRobot;

    @FindBy(xpath = "//a[@data-action='folder']")
    public WebElement newFolderButton;

    @FindBy(xpath = "//form[@class='filenameform']//input[@type='submit']")
    public  WebElement submitButton;

    @FindBy(xpath = "//a[@class='name']//div[@class='thumbnail']")
    public List<WebElement> folderElements;

    @FindBy(xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement deleteOption;

    @FindBy(xpath = "//a[@class='nav-icon-trashbin svg']")
    public WebElement deletedFilesSubModule;

    @FindBy(xpath = "//a[@data-action='Details']")
    public WebElement detailsOption;

    @FindBy(xpath = "//div[@id='rightClickMenu']//ul//li[6]")
    public WebElement rightClickDeleteOption;

    @FindBy(id = "commentsTabView")
    public WebElement commentsFileFolder;

    @FindBy(xpath = "//form[@class='newCommentForm']//div[@class='message']")
    public WebElement commentForm;

    @FindBy(xpath = "//input[@class='submit icon-confirm has-tooltip']")
    public WebElement commentFileInput;

    @FindBy(xpath = "//li[@class='comment']//div[@class='message']")
    public List<WebElement> commentBody;

    @FindBy(id = "app-settings")
    public WebElement settingsButton;

    @FindBy(xpath = "//div[@id='app-settings-content']//label")
    public List<WebElement> settingButtons;

    @FindBy(xpath = "//div[@id='app-settings-content']//input[@class='checkbox']")
    public List<WebElement> settingCheckBoxes;

    @FindBy(xpath = "//li[@id='quota']//p")
    public WebElement storageMonitor;

    @FindBy(xpath = "//div[@id='rightClickMenu']//ul//li[3]")
    public WebElement rightClickRenameOption;
}
