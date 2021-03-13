@login @smoke
Feature: Users should be able to login

  Scenario: Sign in page navigation
    Given the user is on the login page
    When the user navigates to Sign In page
    When the user logs in using email "lokategt@gmail.com" and password "BJSSTest"
    When the user clicks on quick view


