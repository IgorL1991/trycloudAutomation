Feature: Access all main modules of the app
  User Story:
  As a user, I should be accessing all the main modules of the app.

  @AllMainModules
  Scenario: Verify user accessing all the main modules of the app.
    Given user on the login page
    When users log in with valid credentials
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