Feature: TryCloud app login feature

  Background: For this scenario, user is expected to be on login page
    Given user on the login page

  @ValidLogIn
  Scenario Outline: Verify login with valid credentials
    And user use username "<username>" and password "<password>"
    When user click the login button
    Then verify the user should be at the dashboard page

    Examples:
      | username | password    |
      | User2    | Userpass123 |
      | User32   | Userpass123 |
      | User62   | Userpass123 |
      | User92   | Userpass123 |

  @InvalidLogin
  Scenario Outline: Verify user login fail with invalid credentials
    When user use invalid "<username>" and password "<password>"
    And user click the login button
    Then verify "<message>" message should be displayed
    Examples:
      | username | password    | message                     |
      | User2    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |