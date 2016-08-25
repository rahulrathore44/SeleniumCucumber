Feature: Search with specific filter and add it to cart

  Scenario: Search based on Speakers
    Given : I am at the home page
    When : I click on the "Speakers" search filter
    Then : I should be at the "Speakers" search page with "32 items"
    And : The title should be "Speakers" search page
    Then : I select "SONY" as the brand
    And : I select "£40 - £80" as the price filter
    Then : I should be at the "Speakers" search page with "3 items"
	
	@firefox
  Scenario: Validation of Item Bag page
    Given : I am at the home page
    When : I click on the "Speakers" search filter
    Then : I should be at the "Speakers" search page with "32 items"
    And : The title should be "Speakers" search page
    Then : I select "SONY" as the brand
    And : I select "£40 - £80" as the price filter
    Then : I should be at the "Speakers" search page with "3 items"
    Then : I select the "SONY X11" with description as "White"
    And : Add it to the cart
    Then : I change the quantity to "2" and click on update button
    Then : Navigate to user details page and provide the following details
      | Destination | Singapore  |
      | Airline     | AirAsia    |
      | FlightNo    | A089       |
      | FlightDate  | 24/08/2018 |
      | FlightTime  | 5:00       |
      | Terminal    | Terminal 1 |
      | FirstName   | Selenium   |
      | LastName    | Java       |
      | Email       | sq@j.com   |
      | Phone       |  121212121 |

  @chrome
  Scenario: Adding multiple item into the cart
    Given : I am at the home page
    When : I click on the "Headphones" search filter
    Then : I select "JABRA" as the brand
    And : I select "£70 - £105" as the price filter
    Then : I select the "JABRA Coach Headphones" with description as "Blue"
    And : Add it to the cart
    When : I click on the "Smart Devices" search filter
    Then : I select "SAMSUNG" as the brand
    Then : I select the "SAMSUNG Gear S2 Smartwatch" with description as "Black"
    And : Add it to the cart
    Then : I change the quantity of item "SAMSUNG Gear S2 Smartwatch" to "3" and click on update button
    Then : Navigate to user details page and provide the following details
      | Destination | Singapore  |
      | Airline     | AirAsia    |
      | FlightNo    | A089       |
      | FlightDate  | 24/08/2018 |
      | FlightTime  | 5:00       |
      | Terminal    | Terminal 1 |
      | FirstName   | Selenium   |
      | LastName    | Java       |
      | Email       | sq@j.com   |
      | Phone       |  121212121 |
