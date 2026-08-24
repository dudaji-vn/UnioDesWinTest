import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

println "=== START TEST: JOIN STATION WORKSPACE ==="

// After accepting invitation, automatically navigated to station workspace
Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')
Windows.delay(3)

// Click General button
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-General'), 10)
Windows.click(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-General'))
Windows.delay(2)

// Click Join this group button
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-Join this group'), 10)
Windows.click(findWindowsObject('Object Repository/create-invite-station/invitee-acpt/Button-Join this group'))
Windows.delay(3)

println "Joined station workspace successfully"


println "=== END TEST: JOIN STATION WORKSPACE ==="