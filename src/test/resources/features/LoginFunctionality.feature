Feature: Test the Login Page UI and Functionalities
  As a user of this Movies App
  I want to be able to log in to my account.

  Scenario: Test the Login Page UI and Click on Button
    Given I am on the loginPage
    When Test the User Interface
    And click On LoginButton
    Then Error text will be *Username or password is invalid

   Scenario: empty USERNAME
     Given I am on the loginPage
     When I Enter a valid Pin
     And  click On LoginButton
     Then  Error text will be *Username or password is invalid

   Scenario:empty PASSWORD
     Given I am on the loginPage
     When I Enter a valid username
     And click On LoginButton
     Then  Error text will be *Username or password is invalid

  Scenario:Invalid password
    Given I am on the loginPage
    And I Enter invalid password
    Then Error text will be username and password didn't match

  Scenario:Inavalid Username
    Given I am on the loginPage
    And I Enter invalid Username
    Then Error text will be *invalid username

  Scenario:Valid Credentials
    Given I am on the loginPage
    When I Enter a valid Pin and username
    Then I should be loggedin


















