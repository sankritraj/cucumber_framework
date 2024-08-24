Feature: User Login

  Scenario: Sucessfull Login
    Given user is on the Demo login page
    When user login with valid credentials(username: "demo.create", password: "Test#@12345")
    Then user should redrirect to accountpage
    And user see bookstore page
