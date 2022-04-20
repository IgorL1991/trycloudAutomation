Feature: As a user, I should be able to view the contact list.

  Background: User is expected to be on dashboard page
    Given user on the dashboard page

  @ContactList
  Scenario: verify users can see all the contact names on the contact list
    When the user clicks the contacts module
    Then verify the contact names are in the list
      | Muhtar |
      | Gurhan |
      | Mike   |
      | Test   |


    #(Pre-condition: there should be at least 2 contact names are displayed
    #On the contact list so that view list function can be tested)
