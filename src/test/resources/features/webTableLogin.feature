Feature: User should be able to login using correct credentials

  Background: user is on the login page
    Given user is on the login page of web table app
  @smoke
  Scenario: Positive login scenario
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks to login button
    Then user should see url contains orders

@wip
  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders

    #imlement this new step
  #ceate login method in webtableloginPage
  #yhis login method should multiple differnr overloaded version