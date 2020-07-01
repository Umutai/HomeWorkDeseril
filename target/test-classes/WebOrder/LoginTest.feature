Feature: WebOrder Login page Test
  @smoke
  Scenario: Login Page Positive Test
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    And the demoUser validate the home page

    Scenario: Login Functionality Negative Test
      Given  the demoUser enters username "techtorial"
      When the demoUser enters password "test"
      Then  the demoUser validate "Invalid Login or Password."
   @negative @smoke  @conditional
  Scenario: Login Functionality Negative Test1
    Given  the demoUser enters username "Tester"
    When the demoUser enters password "tttt"
    Then  the demoUser validate "Invalid Login or Password."
  @negative @smoke
  Scenario: Login Functionality Negative Test2
    Given  the demoUser enters username "Techtorial"
    When the demoUser enters password "tttt"
    Then  the demoUser validate "Invalid Login or Password"