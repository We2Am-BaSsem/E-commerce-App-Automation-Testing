@smoke
Feature: F08_Wishlist | users could add products to his wishlist

  Scenario: user add "HTC One M8 Android L 5.0 Lollipop" to his wishlist successfully
    Given chose HTC and click on wishlist button
    Then a success message should be displayed with green background


  Scenario: "HTC One M8 Android L 5.0 Lollipop" quantity of user's wishlist should be grater than 0
    Given chose HTC and click on wishlist button
    And user go to wishlist page and check the product quantity
    Then the product quantity should be grater than zero
