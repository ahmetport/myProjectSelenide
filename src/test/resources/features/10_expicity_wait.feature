@expicity_wait
  Feature: expicity_wait testing
    Scenario: TC_01 expicity_wait
      Given I navigate to "https://the-internet.herokuapp.com/dynamic_loading/1"
      Then I click on the start button
      And  verify the Hello world text is displayed
      And  I hold the browser open