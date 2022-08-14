@smoke
Feature: F06_homeSliders | user should be routed to the correct url from slider

  Scenario: user could open Nokia Lumia 1020 by clicking it from the slider
    Given user clicks on Nokia Lumia slider
    Then user should be directed to Nokia Lumia page

  Scenario: user could open iphone by clicking it from the slider
    Given user clicks on iphone slider
    Then user should be directed to iphone page
