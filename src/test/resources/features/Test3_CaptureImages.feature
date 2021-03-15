@wip
Feature: Capture Images

  Scenario: Capture Images test
    Given the user clicks on quick view of the first item
    When the user changes the size of the item to "X"

   # This test will fail and the screenshot will be under target>cucumber-html-reports>embeddings
   # To generate reports and image captures, tests should be run by using 'mvn verify'