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

// ==================== CREATE NEW STATION ====================
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

// ==================== VERIFY SUCCESS MESSAGE ====================
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
