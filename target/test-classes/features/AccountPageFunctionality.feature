Feature:
  As a user i should able to visit Account page
  So that i can  logout from the app.

  Scenario:Test Account Page
    Given I am on the loginPage
    When I Enter a valid Pin and username
    And I click on avatar button
    And  logout the app
    Then I should be redirected to the login page


