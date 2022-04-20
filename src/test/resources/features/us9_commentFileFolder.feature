Feature: As a user, I should be able to write comments to files/folders.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @CommentFileFolder
  Scenario: Verify users to write comments to files/folder
    When the user clicks the Files module
    And user clicks action-icon from any file on page
    And user choose the Details option
    And user write a comment inside the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section.