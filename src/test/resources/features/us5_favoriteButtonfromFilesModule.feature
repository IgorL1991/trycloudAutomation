Feature: As a user, I should be able to access to Files module - Favorites button

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @FavoriteButton
  Scenario: Verify user to add files to Favorites
    When the user clicks the Files module
    Then the user clicks action-icon from any file on page
    And user choose Add to favorites option
    And user click the Favorites sub-module on the left side
    Then Verify the chosen file is listed on the table