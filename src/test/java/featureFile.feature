Feature: DemoSite register user and log in
As a User
I want to create a user and log in to the correct page
So that I can have the user and the log in

		

   Scenario Outline: Create a User and Log In  
   Given That I created a User using username "<user>" and password "<password>"
   When I log into the page using username "<user>" and passwprd "<password>"
   Then I am successfully logged in
   
   Examples: Username and Password
    | user | password |
    | Bob | password1 |
    | sam | password1 |
    | smith | password1 |
    | jack | password1 |
    | harry | password1 |
   
  