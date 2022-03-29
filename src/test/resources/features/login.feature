Feature: TryCloud app login feature
  User Story:
  As a user, I should be able to log in.

  @ValidLogIn
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user use username "<username>" and password "<password>"
    And user click the login button
    Then verify the user should be at the dashboard page
    Examples:
      | username | password    |
      | User2    | Userpass123 |
      | User32   | Userpass123 |
      | User62   | Userpass123 |
      | User92   | Userpass123 |

  @InvalidLogin
  Scenario Outline: Verify user login fail with invalid credentials
    Given user on the login page
    When user use invalid "<username>" and password "<password>"
    And user click the login button
    Then verify "<message>" message should be displayed
    Examples:
      | username | password    | message                     |
      | User2    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |