Feature: Login functionality

  Scenario: login success
    Given user is on saucedemo page
    When user input username
    And user input password
    And user click submit
    Then user in dasboard page

  Scenario: login failed
    Given user is on saucedemo page
    When user input username
    And user input invalid password
    And user click submit
    Then user get error massage
