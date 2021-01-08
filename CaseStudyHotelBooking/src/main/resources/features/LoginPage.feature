Feature: Login 

Scenario: Invalid Login test
Given User is in login page
When User clicks on login button without entering username, display username error message
Then User enters valid username
When User clicks on login button without entering password, display password error message
Then User enters valid password
And clicks on login button
 
Scenario: Hotel Booking
Given User is in Hotel booking form page
When User clicks on confirm button without entering First name, display first name error message
Then User enters First name
When User clicks on confirm button without entering Last name, display last name error message
Then User enters Last name
When User clicks on confirm button with wrong email format, display email error message
Then User enters email
	| Invalid email | Valid email | 
	| sathya583.w@gmail.com | sathya583.work@gmail.com |
When User try to enter both valid & Invalid phone number
	| 5678765473 |
	| 87654389 |
	| 786548974327 |
	| 9876543789 |
Then user enters address
Then User clicks on confirm button without selecting City, display city error message
Then user selects City
Then User clicks on confirm button without selecting State, display state error message
Then user selects State
Then User clicks on confirm button without entering Card Holder Name, display error message
Then user enters card holder name
Then User clicks on confirm button without entering Card number, display error message
Then user enters card number
Then User clicks on confirm button without entering CVV, display error message
Then user enters CVV
Then User clicks on confirm button without entering Expiration month, display error message
Then user enters expiry month
Then User clicks on confirm button without entering Expiration year, display error message
Then user enters expiry year
Then user clicks on Confirm Booking Button & verifies title & closes browser