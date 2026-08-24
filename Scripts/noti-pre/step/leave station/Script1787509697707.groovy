import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

println "=== START TEST: MEMBER LEAVE STATION ==="

Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')
Windows.delay(3)
//// Click Settings in sidebar
//Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/ListItem-WS-Settings'), 10)
//Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/ListItem-WS-Settings'))
//Windows.delay(2)
//println "Clicked Settings"

// Click Leave Station button
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/Station Information/Button-Leave Station'), 10)
Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/Station Information/Button-Leave Station'))
Windows.delay(3)
println "Clicked Leave Station"

String stationName = Windows.getText(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/Station Information/Text-station-name')).toString()
println "Station name from dialog: ${stationName}"
Windows.setText(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/Station Information/input-confirm-leave'), stationName)
Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/sidebar/Station Information/Button-Leave Station'))
println "Member left station successfully"

println "=== END TEST: MEMBER LEAVE STATION ==="