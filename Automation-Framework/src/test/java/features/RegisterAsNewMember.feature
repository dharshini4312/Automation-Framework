Feature: Registratio Tests
Background:
Given User navigates to Registration page

@register
Scenario: Register an account with valid details
#When User provies the following details into the input fields

When User enters the personal details for "arun"
		
	And Selects the privacy policy option
	And Clicks on Continue button
	Then User should get successfully registered
	