@tags
Feature: To test Book store using Selenium

@tag1
  Scenario: Login with valid credentials
    When user enters "valid" credentials
    And clicks on Login button
    Then username should be displayed
    
    @tag3
  Scenario: Login with valid credentials and the book is added and Delete the book
    When a Book ISBN "9781449325862" is added using API
    And user enters "valid" credentials
    And clicks on Login button
    And "Git Pocket Guide" is present on Books List
    And user removes "Git Pocket Guide" book
    Then user gets a pop-up with message "Do you want to delete this book?"
    When user clicks on OK button in pop-up
    Then "Book deleted." alert should displayed
    And user accepts the alert
