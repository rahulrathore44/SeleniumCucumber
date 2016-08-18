Feature: Search feature of the web page

  @phantomjs
  Scenario: Search based on laptops
    Given : I am at the home page
    When : I click on the laptops search filter
    Then : I should be at the laptop search page with "36 items"
    And : The title should be "Laptops" search page

  @chrome
  Scenario: Search based on
    Given : I am at the home page
    When : I click on the tablet search filter
    Then : I should be at the tablet search page with "36 items"
    And : The title should be "Tablets" search page
