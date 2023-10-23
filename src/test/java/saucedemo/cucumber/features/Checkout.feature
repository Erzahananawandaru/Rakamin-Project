Feature: Checkout information

  Scenario: fill in the data successfully
    Given user login in  web
    When click menu Checkout
    And input data credencial
    And user click continue
    Then user in dasbord page overview