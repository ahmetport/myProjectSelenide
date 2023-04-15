@actions
  Feature: actions testing
    Scenario: TC_01 actions
      Given I navigate to "https://jqueryui.com/droppable/"
      And   I switch to frame 1
      When  I drag the source in the target
      And   I hold the browser open

    Scenario: TC_02 actions
      Given I navigate to "https://testcenter.techproeducation.com/"
      Then  I scroll pagedown
      And   I hold the browser open
