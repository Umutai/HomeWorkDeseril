Feature: Validation of headers

  Scenario: Validation of new order headers
    Given the demoUser enters username "Tester"
    When the demoUser enters password "test"
    Then the user goes to the new order page
    And the user validate the product headers
      | Product:*       |
      | Quantity:*      |
      | Price per unit: |
      | Discount:       |
      | Total:          |
#Task using dataTable validate the header for address information
  # Create new step for this scenario and validate  the headers  for address

    * the user validate the adress headers
      | Customer name:* |
      | Street:*        |
      | City:*          |
      | State:          |
      | Zip:*           |

