Feature: Contacts page

  Scenario:Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then default page number should be 1


  Scenario: Verify Create Calender Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar"

    #to pass dynamic number of parameters. If I add near the others that means to write new step definitions

  Scenario: Menu Options Driver
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |
    #you can add as much Strings as you want here since Cucumber puts them in a List no matter how many of them we write


  Scenario: Menu Options Sales Manager
    Given the user logged in as "sales manager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |


  Scenario: login as a given user
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | user10      |
      | password  | UserUser123 |
      | firstname | Brenden     |
      | lastname  | Schneider   |
    Then the user should be able to login



  Scenario Outline: login as a given user <user>
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <user>      |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login

    Examples:
      | user           | firstName | lastName  |
      | user10         | Brenden   | Schneider |
      | storemanager85 | Stephan   | Haley     |


#    here I use @db for triggering the custom hooks in Hooks class to create the connection and close the connection
  @db
  Scenario: Contacts test with email 1
    Given the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "mbrackstone9@example.com" from contacts
    Then the information should be same with database


  Scenario: Contacts test with email
    Given the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "mike.jorden@hotmail.com" from contacts
    Then the information for "mike.jorden@hotmail.com" should be same with database

    #    here I use @db for triggering the custom hooks in Hooks class to create the connection and close the connection
  @wip @db
    Scenario Outline:Contacts Test
      Given the user logged in as "sales manager"
      And the user navigates to "Customers" "Contacts"
      When the user clicks the "<email>" from contacts
      Then the information for "<email>" should be same with database

      Examples:
      | email |
      | mbrackstone9@example.com |
      | mike.jorden@hotmail.com  |