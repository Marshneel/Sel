package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.apache.xpath.functions.FuncSubstring;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.unionstreet.support.ElementUtils.split;



public class ServiceDesk_ActionsPage
{
    private final String TEXT_ON_VIEW_AND_AMEND_DETAILS_PAGE = "//h1[@class='page-header']//small[contains(text(),'View and Amend Details')]";
    private final String INCIDENT_CONTACT_INFORMATION_SAVEBTN = "//a[contains(text(),'Cancel')]//following-sibling::a[contains(text(),'Save')]";
    private final String INCIDENT_CONTACT_INFORMATION_TEXT = "//h4[contains(text(),'Incident Contact Information')]";
    private final String VIEW_AND_AMEND_DETAILS_EDIT_ICON = "ShowIncidentContactmodal";
    private final String INCIDENT_CONTACT_INFORMATION_CANCELBTN = "//a[contains(text(),'Cancel')]";
    private final String MARK_AS_RESPONDED_CHCKBOX = "//input[@id='Responded']/./following-sibling::label[contains(text(),'Mark as Responded')]";




    ElementUtils utils=new ElementUtils();
    ServiceDesk_TicketDetailsPage serviceDesk_ticketDetailsPage=new ServiceDesk_TicketDetailsPage();
    ServiceDesk_CallerDetails_TriagePage serviceDesk_callerDetails_triagePage=new ServiceDesk_CallerDetails_TriagePage();
    public void assertIncidentViewAndAmendDetails() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath(TEXT_ON_VIEW_AND_AMEND_DETAILS_PAGE));
        Thread.sleep(5000);

    }
    public void assertContactDetailsOnIncidentContactInformationModal() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'"+serviceDesk_callerDetails_triagePage.NameValue+"')]//following-sibling::a[contains(text(),'"+serviceDesk_callerDetails_triagePage.EmailValue+"')]//following-sibling::span[contains(text(),'"+serviceDesk_callerDetails_triagePage.TelValue+"')]"));
        Thread.sleep(5000);

    }
    public void ClickSaveBtnOnIncidentContactInformationModal()
    {
        utils.clickBtn(By.xpath(INCIDENT_CONTACT_INFORMATION_SAVEBTN));
    }
    public void validateFieldsOnIncidentContactInformationModalForSelectContactDropdown()
    {
        utils.selectByVisibleText(By.id(serviceDesk_callerDetails_triagePage.SELECT_CONTACT_ON_CALLER_DETAILS_PAGE), "Select...");
        serviceDesk_callerDetails_triagePage.correspondenceDetailsValidations();

    }
    public void ClickViewAndAmendDetailsEditIcon()
    {
        utils.clickBtn(By.id(VIEW_AND_AMEND_DETAILS_EDIT_ICON));
        utils.waitForElementVisible(By.xpath(INCIDENT_CONTACT_INFORMATION_TEXT));
    }

    public void closeActionsPopUp() throws InterruptedException {
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='modal-msg-lg0']//span[text()='Ã—']"));
    }
    public void assertCompanyAndSiteNameAreDisplayedOnViewAndAmmendDetailsPage(String company,String SiteName)
    {
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'"+company+"')]//following-sibling::h5[contains(text(),'"+SiteName+"')]"));
    }
    public void assertCompanyAndShortNameAreDisplayedOnViewAndAmmendDetailsPage(String company,String ShortName)
    {
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'"+company+"')]//following-sibling::h5[contains(text(),'"+ShortName+"')]"));
    }
    public void assertOnlyCompanyDisplayedOnViewAndAmmendDetailsPage(String company,String ShortName)
    {
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'"+company+"')]//following-sibling::h5[contains(text(),'"+ShortName+"')]"));
    }

    public void assertActionsPage(){
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'NEW ACTION')]]"));
    }
    public void revokeHoursFieldForActionsTab() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "delete from Defaultvalues where ID=197");
    }
    public void issuingHoursFieldForActionsTab() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "SET IDENTITY_INSERT DefaultValues ON\n" +
                "insert into DefaultValues(ID,Description,ValueNumber) Values(197,'Hours',1)\n" +
                "SET IDENTITY_INSERT DefaultValues OFF");
    }
    public void revokeRadioButtonsForCallAction_onTheActionsPopUp(int recordID) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_actions set system_inbound='1'where RecordID='"+recordID+"'");
    }
    public void issuingRadioButtonsForCallAction_onTheActionsPopUp(int recordID) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_actions set system_inbound='0'where RecordID='"+recordID+"'");
    }
    public void navigateToNewActionsPopup(String actionsType) throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[text()[contains(.,'NEW ACTION')]]"));
        utils.clickBtn(By.xpath("//a[text()[contains(.,'"+actionsType+"')]]"));
    }
    public void assertAbsenceOfCallRadioButtonsOnActionsPopUp(){
        utils.assertElementNotPresent(By.xpath("//label[text()[contains(.,'Spoke to intended person')]]"));
        utils.assertElementNotPresent(By.xpath("//label[text()[contains(.,'Left message with someone else')]]"));
        utils.assertElementNotPresent(By.xpath("//label[text()[contains(.,'Left Voicemail')]]"));
        utils.assertElementNotPresent(By.xpath("//label[text()[contains(.,'No Answer / Engaged')]]"));
    }
    public void assertPresenceOfCallRadioButtonsOnActionsPopUp()
    {
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'Spoke to intended person')]]"));
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'Left message with someone else')]]"));
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'Left Voicemail')]]"));
        utils.waitForElementVisible(By.xpath("//label[text()[contains(.,'No Answer / Engaged')]]"));
    }


    public void assertAbsenceOfHoursFieldOnActionsPopUp(){
        utils.assertElementNotPresent(By.xpath("//input[@id='Hours']"));}
    public void assertPresenceOfHoursFieldOnActionsPopUp(){
        utils.waitForElementVisible(By.xpath("//input[@id='Hours']"));}


    public void assertEmailFieldAbsentOnCallActionsPopUp(){
        utils.assertElementNotPresent(By.xpath("//label[text()='Email']"));}

    public void assertEmailFieldPresentOnCallActionsPopUp(String email){
        utils.waitForElementVisible(By.xpath("//label[text()='Email']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Email'][@value='"+email+"']"));}

    public void assertContactDetailsOnActionsPopUp(String contact,String phoneNumber,String summary,String loggedBy){
        utils.waitForElementVisible(By.xpath("//option[@data-email='"+contact+"'][@selected='selected']"));
        utils.waitForElementVisible(By.xpath("//input[@id='PhoneNumber'][@value='"+phoneNumber+"']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Subject'][@value='"+summary+"']"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Logged by: "+loggedBy+"')]"));
    }
    public void saveActionPopUp(){
        utils.clickBtn(By.id("btnSaveIncidentAction"));
    }
    public void captureValidationForDepopulatedHoursField_AndRepopulate(){
        utils.clearField(By.id("Hours"));
        saveActionPopUp();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The Hours field is required.')]"));
        utils.sendText(By.id("Hours"),"1");
    }
    public void captureValidationForTimeField(){
        utils.clearField(By.id("CreatedTime"));
        saveActionPopUp();
        utils.waitForElementVisible(By.xpath("//p[text()='We are unable to log an incident action at this time.  If the problem persists, please contact your system administrator.']"));
        utils.clickBtn(By.xpath("//button[text()='Ok']"));
        utils.clickBtn(By.xpath("//span[@class='glyphicon glyphicon-time']"));
    }
    public void populateCallRadioButtonOnActionsPopUp_AndConfirmChanges(String button) throws InterruptedException {
        utils.clickBtn(By.xpath("//label[text()[contains(.,'"+button+"')]]"));
        saveActionPopUp();
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//td[contains(text(),'Made call')]/../td[1]"));
        utils.clickBtn(By.xpath("//input[@id='CallType'][@value='2'][@checked]"));
    }
    public void assertUserLoggedActionEntry(){
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Made call')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Test Symptom 1')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Reed, Adam')]"));

    }
    public void assertOpenReachLoggedActionEntry() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("MM/dd/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Logged with Openreach')]"));
    }
    public void assertDefaultActionCreatedOnStatusChange(String currentStatus,String newStatus)
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("MM/dd/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Status changed from "+ currentStatus +" to "+ newStatus +"')]"));
    }
    public void assertOpenReachLoggedActionPopUp(){
        utils.clickBtn(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("MM/dd/yyyy")+"')]]"));
        utils.waitForElementVisible(By.xpath("//select[@id='ContactId']//option[contains(text(),'Select contact')]"));
        utils.waitForElementVisible(By.xpath("//input[@id='Subject'][@readonly='readonly'][@value='Logged with Openreach']"));
        utils.waitForElementVisible(By.xpath("//input[@id='CreatedDate'][@readonly='readonly']"));
        utils.waitForElementVisible(By.xpath("//input[@id='CreatedTime'][@readonly='readonly']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Hours'][@readonly='readonly']"));
    }
    public void changeTheContactTypeAndSaveOpenReachLoggedActionPopUp_andConfirmChanges(){
        utils.selectByVisibleText(By.id("ContactId"),"Adam Reed (adam.reed@unionstreet.uk.com)");
        utils.sendText(By.id("Summary"),"EnteredSummary");
        saveActionPopUp();
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Logged with Openreach')]/following-sibling::td[1][contains(text(),'Reed, Adam')]/following-sibling::td[contains(text(),'EnteredSummary')]"));
    }

    public void editTargetResponseAndTargetClearTimes(int times) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_responses set target_response_hours="+times+", escalate_response_hours="+times+" where RecordID=65");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_clears set target_clear_hours="+times+", escalate_clear_hours="+times+" where RecordID=15");
    }
    public void editResponseAndTargetWarningTimes(int times) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_responses set response_warning_mins="+times+" where RecordID=65");
        utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_clears set clear_warning_mins="+times+" where RecordID=15");
    }

    public void assertBadgeLabelTextBeforeOrderCompletion(String typeOfBadge,String time,String widgetContainer,String timeLeft, String colour) throws ParseException {
        utils.waitForElementVisible(By.xpath("//div[@class='stats-info']//h4[contains(text(),'"+typeOfBadge+"')]/..//p[contains(text(),'"+utils.getCurrentDate("YYYY-MM-dd")+" "+time+"')]/..//h4[contains(text(),'"+timeLeft+"')]"));
        utils.waitForElementVisible(By.xpath("//div[@id='"+widgetContainer+"']//i[@class='fa fa-clock-o']"));
        utils.waitForElementVisible(By.xpath("//div[@class='widget widget-stats widgetbadge bg-"+colour+"'][@id='TargetClear_widgetcontainer']"));
    }
