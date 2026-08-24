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