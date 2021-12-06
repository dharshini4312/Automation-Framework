Feature: Application Login
Background:
Given Navigate to Login page

@login
Scenario: Login with valid credentials
When User enters usernamea and password in their respective fields
And User clicks on Login button
Then Verify user is able to successfully login