//    public String add_or_subtractHoursToCurrentTime(String format,int addHours){
//        String updatedTime = new SimpleDateFormat(format).format(serviceDesk_ticketDetailsPage.Level4Time(addHours));
//        return updatedTime;
//    }
    public void clickStatusButtonAndChooseAction(String option) throws InterruptedException {
        utils.clickBtn(By.xpath("//i[@class='fa fa-pencil']"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[text()='"+option+"']"));
        utils.clickBtn(By.xpath("//button[contains(text(),'Yes')]"));
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'"+option+"')]"));
    }
    public void updateActionStatus() throws InterruptedException, SQLException {
        clickStatusButtonAndChooseAction("Waiting");
        utils.waitForElementVisible(By.xpath("//td[text()='Status changed from Queued to Waiting']"));
        clickStatusButtonAndChooseAction("Complete");
        utils.waitForElementVisible(By.xpath("//h4[text()='TARGET CLEAR']/following-sibling::p[contains(text(),'Cleared')]/following-sibling::h4[text()='"+utils.getCurrentDate("YYYY-MM-dd")+" "+utils.getCurrentDate("HH:mm")+"']"));
        utils.waitForElementVisible(By.xpath("//input[@id='TargetClear_CountdownRefresh']/following-sibling::div/i[@class='fa fa-check-circle-o']"));
        utils.waitForElementVisible(By.xpath("//input[@id='TargetResponse_CountdownRefresh']/following-sibling::div/i[@class='fa fa-check-circle-o']"));
        utils.sqlQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "select actual_response from incidents where RecordID='"+serviceDesk_callerDetails_triagePage.getIncidentID()+"'");
        utils.result.next();
        utils.splitStringInSQLquery(utils.result.getString(1));
        String LevelDay = split[0];
        System.out.println(LevelDay);
        Assert.assertEquals(LevelDay,utils.getCurrentDate("YYYY-MM-dd"));
    }

//    public void updateBaseToMimicFridayAfterWorkLogin() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
//        utils.sqlExeQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_hours set Mon=null,Tue=null,Wed=null,Thu=null,Fri=null,Sat=null,BH=null where RecordID=1");
//        utils.sqlExeQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_hours set "+utils.getCurrentDate("EEE")+"='1' where RecordID=1");
//        utils.sqlExeQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update servicelevel_hours set StartTime='1899-12-30 "+add_or_subtractHoursToCurrentTime("HH:mm",15)+":00.000',EndTime='1899-12-30 "+add_or_subtractHoursToCurrentTime("HH:mm",-1)+":00.000' where RecordID=1");
//
//
//
//    }


}
