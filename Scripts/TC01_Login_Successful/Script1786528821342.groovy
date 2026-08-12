import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

// Open the Windows application
Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')

// Wait for the application to start
Windows.delay(3)

// Verify Email field is displayed
Windows.verifyElementPresent(
	findWindowsObject('Object Repository/SignIn/Email'),
	10
)

// Enter valid email
Windows.setText(
	findWindowsObject('Object Repository/SignIn/Email'),
	'lieucao16122003@gmail.com'
)

// Enter valid password
Windows.setText(
	findWindowsObject('Object Repository/SignIn/Password'),
	'Lieucao16122003'
)

// Click Sign in
Windows.click(
	findWindowsObject('Object Repository/SignIn/Button_Sign in')
)

// Wait for login
Windows.delay(5)

// Close application
Windows.closeApplication()