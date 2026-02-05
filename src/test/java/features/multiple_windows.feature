Feature: Multiple Windows navigation

  Scenario: Open new tab and return back to main page
    Given I open the main page
    When I scroll to the Multiple Windows link and click it
    Then the Click Here link should be displayed
    When I click the Click Here link
    And I switch to the newly opened tab
    Then the header of the opened tab should be "New Window"
    When I go back to the main page using browser navigation
    Then the main page should be displayed
