Feature: As a user, I should be able to search any item/users the homepage.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @Search
  Scenario Outline: Verify users can search any files/folder/users/from the search box.
    When the user click the search icon on the right top
    And users "<search>" any existing file, folder or user name
    Then verify the app displays the expected "<result>" option.
    Examples:
      | search          | result          |
      | Muhtar          | Muhtar          |
      | Test28          | Test28          |
      | appleMouse.jpeg | appleMouse.jpeg |