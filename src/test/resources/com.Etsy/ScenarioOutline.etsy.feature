Feature:  scenario outline test

  Background: Etsy navigation
    Given the user goes to the Etsy
    #scenario outline and Scenario template : are the same
  #Examples and scenario are the same
  @etsyOutline
  Scenario Outline: Etsy Search Validation with outline
    When  the user search in etsy with "<searchValue>"
    Then  the user validate title "<title>" and url "<etsyUrl>"
    Examples:
      | searchValue    | title                  | etsyUrl |
      | winter hat     | Winter hat \| Etsy     | winter  |
      | hat            | Hat \| Etsy            | hat     |
      | winter solider | Winter solider \| Etsy | solider |
    # to organize your code in intelliji you need option command+l

 # @DataProvider
  #  public Object [] [] getData
  #return new Object {
   # {"first"}
    #{"second"}
    #}


