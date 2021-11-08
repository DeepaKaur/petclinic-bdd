#Author: Deepa Kaur
#Keywords Summary : Veterinarians page

@Vets
Feature: PetClinic Veterinarians page 

	Scenario Outline: Veterinarians screen
		Given Veterinarians page
		When I go to Veterinarians page
		Then Veterinarians page is shown with name and specialies table

 