Feature: User Signin

New Users using the application should be able to Signin to use the application.


Background:
Given Open the application in any browser for signin
And Navigate to login page for signin

@signin
Scenario: Signin with existing account credentials
When User enters existing accound credentials
And User clicks on login button to signin
Then Verify user is not able to create new account with existing account credentials

@signin
Scenario: Signin with invalid account credentials
When User enters invalid Phone Number as "111"
And User clicks on login button to signin
Then Verify user is not able to click on login button and create an account