Feature: Calculate the Christmas offer
  It's Christmas !! For each 50 Euros (net value) of item bought, we give a 10 Euros rebate !

  Scenario: Caculate the Christmas offer for a sub-50 Euros shopping cart
    Given a christmas shopping cart:
      | name                 | price |
      | Shoe laces           |     5 |
      | T-shirt              |    10 |
    When I add a candy bar to the cart
    And  It is December
    Then I should have a net price of "19.01"

  Scenario: Caculate the Christmas offer for a full shopping cart
    Given a christmas shopping cart:
      | name                 | price |
      | Running shoes        |   140 |
      | T-shirt              |    10 |
    When I add a black belt to the cart
    And  It is December
    Then I should have a net price of "199.4"

  Scenario: Caculate the Christmas offer for a shopping cart which gross price exceeds 500 Euros
    We cannot exceed 500 Euros in gross price, so the last item cannot be added.
    Given a christmas shopping cart:
      | name                 | price |
      | Running shoes        |   140 |
      | Running shoes        |   140 |
      | Backpack             |   150 |
    When I add a black belt to the cart
    And  I add a black belt to the cart
    And  It is December
    Then I should have a net price of "464.28"

  Scenario: Check that the Christmas offer does not work in January
    Given a christmas shopping cart:
      | name                 | price |
      | Running shoes        |   140 |
      | T-shirt              |    10 |
    When It is not December
    Then I should have a net price of "179.4"