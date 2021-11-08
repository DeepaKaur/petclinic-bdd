#Author: Deepa Kaur
#Keywords Summary : Cucumber, Owners
#Feature: Owner management

@owners
Feature: Owners management on PetClinic

  Scenario Outline: Search owners
    Given I am on Home and click Find Owners
    When I search for the owner named 'Kaur'
    Then I can verify the owner with last name 'Kaur' exists
    
    
  Scenario Outline: Search non existing owners
    Given A non existing owner with last name XYZ
    When I search for the non existing owners 
    Then I can verify the owner with last name XYZ not present

    @Ad
  Scenario Outline: Add Owners
    Given New owner details
    When I add the details and submit
    |firstname | lastname | address | city | telephone |
    | Sukhman  | Singh    | 111 Derby street | kingswood | 34567 |
    Then I can verify the owner 'Sukhman Singh' is present
