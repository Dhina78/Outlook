Feature: Signup for Outlook Account

Scenario Outline: Signup with valid new EmailID
Given User in HomePage 
When User click Create free account page
And In Create account page enter an <EmailID> in format
And select Domain and click Next
Then User get Create a password message
Examples:
| EmailID |
| ValidDhina78 |
| ValidDhina79 |
Scenario Outline: Signup with invalid new EmailID
Given User in HomePage 
When User click Create free account page
And In Create account page enter an <EmailID> in format
And select Domain and click Next
Then User expect <ErrorMessage>
Examples:
| EmailID | ErrorMessage |
| Valid..Dhina | Enter the email address in the format someone@example.com. |
| Valid@Dhina | This email is part of a reserved domain. Please enter a different email address. |
| 78Dhina | Your email address must start with a letter. Please try again. |
| Dhina78 | Someone already has this email address. Try another name, or claim one of these available email addresses |