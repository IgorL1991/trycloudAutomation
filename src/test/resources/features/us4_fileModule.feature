Feature: As a user, I should be able to access to File module.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @FileModule
  Scenario: verify can access to Files module
    When the user clicks the Files module
    Then verify the page title is "Files - Trycloud"

  @SelectAllCheckBoxes
  Scenario: verify user can select all the uploaded files from the page
    When the user clicks the Files module
    And user click the top-left checkbox of the table
    Then verify all the files are selected