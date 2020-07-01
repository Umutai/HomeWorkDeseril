Feature: Pet store
  Scenario: Create a pet

Given user is authorized to create
When user sends  a pet with id ,name,status
Then the status code is OK
And pet with id ,name,status is created