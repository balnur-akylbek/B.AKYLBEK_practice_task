Feature: Checkboxes behavior

  Scenario: Checkbox 1 should be unselected after page refresh
    Given the browser is opened in incognito mode
    And I open the main page
    When I click on the Checkboxes link
    And I select Checkbox 1
    Then Checkbox 1 should be selected
    When I refresh the page
    Then Checkbox 1 should not be selected
