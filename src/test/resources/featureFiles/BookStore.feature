@tags
Feature: To test Book store using Selenium

@tag1
  Scenario: Login with valid credentials
    When user enters "valid" credentials
    And clicks on Login button
    Then username should be displayed
    
@tag2
  Scenario: Login with valid credentials and add book
    When user enters "valid" credentials
    And clicks on Login button
    Then username should be displayed
    When user clicks on "Book Store" page
    And user clicks on "Git Pocket Guide" book
    Then "Git Pocket Guide" title page should be displayed
    When user clicks on Add To Your Collection button
    Then "Book added to your collection." alert should displayed
    And user accepts the alert
    Then Delete the Book ISBN "9781449325862" using API
    
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
