Feature: Access all main modules of the app

  Background: User is expected to be on dashboard page
    Given user on the login page
    When users log in with valid credentials

  @AllMainModules
  Scenario: Verify user accessing all the main modules of the app.
    Then verify the user see the following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |