@locators
Feature: locators feature
  Scenario: Tc_01 locators
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=form-authentication"
    And I enter username
    And I enter password
    And I enter submit button
    And I enter logout
    And I hold the browser open