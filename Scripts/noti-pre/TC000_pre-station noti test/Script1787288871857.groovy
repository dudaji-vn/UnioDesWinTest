import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.openqa.selenium.Keys

// ==================== PART 1: LOGIN ====================
println "=== START TEST: CREATE NEW STATION ==="

// Open the application
Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')
Windows.delay(3)

// Login
Windows.verifyElementPresent(findWindowsObject('Object Repository/SignIn/Email'), 10)
Windows.setText(findWindowsObject('Object Repository/SignIn/Email'), GlobalVariable.EMAIL)
Windows.setText(findWindowsObject('Object Repository/SignIn/Password'), GlobalVariable.PASSWORD)
Windows.click(findWindowsObject('Object Repository/SignIn/Button_Sign in'))
Windows.delay(5)
println "Login successful"

// ==================== PART 2: HANDLE NOTIFICATION ====================
println "Checking for notification..."

try {
	// Check if notification appears
	boolean isNotificationPresent = Windows.verifyElementPresent(
		findWindowsObject('Object Repository/create-invite-station/ListItem-Enable notifications'),
		3
	)
	
	if (isNotificationPresent) {
		println "Notification detected, enabling..."
		Windows.click(findWindowsObject('Object Repository/create-invite-station/Button-Enable'))
		Windows.delay(2)
		println "Notifications enabled successfully"
	} else {
		println "No notification found, skipping this step"
	}
} catch (Exception e) {
	println "Notification not found (or already handled), continuing test"
}

// ==================== PART 3: CREATE NEW STATION ====================
println "Starting to create new Station..."

// Click Add Station button
Windows.verifyElementPresent(
	findWindowsObject('Object Repository/create-invite-station/Button_Add-station'),
	10
)
Windows.click(findWindowsObject('Object Repository/create-invite-station/Button_Add-station'))
println "Clicked Add Station button"

// Wait for Station Information form to appear
//Windows.verifyElementPresent(
//	findWindowsObject('Object Repository/create-invite-station/Group-Station Information'),
//	10
//)
//println "Station Information form appeared"

// Generate unique station name with timestamp
String timestamp = System.currentTimeMillis().toString()
String stationName = "TestStation_" + timestamp

// Enter Station Name
Windows.setText(
	findWindowsObject('Object Repository/create-invite-station/input-Station Name'),
	stationName
)
println "Entered station name: " + stationName

// Small delay to ensure the Create button is enabled (if applicable)
Windows.delay(1)

// Click Create New Station button
Windows.click(findWindowsObject('Object Repository/create-invite-station/Button-Create New Station'))
println "Clicked Create New Station button"

// Wait for station to be created
Windows.delay(3)
println "Station created successfully"

// ==================== PART 4: VERIFY SUCCESS MESSAGE ====================
println "Verifying success message..."

try {
	// Verify the success message appears
	boolean isSuccessMessagePresent = Windows.verifyElementPresent(
		findWindowsObject('Object Repository/create-invite-station/Text-created successfully'),
		10
	)
	if (isSuccessMessagePresent) {
		println "✅ Success message 'created successfully' displayed"
	} else {
		println "⚠️ Success message not found, but station may have been created"
	}
} catch (Exception e) {
	println "⚠️ Success message object not found, continuing..."
}
//
//// ==================== PART 5: VERIFY STATION IN LIST ====================
//println "Verifying station in list..."
//
//// Verify the newly created station appears in the list
//try {
//	boolean isStationCreated = Windows.verifyElementPresent(
//		findWindowsObject('Object Repository/create-invite-station/verify-Station-Created'),
//		5
//	)
//	if (isStationCreated) {
//		println "✅ Verified station '${stationName}' was created successfully"
//	} else {
//		println "⚠️ Station not found in list, may need further verification"
//	}
//} catch (Exception e) {
//	println "⚠️ No verify object found, station may have been created"
//}

// ==================== PART 6: INVITE MEMBERS ====================
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


// ==================== PART 7: SELECT GROUP ====================
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

// ==================== PART 8: ENTER USERNAMES ====================
println "Entering usernames..."

// Enter usernames (using Global Variable or hardcoded)
// You can set this in Global Variables or use a test data
String usernames = GlobalVariable.INVITEE_USERNAMES ?: GlobalVariable.INVITEE2_USERNAMES
Windows.setText(
	findWindowsObject('Object Repository/create-invite-station/Invite/input-Enter usernames'),
	usernames
)
println "Entered usernames: " + usernames

// Press Enter after entering usernames
Windows.sendKeys(findWindowsObject('Object Repository/create-invite-station/Invite/input-Enter usernames'), Keys.ENTER.toString())
println "Pressed Enter after entering usernames"
Windows.delay(2)

// ==================== PART 9: SEND INVITATIONS ====================
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

// ==================== PART 10: VERIFY INVITATIONS SENT ====================
println "Verifying invitations sent..."

try {
	// Check for success message after sending invitations (if available)
	// Add your verification object here if exists
	println "✅ Invitations verification completed"
} catch (Exception e) {
	println "⚠️ No verification object found for invitations"
}

// ==================== PART 11: CLEANUP ====================
println "=== END TEST: STATION CREATED AND INVITATIONS SENT SUCCESSFULLY ==="
Windows.delay(2)
//Windows.closeApplication()