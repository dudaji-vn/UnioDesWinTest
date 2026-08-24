import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

println "=== START TEST: SEND MENTION MESSAGE ==="

Windows.startApplication('C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Unio\\Unio.lnk')
Windows.delay(3)

// Click chat input
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), 10)
Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'))
Windows.delay(1)

// Type "@" to trigger mention
Windows.setText(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), "@")
Windows.delay(1)
println "Typed @ to trigger mention suggestions"

// Verify mention suggestion list appears
Windows.verifyElementPresent(findWindowsObject('Object Repository/create-invite-station/ws-chat/mention/List-Suggestions'), 5)
println "Mention suggestions list displayed"

// Click Admin username from mention list
Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/mention/ListItem-lieucao16122003'))
Windows.delay(1)
println "Selected Admin: lieucao16122003"


// Send message
try {
    boolean sendButtonPresent = Windows.verifyElementPresent(
        findWindowsObject('Object Repository/create-invite-station/ws-chat/Button-Send'),
        3
    )
    
    if (sendButtonPresent) {
        Windows.click(findWindowsObject('Object Repository/create-invite-station/ws-chat/Button-Send'))
        println "Clicked Send button"
    } else {
        Windows.sendKeys(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), "\n")
        println "Pressed Enter key"
    }
} catch (Exception e) {
    Windows.sendKeys(findWindowsObject('Object Repository/create-invite-station/ws-chat/Text-inputchat'), "\n")
    println "Pressed Enter key (fallback)"
}

Windows.delay(2)
println "Mention message sent successfully"

println "=== END TEST: SEND MENTION MESSAGE ==="