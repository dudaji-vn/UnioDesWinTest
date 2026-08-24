import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

// Open the Windows application
Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')

// Wait for the application to start
Windows.delay(3)

// Verify Email field is displayed
Windows.verifyElementPresent(
	findWindowsObject('Object Repository/SignIn/Email'),
	10
)

// Enter valid email from Global Variable
Windows.setText(
	findWindowsObject('Object Repository/SignIn/Email'),
	GlobalVariable.EMAIL
)

// Enter valid password from Global Variable
Windows.setText(
	findWindowsObject('Object Repository/SignIn/Password'),
	GlobalVariable.PASSWORD
)

// Click Sign in
Windows.click(
	findWindowsObject('Object Repository/SignIn/Button_Sign in')
)

// Wait for login
Windows.delay(5)

// Close application
Windows.closeApplication()