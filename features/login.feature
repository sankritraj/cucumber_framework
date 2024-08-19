Feature: User Login

  Scenario: Sucessfull Login
    Given user is on the Demo login page
    When user enters valid credentials(username: "demo.test", password: "Test#@12345")
    And click on the login button
    Then user should redrirect to accountpage
    And user see bookstore page
