Feature:
  As a user i should able to visit Popular movie page
  So that i can  view the movies in the popular page.

  Scenario:Test popular Page
    Given I am on the loginPage
    When I Enter a valid Pin and username
    And I Test the Popular Page UI
    And click on any popluar movie
    And I should be redirected to the movie details page
    Then back to home page
