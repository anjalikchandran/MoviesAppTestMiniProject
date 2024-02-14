Feature:
  As a user i should able to visit Home page
  So that i can  search for the movies in the search icon.

  Scenario:Test search Page
    Given I am on the loginPage
    When I Enter a valid Pin and username
    And I click on the search icon
    And I should be able navigate to search page
    Then Test the Search functionality by searching with some movie names and the count of movies displayed

