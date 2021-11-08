#Author: Deepa Kaur
#Keywords Summary : Home page

@Home
Feature: PetClinic Home page

	Scenario Outline: Home screen
		Given URL for PetClinic Home page 
		When I browse to the URL
		Then Home page is shown with Welcome message

 