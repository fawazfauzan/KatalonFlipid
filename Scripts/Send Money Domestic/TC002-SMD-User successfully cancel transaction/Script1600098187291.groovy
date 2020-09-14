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

WebUI.callTestCase(findTestCase('Login/TC001-LOG-User successfully login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Send Money Domestic Page/buttonTransactionStatusConfirmation'))

WebUI.waitForElementPresent(findTestObject('Send Money Domestic Page/buttonCancelTransaction'), 0)

WebUI.verifyTextPresent('Konfirmasi Transaksi', false)

WebUI.click(findTestObject('Send Money Domestic Page/buttonCancelTransaction'))

WebUI.verifyElementPresent(findTestObject('Send Money Domestic Page/modalCancelTransaction'), 0)

WebUI.click(findTestObject('Send Money Domestic Page/buttonOKCancelTransaction'))

WebUI.verifyElementPresent(findTestObject('Home Page/buttonCreateRefund'), 0)

WebUI.verifyElementNotPresent(findTestObject('Send Money Domestic Page/buttonTransactionStatusConfirmation'), 0)

