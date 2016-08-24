Feature: Adding a Tablet to the Cart

  Scenario: Search Tablet and add it to the cart
    Given : I am at the home page
    When : I click on the "Tablets" search filter
    Then : I should be at the "Tablets" search page with "51 items"
    And : The title should be "Tablets" search page
    Then : I select the "APPLE iPad Mini 4" with description as "WiFi 64GB Silver"
    And : Add it to the cart
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
