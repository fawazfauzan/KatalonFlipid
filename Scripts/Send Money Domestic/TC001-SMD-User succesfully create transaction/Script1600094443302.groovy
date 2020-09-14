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

WebUI.callTestCase(findTestCase('Home/TC003-HOME-User can access kirim uang domestik'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Send Money Domestic Page/selectSenderBank'), 'mandiri', false)

WebUI.verifyElementAttributeValue(findTestObject('Send Money Domestic Page/buttonNavItemBeneficiary'), 'aria-selected', 
    'true', 0)

WebUI.selectOptionByValue(findTestObject('Send Money Domestic Page/selectBeneficiaryBank'), 'bca', false)

WebUI.setText(findTestObject('Send Money Domestic Page/inputAccountNumber'), accountNumber)

WebUI.click(findTestObject('Send Money Domestic Page/buttonCheckName'))

WebUI.verifyElementAttributeValue(findTestObject('Send Money Domestic Page/inputBeneficiaryBank'), 'value', accountName.toString().toUpperCase(), 
    0)

WebUI.setText(findTestObject('Send Money Domestic Page/inputAmount'), '10000')

WebUI.click(findTestObject('Send Money Domestic Page/buttonOKCorrectData'))

WebUI.verifyElementText(findTestObject('Send Money Domestic Page/labelAccountNumber'), accountNumber)

WebUI.verifyElementText(findTestObject('Send Money Domestic Page/labelBeneficieryNameAccount'), accountName.toString().toUpperCase())

WebUI.click(findTestObject('Send Money Domestic Page/buttonNext'))

WebUI.verifyElementPresent(findTestObject('Send Money Domestic Page/labelTermandCondition'), 0)

WebUI.click(findTestObject('Send Money Domestic Page/buttonAgreement'))

WebUI.waitForElementPresent(findTestObject('Send Money Domestic Page/buttonCancelTransaction'), 0)

WebUI.verifyTextPresent('Konfirmasi Transaksi', false)

