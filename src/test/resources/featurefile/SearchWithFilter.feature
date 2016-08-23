Feature: Search with specific filter and add it to cart

  @chrome
  Scenario: Search based on Speakers
    Given : I am at the home page
    When : I click on the "Speakers" search filter
    Then : I should be at the "Speakers" search page with "32 items"
    And : The title should be "Speakers" search page
    Then : I select "SONY" as the brand
    And : I select "£40 - £80" as the price filter
    Then : I should be at the "Speakers" search page with "3 items"
