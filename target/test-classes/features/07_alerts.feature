@alerts
  Feature: alerts automationTesting
    Scenario: TC_01 alerts
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=javascript-alerts"
      And   I click on alert prompt
      And   I enter "Hello portakal" and click OK
      And   I verify the result contains "Hello portakal"
      And   I hold the browser open