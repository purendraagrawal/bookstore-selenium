@tags
Feature: To test Book store using Selenium in Parallel
    
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