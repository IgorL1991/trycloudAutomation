Feature: As a user, I should be able to delete a file/folder

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @DeleteFile/Folder
  Scenario: Verify users delete a file/folder
    When the user clicks the Files module
    And user clicks action-icon from any file on page
    And user choose the Delete file option
    When the user clicks the Deleted files sub-module on the left side
    Then Verify the deleted file is displayed on the page.