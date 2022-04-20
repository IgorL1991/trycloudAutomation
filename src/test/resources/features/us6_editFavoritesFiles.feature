Feature:As a user, I should be able to remove files from favorites and upload a file directly.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @RemoveFromFavorite
  Scenario:verify users to remove files to Favorites
    When the user clicks the Files module
    When user click action-icon from any file on the page to remove
    And user choose the Remove from favorites option
    And user click the Favorites sub-module on the left side
    Then Verify that the file is removed from the Favorites sub-module’s table

  @UploadFile
  Scenario: verify users to upload a file from Files
    When the user clicks the Files module
    When the user clicks the add icon on the top
    And users uploads file with the upload file option
    Then verify the file is displayed on the page