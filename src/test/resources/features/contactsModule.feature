Feature: Access Contacts module
  User Story:
  As a user, I should be able to access to Contacts module.

  @ContactsModule
  Scenario: verify user access to Talk module
    Given user on the dashboard page
    When user click the Contacts module
    Then page title is "Contacts - Trycloud QA"