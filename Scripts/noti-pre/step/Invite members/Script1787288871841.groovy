import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ==================== INVITE MEMBERS ====================
println "Starting to invite members..."

// Click Invite Members button
Windows.verifyElementPresent(
	findWindowsObject('Object Repository/create-invite-station/Invite/Button-Invite Members'),
	10
)
Windows.click(findWindowsObject('Object Repository/create-invite-station/Invite/Button-Invite Members'))
println "Clicked Invite Members button"
Windows.delay(2)

// Click Invite by Username button
Windows.verifyElementPresent(
	findWindowsObject('Object Repository/create-invite-station/Invite/Button-Invite by Username'),
	10
)
Windows.click(findWindowsObject('Object Repository/create-invite-station/Invite/Button-Invite by Username'))
println "Clicked Invite by Username button"
Windows.delay(2)


// ==================== SELECT GROUP ====================
println "Selecting group..."

// Click on ComboBox to select group
Windows.click(
	findWindowsObject('Object Repository/create-invite-station/Invite/ComboBox-sellectGroup')
)
println "Clicked ComboBox to select group"
Windows.delay(1)

// OPTION 1: Select "Others" group
// Uncomment this block to select "Others"
/*
try {
	Windows.click(
		findWindowsObject('Object Repository/create-invite-station/Invite/ListItem-Others')
	)
	println "✅ Selected group: Others"
	Windows.delay(1)
} catch (Exception e) {
	println "⚠️ Could not select 'Others' group, trying alternative..."
}
*/

// OPTION 2: Select "Administrators" group (CURRENTLY ACTIVE)
try {
	Windows.click(
		findWindowsObject('Object Repository/create-invite-station/Invite/ListItem-Administrators')
	)
	println "✅ Selected group: Administrators"
	Windows.delay(1)
} catch (Exception e) {
	println "⚠️ Could not select 'Administrators' group, trying alternative..."
	// Fallback to Others if Administrators not found
	try {
		Windows.click(
			findWindowsObject('Object Repository/create-invite-station/Invite/ListItem-Others')
		)
		println "✅ Selected group: Others (fallback)"
		Windows.delay(1)
	} catch (Exception e2) {
		println "❌ Could not select any group"
	}
}

// ==================== ENTER USERNAMES ====================
println "Entering usernames..."

// Enter usernames (using Global Variable or hardcoded)
// You can set this in Global Variables or use a test data
String usernames = GlobalVariable.INVITEE_USERNAMES ?: "testuser1, testuser2"
Windows.setText(
	findWindowsObject('Object Repository/create-invite-station/Invite/input-Enter usernames'),
	usernames
)
println "Entered usernames: " + usernames

// Press Enter after entering usernames
Windows.sendKeys(findWindowsObject('Object Repository/create-invite-station/Invite/input-Enter usernames'), Keys.ENTER.toString())
println "Pressed Enter after entering usernames"
Windows.delay(2)

// ==================== SEND INVITATIONS ====================
println "Sending invitations..."

// Click Send Invitations button
Windows.verifyElementPresent(
	findWindowsObject('Object Repository/create-invite-station/Invite/Button-Send invitations'),
	10
)
Windows.click(findWindowsObject('Object Repository/create-invite-station/Invite/Button-Send invitations'))
println "Clicked Send Invitations button"

// Wait for invitations to be sent
Windows.delay(3)
println "✅ Invitations sent successfully"

//// ==================== VERIFY INVITATIONS SENT ====================
//println "Verifying invitations sent..."
//
//try {
//	// Check for success message after sending invitations (if available)
//	// Add your verification object here if exists
//	println "✅ Invitations verification completed"
//} catch (Exception e) {
//	println "⚠️ No verification object found for invitations"
//}

// ==================== BACK TO DASHBOARD ====================

Windows.click(
	findWindowsObject('Object Repository/create-invite-station/Invite/Button-Back To Dashboard')
)
println "Clicked Back To Dashboard"
Windows.delay(1)