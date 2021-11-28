@tag
Feature: To test Book store using Selenium

  @tag1
  Scenario: Login with valid credentials
    When user enters "username" in "username" textbox
    And user enters "Password0-9@" in "password" textbox
    And clicks on Login button
    Then "username" should be displayed
