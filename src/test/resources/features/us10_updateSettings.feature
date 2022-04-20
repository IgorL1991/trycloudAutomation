Feature: As a user, I should be able to update settings.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @UpdateSettings
  Scenario: Verify users update settings
    When the user clicks the Files module
    And user clicks Settings on the left bottom corner
    Then the user should be able to click any buttons

  @AppStorage
  Scenario: Verify users to see the app storage usage
    When the user clicks the Files module
    And user checks the current storage usage
    And users uploads file with the upload file option
    And user refresh the page
    Then the user should be able to see storage usage is increased