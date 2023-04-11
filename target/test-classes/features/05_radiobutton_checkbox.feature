@radio_checkbox
  Feature: radio_checkbox
    Scenario: TC_01 radiobutton_checkbox
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=checkboxes"
      And   I click on the "Check box 1" if not already selected
      And   I click on the "Check box 2" if not already selected
      And   I hold the browser open

    Scenario: TC_02 radiobutton
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=radio-buttons"
      And   I click on the "Red" if not already selected
      And   I hold the browser open

    Scenario: TC_03 radiobutton
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=radio-buttons"
      And   I click on the "Yellow" if not already selected
      And   I hold the browser open

    Scenario: TC_04 radiobutton
      Given I navigate to "https://testcenter.techproeducation.com/index.php?page=radio-buttons"
      And   I click on the "Football" if not already selected
      And   I hold the browser open
