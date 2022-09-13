Feature: User Logout

Users using the application should be able to Logout when not using it.

@logout
Scenario: Logging out
Given that user have loggedin to the unacademy page
When user navigates to the Myicon page
And clicks on Logout button
Then verify user is able to logout of the application

