Feature: Add item to eBay Cart

  Scenario Outline: Verify item can be added to Cart
    Given I open the browser and navigate to ebay home page
    When I search for "<item>"
    And I click on the first book in the search results
    And I add the item to the cart
    Then check updated  cart and verify the cart has been updated with "<count>" item

    Examples:
    | item | count |
    | book | 1     |

