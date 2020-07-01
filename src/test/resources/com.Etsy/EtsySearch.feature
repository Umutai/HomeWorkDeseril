Feature:Validate search in Etsy
  Background: It will run before each scenario
    Given the user goes to the Etsy

   @etsy
    Scenario: Validation of search in etsy 1
    When the user search in etsy with "winter hat"
    Then  the user validate title "Winter hat | Etsy" and url "winter"

  @etsy @tt
    Scenario: Validation of search in etsy 2
    When the user search in etsy with "hat"
    Then  the user validate title "Hat | Etsy" and url "hat"

  @etsy @tt

    Scenario: Validation of search in etsy 3
    When the user search in etsy with "winter soldier"
    Then  the user validate title "Winter soldier | Etsy" and url "soldier"

    # we need to run three scenario  and
  #before every scenario I wnt to navigate the ets except second scenario

