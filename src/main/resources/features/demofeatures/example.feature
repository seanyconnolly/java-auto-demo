
@Regression
Feature: Example Feature

  @Smoke
  Scenario: Launch Google Sheets
    Given I am on the Google Docs Page
    When I launch Sheets Application
    Then I verify Account Login Shown
