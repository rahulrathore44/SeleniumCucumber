Feature: Search feature of the web page

  @phantomjs
  Scenario: Search based on laptops
    Given : I am at the home page
    When : I click on the laptops search filter
    Then : I should be at the laptop search page
    And : The title should be laptop search page title
