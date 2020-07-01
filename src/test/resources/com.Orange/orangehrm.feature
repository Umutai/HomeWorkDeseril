Feature: Home works practice

  Scenario: First Step
    Given the user go to the orangehrm
    Then the orUser enters username "Admin"
    * the orUser enters password "admin123"
    * the orUser clicked the Admin function
    * the orUser click the checkbox next to the username
    * the orUser validate all checkboxes are selected
    * the orUser clicked on top of username 2 times
    * validate username are listed descending order

  @test
  Scenario: Second step
    Given the user go to the orangehrm
    Then the orUser enters username "Admin"
    * the orUser enters password "admin123"
    * the orUser clicked the Admin function
    * the orUser click the Add button
    * the orUser select User role
    * the orUser select employee name and enters username
    * the orUser select status
    * the orUser enters password  and confirm
    * the orUser click save button
    *  Validate "Successfully Saved" message


    * the orUser search userName which provided and click search button
    * Validate only one user displayed after search
    * Validate Username
    * Validate User Role
    * Validate Employee Name
    * Validate status of the employee
    * the orUser clicked on top of the username
    * the orUser clicked edit button and change the status
    * Validate "Successfully Updated" message Search with the username
    * Validate status is updated for the user


 # Under System user search with the USERNAME which you have saved
 # Validate only one user displayed after search
 # Validate Username
 # Validate User Role
 # Validate Employee Name
 # Validate status of the employee
 # Click on top the username
 # Click edit button
 # Change the Status
 # Validate "Successfully Updated" message Search with the username
 # Validate status is updated for the user