Feature: Calculate the value added tax

  Scenario: Calculate the VAT for some running shoes
  Calculate the VAT for a normal item, which has 19,6% of VAT
    Given 140 Euros running shoes
    When I calculate the item's VAT
    Then The VAT must be "27.44" Euros

  Scenario: Calculate the VAT for food
  We are starting to sell food : VAT for food is 7% only
    Given a 1 Euro candy bar
    When I calculate the item's VAT
    Then The VAT must be "0.07" Euros

  Scenario: Calculate the VAT for a Judo item
  Our store does a special offer : the VAT for all Judo items is offered !
    Given a 60 Euros black belt
    When I calculate the item's VAT
    Then The VAT must be "0" Euros

  Scenario: Calculate the VAT for a whole shopping cart
    Given a shopping cart with 1 pair of running shoes, 1 black belt, 1 tatami and 2 candy bars
    When I calculate the cart's VAT
    Then The VAT must be "27.58" Euros
