import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

println "=== START TEST: SEND CHAT MESSAGE ==="

Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')
Windows.delay(3)

// Enter "Hi!" into chat input
//Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), 10)
Windows.setText(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), "Hi!")
println "Entered 'Hi!' into chat input"
Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/Button-Send'))

// Check if Send button exists, if not press Enter
//try {
//    boolean sendButtonPresent = Windows.verifyElementPresent(
//        findWindowsObject('Object Repository/create-invite-station/ws-chat/Button-Send'),
//        3
//    )
//    
//    if (sendButtonPresent) {
//        Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/Button-Send'))
//        println "Clicked Send button"
//    } else {
//        Windows.sendKeys(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), "\n")
//        println "Pressed Enter key"
//    }
//} catch (Exception e) {
//    Windows.sendKeys(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), "\n")
//    println "Pressed Enter key (fallback)"
//}

Windows.delay(2)
println "Message sent successfully"

println "=== END TEST: SEND CHAT MESSAGE ==="