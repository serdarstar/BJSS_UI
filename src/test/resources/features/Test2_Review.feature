@wip
Feature: Review Previous Orders and Add a Message

Scenario: Review Previous Orders and Add a Message Test
    Given the user is on the dashboard page
    When the user clicks the Order history and Details button
    When the user sees the order history
    When the user clicks the order reference
    Then the user should see the same date as "order date"
    When the user adds a comment
    Then the comment should be seen under the messages
    Then the user logs out