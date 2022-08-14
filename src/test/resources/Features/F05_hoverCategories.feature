@smoke
Feature: F05_hoverCategories | user could hover on main categories and sub categories should be displayed if exist

  Scenario: user could hover on a random main category and select whether it or random sub category if exist
    Given user select a random main category
    When other sub categories are displayed if exist
    And user select a random sub category if exist otherwise select the main category
    Then the page title should have the selected category name