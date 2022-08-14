@smoke
Feature: F03_Currencies | user could change products currency

  Scenario: user change products currency to euro
    Given user open browser and visit the home page
    When user click on the top left dropdown list
    And user chose euro as website currency
    Then all products' prices should be in euro