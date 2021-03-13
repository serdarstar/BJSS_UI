@login @smoke
Feature: Users should be able to login

  Scenario: Sign in page navigation
    Given the user is on the login page
    When the user navigates to Sign In page
    When the user logs in using email "lokategt@gmail.com" and password "BJSSTest"
    When the user clicks on quick view of item 1
    When the user changes the size of the item to "M"
    When the user adds the item to cart
    When the user clicks on continue shopping
    When the user clicks on quick view of item 2
    When the user adds the item to cart
    When the proceeds to checkout



