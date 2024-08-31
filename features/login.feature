Feature: User Login

@regression
  Scenario: Sucessfull Login
    Given user is on the Demo login page
    When user login with valid credentials(username: "demo.create", password: "Test#@12345")
    Then user should redrirect to accountpage
    And user see bookstore page
    
    @regression
Scenario: Sucessfull Login1
    Given user is on the Demo login page
    When user login with valid credentials(username: "demo.create", password: "Test#@123451")
    Then user should redrirect to accountpage
    And user see bookstore page
    
  