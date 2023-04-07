@assertions
  Feature: assertions
    Scenario: TC_01 verify_title
      Given I navigate to "https://techproeducation.com/enroll/?tab=enroll-online-it-courses"
      And I get title of the current page and verify if it contains "Techpro Education"
