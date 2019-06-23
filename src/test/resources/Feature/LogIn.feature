Feature: Login

Scenario Outline: Login with valid and invalid credentials
 Given User is on Home Page
 And user is not signed in
 When User clicks SignIn
 And User enters email as "<username>" and password as "<password>" 
 Then User is logged in and sign out option is available
Examples:
| username | password |
| bulepanson@tut.by | Password1# |