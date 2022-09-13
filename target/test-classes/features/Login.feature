Feature: User Login

Users using the application should be able to login to use the application.

Background: 
Given Open the application in any browser for login
And Navigate to login page for login

@login
Scenario: Login with valid credentials
When User enters valid credentials into the fields
And User clicks on login button
Then Verify user is able to successfully Login

@login
Scenario: Login with invalid credentials
When User enters invalid credentials into the fields
And User click on Login button
Then Verify user login is unsuccessfull