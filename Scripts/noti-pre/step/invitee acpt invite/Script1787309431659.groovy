import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

println "=== START TEST: INVITEE ACCEPT INVITATION ==="

// Login with invitee account
Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')
Windows.delay(3)

Windows.verifyElementPresent(findWindowsObject('Object Repository/SignIn/Email'), 10)
Windows.setText(findWindowsObject('Object Repository/SignIn/Email'), GlobalVariable.INVITEE_EMAIL)
Windows.setText(findWindowsObject('Object Repository/SignIn/Password'), GlobalVariable.INVITEE_PASSWORD)
Windows.click(findWindowsObject('Object Repository/SignIn/Button_Sign in'))
Windows.delay(5)

println "Login with invitee successful"

// Click notification bell icon
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-Station-noti'), 10)
Windows.click(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-Station-noti'))
Windows.delay(2)

// Verify notification list window appears
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Window-station-noti-list'), 10)
println "Notification list displayed"

// Click Accept button
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-Accept'), 10)
Windows.click(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-Accept'))
Windows.delay(3)

println "Invitation accepted successfully"

// Close application
Windows.delay(2)
Windows.closeApplication()

println "=== END TEST: INVITEE ACCEPT INVITATION ==="