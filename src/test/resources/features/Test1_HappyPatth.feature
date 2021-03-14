@login @smoke
Feature: Users should be able to login

  Scenario: Sign in page navigation
    Given the user is on the login page
    When the user navigates to Sign In page
    When the user logs in using email "lokategt@gmail.com" and password "BJSSTest"
    When the user clicks on quick view of the first item
    When the user changes the size of the item to "M"
    When the user adds the item to cart
    When the user clicks on continue shopping
    When the user clicks on quick view of the second item
    When the user adds second item to cart
    When the proceeds to checkout
    Then selected item sizes should be correct
    Then the prices of the items should be correct
    Then total products should be total of the added items
    Then total price should be total of the items in the cart plus shipping
    Then the user should be able to pay by wire






