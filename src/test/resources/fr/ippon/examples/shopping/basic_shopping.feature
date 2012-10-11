Feature: Shop some sports items

  Scenario: Print the shopping cart
  The list should be printed in alphabetical order of the item names
    Given a shopping cart:
      | name                 | price |
      | Running shoes        |   140 |
      | Black belt           |    60 |
      | Tatami               |    80 |
    When I print that cart
    Then it should look like:
    """
    Black belt
    Running shoes
    Tatami

    """

  Scenario: Check that total price cannot be more than 500
  A cart should not contain more than 500 Euros of items (without VAT)
    Given a shopping cart:
      | name                 | price |
      | Running shoes        |   140 |
      | Black belt           |    60 |
      | Surf board           |   200 |
    When I add some new running shoes
    Then I should get an error

  Scenario: Add a second pair of running shoes and print the shopping cart
  The list should be printed in alphabetical order of the item names
    Given a shopping cart:
      | name                 | price |
      | Running shoes        |   140 |
      | Black belt           |    60 |
      | Tatami               |    80 |
    When I add some new running shoes
    And  I print that cart
    Then it should look like:
    """
    Black belt
    Running shoes
    Running shoes
    Tatami

    """

  Scenario: Check that total price is correct
  We have 2 items, add some running shoes and the total price should be 400 Euros
    Given a shopping cart:
      | name                 | price |
      | Black belt           |    60 |
      | Surf board           |   200 |
    When I add some new running shoes
    Then I should have a gross price of "400"

  Scenario: Check that total price is correct, even when an error has occured
  We have 2 items and add two pairs of running shoes : this should trigger an error, as the total is more than 500 Euros
  and the last pair of shoes should not be added
    Given a shopping cart:
      | name                 | price |
      | Black belt           |    60 |
      | Surf board           |   200 |
    When I add some new running shoes
    And  I add some new running shoes
    Then I should have a gross price of "400"