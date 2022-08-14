@smoke
Feature: F04_Search | user could search for products using product name or sku

  Scenario Outline: user could search using product name
    Given user open browser and visit the home page
    When user types "<productName>" in search field
    And user click search
    Then user route to search result page
    And there are "<resultNumber>" products should be displayed
    And all products should contains "<productName>" in its name
    Examples:
      | productName | resultNumber |
      | book        | 4            |
      | laptop      | 2            |
      | nike        | 3            |


  Scenario Outline: user could search using sku
    Given user open browser and visit the home page
    When user types "<sku>" in search field
    And user click search
    And user click on the product
    Then the product sku should be equal to "<sku>"
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |