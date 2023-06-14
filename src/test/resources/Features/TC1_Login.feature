@login
Feature: Verifying OMR Branch Login Automation
	
  Background: 
    Given User is on the OMR Branch hotel page
 @login1
  Scenario Outline: Verifying OMR Branch Login with valid credentials
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"

    Examples: 
      | username                | password        |
      | sivaraman.drs@gmail.com | 9677569677@Siva |
@login2
  Scenario Outline: Login with Robot with help of keyboard actions
    When User login with keyboard actions "<username>","<password>"
    Then User should verify success message after login "Welcome Sivaramakrishnan"

    Examples: 
      | username                | password        |
      | sivaraman.drs@gmail.com | 9677569677@Siva |
@login3
  Scenario Outline: Verifying OMR Branch Login with invalid credentials
    When User login "<username>","<password>"
    Then User should verify error message after login "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | username                | password   |
      | sivaraman.drs@gmail.com | 12345@Siva |
