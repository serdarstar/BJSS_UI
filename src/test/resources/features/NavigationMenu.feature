  @navigate
Feature: Navigation Menu

  Scenario: Navigating Fleet -- Vehicles
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Fleet, Vehicles
    Then the title should be Vehicles

    @db
  Scenario: Navigating Marketing -- Campaigns
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Marketing, Campaigns
    Then title should be Campaigns

  Scenario: Navigating Activities -- Calendar Events
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to Activities, Calendar Events
    Then title should be Calendars


#  @runAll
#Feature: Sales manager should be able to navigate to three different top menus and see the correct page title
#
#    @login
#  Scenario:  Login as a sales manager
#    Given the user is on the login page
#    When the user enters the sales manager information
#    Then the user should be able to login
#
#    @Vehicles
#  Scenario:  Navigate to Fleet module -->Vehicles page
#    Given the user is in the Dashboard page
#    When the user hovers over the Fleet button and click the Vehicles button to navigate
#    Then the user should see the Vehicles page title
#
#    @Campaigns
#  Scenario:  Navigate to Marketing module -->Campaigns page
#    Given the user is in the Dashboard page
#    When the user hovers over the Marketing module and click the Campaigns button to navigate
#    Then the user should see the Campaigns page title
#
#    @CalendarEvents
#  Scenario:  Navigate to Activities module -->Calendar Events page
#    Given the user is in the Dashboard page
#    When the user hovers over the Activities button and click the Calendar Events button to navigate
#    Then the user should see the Calendars page title