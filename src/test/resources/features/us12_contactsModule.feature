Feature: Access Contacts module

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @ContactsModule
  Scenario: verify user access to Talk module
    When user click the Contacts module
    Then page title is "Contacts - Trycloud"