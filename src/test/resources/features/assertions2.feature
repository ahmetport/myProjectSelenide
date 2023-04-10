@assertions2
  Feature: Assertions2
    Scenario: Search for tesla
      Given I navigate to "https://www.google.com"
      When I search for "Tesla"
      Then verify page source contains "Tesla"
      Then verify the results should contains "About" keyword
      Then the firstb result in the page sections should contain "Tesla"