Feature: Search feature of the web page

  Scenario: Search based on laptops
    Given : I am at the home page
    When : I click on the "Laptops" search filter
    Then : I should be at the "Laptops" search page with "35 items"
    And : The title should be "Laptops" search page

  Scenario: Search based on Tablets
    Given : I am at the home page
    When : I click on the "Tablets" search filter
    Then : I should be at the "Tablets" search page with "5 items"
    And : The title should be "Tablets" search page

  Scenario: Search based on Cameras
    Given : I am at the home page
    When : I click on the "Cameras" search filter
    Then : I should be at the "Cameras" search page with "47 items"
    And : The title should be "Cameras" search page

  Scenario: Search based on Mobile Phones
    Given : I am at the home page
    When : I click on the "Mobile Phones" search filter
    Then : I should be at the "Mobile Phones" search page with "33 items"
    And : The title should be "Mobile Phones" search page

  Scenario: Search based on Books
    Given : I am at the home page
    When : I click on the "Books - Children" search filter
    Then : I should be at the "Books - Children" search page with "11 items"
    And : The title should be "Books - Children" search page
