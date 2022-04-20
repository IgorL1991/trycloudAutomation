Feature: As a user, I should be able to manage folders.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @AddFolder
  Scenario: Verify users can add the folder
    When the user clicks the Files module
    And the user clicks the add icon on the top
    And user click new folder
    And user write a folder name
    When the user click submit icon
    Then Verify the folder is displayed on the page

  @UploadFileInsideFolder
  Scenario: Verify users can upload a file inside a folder
    When the user clicks the Files module
    And user choose a folder from the page
    And the user clicks the add icon on the top
    When users uploads file with the upload file option
    Then verify the file is displayed on the page