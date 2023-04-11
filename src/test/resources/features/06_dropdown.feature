@dropdowns
  Feature: dropdown tests
    Scenario: TC_01 dropdown
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=dropdown"
      And   I select the year as 2000
      And   I select the months as "June"
      And   I select the day as 10
      And   I get the list of US states and click on "Texas"
      And   I hold the browser open