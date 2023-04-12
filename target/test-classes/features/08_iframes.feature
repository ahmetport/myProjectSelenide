@frames
  Feature: iframes testing
    Scenario: TC_01 frames testing
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=iframe"
      And   I verify the page header contains "iframe"
      And   I switch to frame 1
      And   I click on back to TechProEducation.com
     # When  I switch to window 2
      And   I wait for 5 seconds
      Then  I get to URL of the page and verify it contains "techproeducation"
      And   I hold the browser open