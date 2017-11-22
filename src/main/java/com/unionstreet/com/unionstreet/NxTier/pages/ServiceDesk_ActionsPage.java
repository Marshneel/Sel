package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.BaseClass;
import com.unionstreet.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.unionstreet.support.ElementUtils.split;

public class ServiceDesk_ActionsPage
{
    private final String TEXT_ON_VIEW_AND_AMEND_DETAILS_PAGE = "//h1[@class='page-header']//small[contains(text(),'View and Amend Details')]";
    private final String INCIDENT_CONTACT_INFORMATION_SAVEBTN = "//a[contains(text(),'Cancel')]//following-sibling::a[contains(text(),'Save')]";
    private final String INCIDENT_CONTACT_INFORMATION_TEXT = "//h4[contains(text(),'Incident Contact Information')]";
    private final String VIEW_AND_AMEND_DETAILS_EDIT_ICON = "ShowIncidentContactmodal";
    private final String INCIDENT_CONTACT_INFORMATION_CANCELBTN = "//a[contains(text(),'Cancel')]";
    private final String MARK_AS_RESPONDED_CHCKBOX = "//input[@id='Responded']/following-sibling::label[contains(text(),'Mark as Responded')]";
    private final String PRIORITY_LABEL = "//div[contains(text(),'Priority')]";
    private final String INCIDENT_DETAILS_PANEL_TEXT = "//h4[contains(text(),'Incident Details')]";
    private final String INCIDENT_DETAILS_PANEL_EDIT_ICON = "//a[@class='btn btn-primary'][@data-toggle='modal']";
    private final String SAVE_INCIDENT_DETAILS_BUTTON = "//a[contains(text(),'Cancel')]//following-sibling::a[@id='ModalEditIncidentDetailsSave']";
    private final String OWNER_LABEL = "//div[contains(text(),'Owner')]";


    ElementUtils utils=new ElementUtils();
    //ServiceDesk_TicketDetailsPage serviceDesk_ticketDetailsPage=new ServiceDesk_TicketDetailsPage();
    ServiceDesk_CallerDetails_TriagePage serviceDesk_callerDetails_triagePage=new ServiceDesk_CallerDetails_TriagePage();
    public void assertIncidentViewAndAmendDetails() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath(TEXT_ON_VIEW_AND_AMEND_DETAILS_PAGE));
        Thread.sleep(5000);

    }
    public void ClickEditIconOnIncidentDetailsPanel()
    {
        utils.waitForElementVisible(By.xpath(INCIDENT_DETAILS_PANEL_EDIT_ICON));
        utils.clickBtn(By.xpath(INCIDENT_DETAILS_PANEL_EDIT_ICON));
    }
    public void ValidateIncidentDetailsModalFieldsOnEditMode(String Type,String Symptom,String Category,String Summary,String Notes)
    {

        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'Incident Details')]"));
        utils.waitForElementVisible(By.xpath("//label[@for='IncidentType'][text()[contains(.,'Type')]]"));
        utils.waitForElementVisible(By.xpath("//p[@id='IncidentDetails_IncidentType'][contains(text(),'"+Type+"')]"));
        utils.waitForElementVisible(By.xpath("//label[@for='IncidentSymptom'][text()[contains(.,'Symptom')]]"));
        utils.waitForElementVisible(By.xpath("//p[@id='IncidentDetails_IncidentSymptom'][contains(text(),'"+Symptom+"')]"));
        utils.waitForElementVisible(By.xpath("//label[@for='IncidentCategory'][text()[contains(.,'Category')]]"));
        utils.waitForElementVisible(By.xpath("//p[@id='IncidentDetails_IncidentCategory'][contains(text(),'"+Category+"')]"));
        utils.waitForElementVisible(By.xpath("//label[@for='IncidentSummary'][text()[contains(.,'Summary')]]"));
        utils.waitForElementVisible(By.xpath("//p[@id='IncidentDetails_IncidentSummary'][contains(text(),'"+Summary+"')]"));
        utils.waitForElementVisible(By.xpath("//label[@for='IncidentNotes'][text()[contains(.,'Notes')]]"));
        utils.waitForElementVisible(By.xpath("//p[@id='IncidentDetails_IncidentNotes'][contains(text(),'"+Notes+"')]"));

    }
    public void EditFieldsOnIncidentDetailsModal(String Symptom,String Category,String Summary,String Notes)
    {
       utils.selectByVisibleText(By.id("IncidentSymptom"),Symptom);
       utils.selectByVisibleText(By.id("IncidentCategory"),Category);
       utils.selectByVisibleText(By.id("IncidentSymptom"),"Test Symptom 1");
       utils.waitForElementVisible(By.xpath("//option[contains(text(),'Test Category 1')]"));
       utils.sendText(By.id("IncidentSummary"),Summary);
       utils.sendText(By.id("IncidentNotes"),Notes);
    }
    public void changeCategoryOnIncidentDetailsEditModal(String newCategory) {
        utils.clickBtn(By.id("IncidentCategory"));
        utils.selectByVisibleText(By.id("IncidentCategory"), newCategory);
        utils.clickBtn(By.id("IncidentCategory"));
    }

    public void assertDefaultActionCreatedOnCategoryChange(String currentCategory,String newCategory)
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Incident Category changed from "+ currentCategory +" to "+ newCategory +"')]"));

    }
    public void ClickSaveOnIncidentDetailsModal()
    {
        utils.clickBtn(By.xpath(SAVE_INCIDENT_DETAILS_BUTTON));
        //Thread.sleep(1000);
    }
    public void assertIncidentDetailsPanel() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath(INCIDENT_DETAILS_PANEL_TEXT));
        Thread.sleep(5000);
    }
    public void assertContactDetailsOnIncidentContactInformationModal()
    {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'"+serviceDesk_callerDetails_triagePage.NameValue+"')]//following-sibling::a[contains(text(),'"+serviceDesk_callerDetails_triagePage.EmailValue+"')]//following-sibling::span[contains(text(),'"+serviceDesk_callerDetails_triagePage.TelValue+"')]"));


    }
    public void clickOnOwnerDropDown() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath(OWNER_LABEL));
        utils.clickBtn(By.id("CurrentOwner"));
        Thread.sleep(1000);
    }

    public void printOwnerDropDownList()
    {
        List<WebElement> ContactsList = BaseClass.driver.findElements(By.id("IncidentOwners"));
       // Loop to print one by one
       for (int i = 0; i < ContactsList.size(); i++) {
       System.out.println(ContactsList.get(i).getText());
       }

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
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'New ACTION')]]"));
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
        //Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[text()[contains(.,'New ACTION')]]"));
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
    public void AssertPriorityComponent()
    {
        utils.waitForElementVisible(By.xpath(PRIORITY_LABEL));

    }
    public void ChangePriority(int NewPriority)
    {
       AssertPriorityComponent();
       utils.clickBtn(By.id("CurrentPriority"));
       utils.clickBtn(By.xpath("//a[@data-priority="+NewPriority+"]"));
       utils.clickBtn(By.xpath("//button[contains(text(),'Yes')]"));

    }
    public void ChangeOwner(String NewOwner)
    {
        utils.clickBtn(By.xpath("//a[contains(text(),'"+NewOwner+"')]"));

    }
    public void ConfirmationModalPopup() throws InterruptedException
    {
        utils.clickBtn(By.xpath("//button[contains(text(),'Yes')]"));
        Thread.sleep(1000);
    }
    public void assertNotificationModalPopUp()
    {
        utils.waitForElementVisible(By.id("modal-alert-label"));
        utils.waitForElementVisible(By.xpath("//p[contains(text(),'The Owner you have selected is missing required contact information. Please complete this information or select a different Owner to continue.')]"));
        utils.clickBtn(By.xpath("//button[contains(text(),'Ok')]"));

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
    public void saveActionPopUp() throws InterruptedException
    {
        utils.clickBtn(By.id("btnSaveIncidentAction"));
        Thread.sleep(5000);
    }
    public void captureValidationForDepopulatedHoursField_AndRepopulate() throws InterruptedException
    {
        utils.clearField(By.id("Hours"));
        saveActionPopUp();
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'The Hours field is required.')]"));
        utils.sendText(By.id("Hours"),"1");
    }
    public void captureValidationForTimeField() throws InterruptedException
    {
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
    public void assertRespondedActionEntry() throws InterruptedException
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Responded')]"));
    }
    public void assertAbsenceOfMarkAsRespondedCheckbox()
    {
        utils.assertElementNotPresent(By.xpath(MARK_AS_RESPONDED_CHCKBOX));
    }
    public void retrieveCurrentStatusOfAnIncident(String currentStatus)
    {
        utils.waitForElementVisible(By.xpath("//h1[contains(text(),'"+currentStatus+"')]"));
       //utils.getAttributeOfElement(By.xpath("//h1[@class='m-t-4 text-primary']"),"Value");
//       String s=BaseClass.driver.findElement(By.xpath("//h1[@class='m-t-4 text-primary']")).getText();
//       System.out.println(s);
    }
    public void assertOpenReachLoggedActionEntry() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Logged with Openreach')]"));
    }
    public void assertDefaultActionCreatedOnStatusChange(String currentStatus,String newStatus)
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Status changed from "+ currentStatus +" to "+ newStatus +"')]"));
    }
    public void clickdefaultActionCreatedOnStatusChange(String currentStatus,String newStatus)
    {
        //utils.waitForElementVisible(By.xpath("//td[contains(text(),'Status changed from "+ currentStatus +" to "+ newStatus +"')]/preceding-sibling::td[contains(text(),'Status Change')]/preceding-sibling::a[text[contains(.,'"+utils.getCurrentDate("MM/dd/yyyy")+"')]]"));
       // utils.clickBtn(By.xpath("//td[contains(text(),'Status changed from "+ currentStatus +" to "+ newStatus +"')]/preceding-sibling::td[contains(text(),'Status Change')]/preceding-sibling::a[text[contains(.,'"+utils.getCurrentDate("MM/dd/yyyy")+"')]]"));
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Status changed from "+ currentStatus +" to "+ newStatus +"')]"));
       utils.clickBtn(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]"));

    }
    public void assertDefaultActionCreatedOnPriorityChange(int CurrentPriority,int NewPriority)
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Incident priority changed from "+ CurrentPriority +" to "+ NewPriority +"')]"));

    }
    public void assertDefaultActionCreatedOnOwnerChange(String CurrentOwner,String NewOwner)
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Owner changed from "+ CurrentOwner +" to "+ NewOwner +"')]"));

    }
    public void assertMarkAsRespondedIsCheckedAndIsNotEnabled()
    {
        utils.assertChecked(By.xpath(MARK_AS_RESPONDED_CHCKBOX));
        //utils.assertIsEnabled(By.xpath(MARK_AS_RESPONDED_CHCKBOX));
    }
    public void selectMarkAsRespondedCheckbox()
    {
        utils.clickBtn(By.xpath(MARK_AS_RESPONDED_CHCKBOX));
    }

    public void assertMarkAsRespondedIsUnchecked() throws InterruptedException
    {
        Thread.sleep(5000);
        utils.assertUnchecked(By.xpath(MARK_AS_RESPONDED_CHCKBOX));
    }
    public void ClickOnLoggedWithOpenReachAction()
    {
        utils.waitForElementVisible(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]/../following-sibling::td[2][contains(text(),'Logged with Openreach')]"));
        utils.clickBtn(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("dd/MM/yyyy")+"')]]"));
    }

    public void assertOpenReachLoggedActionPopUp(){
        utils.clickBtn(By.xpath("//a[text()[contains(.,'"+utils.getCurrentDate("MM/dd/yyyy")+"')]]"));
        utils.waitForElementVisible(By.xpath("//select[@id='ContactId']//option[contains(text(),'Select contact')]"));
        utils.waitForElementVisible(By.xpath("//input[@id='Subject'][@readonly='readonly'][@value='Logged with Openreach']"));
        utils.waitForElementVisible(By.xpath("//input[@id='CreatedDate'][@readonly='readonly']"));
        utils.waitForElementVisible(By.xpath("//input[@id='CreatedTime'][@readonly='readonly']"));
        utils.waitForElementVisible(By.xpath("//input[@id='Hours'][@readonly='readonly']"));
    }
    public void changeTheContactTypeAndSaveOpenReachLoggedActionPopUp_andConfirmChanges() throws InterruptedException
    {
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
        //utils.clickBtn(By.xpath("//a[@href='javascript']//i[@class='fa fa-pencil']"));
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
    public void ChangeStatus()  throws InterruptedException, SQLException
    {
        clickStatusButtonAndChooseAction("Waiting");
        utils.waitForElementVisible(By.xpath("//td[text()='Status changed from Queued to Waiting']"));
    }

    public void UpdatePriorityAndAssertTargetClearBadgeRefreshed() throws InterruptedException, SQLException
    {
        utils.waitForElementVisible(By.xpath("//h4[text()='TARGET CLEAR']"));
        //  Retrieving target_clear column value from Incidents table
        utils.sqlQuery("Portal", "moe\\devsql2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "select target_clear from incidents where RecordID='"+serviceDesk_callerDetails_triagePage.getIncidentID()+"'");
        utils.result.next();
        utils.splitStringInSQLquery(utils.result.getString(1));
        // split[0] contains date and split[1] contains time HH:MM:SS
        String TargetClearDateTime = split[0]+" "+split[1];
        // considering only date + HH:MM
        String DisplayedTargetClearDateTime=TargetClearDateTime.substring(0,16);
        System.out.println(TargetClearDateTime.substring(0,16));
        // asserting the column value taken from the table is the same as in the locator on the UI
        utils.searchAndAssertTextPresent(By.xpath("//p"),DisplayedTargetClearDateTime);
        // taking the time remaining value from DOM with the help of getAttribute method
        WebElement timefortargetClear = BaseClass.driver.findElement(By.id("TargetClear_CountdownDisplay"));
        String DateTimeRemaining = timefortargetClear.getAttribute("textContent");
        // converting the value to uppercase as the Time Remaining value on UI is in uppercase but in DOM its in lower case
        System.out.println(DateTimeRemaining.toUpperCase());
        utils.waitForElementVisible(By.xpath("//h4[contains(text(),'"+DateTimeRemaining+"')]"));
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // Adding 1 minute to current time
        Date date = new Date(System.currentTimeMillis()+1*60*1000);
        String Currentdate=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        Date d1=null;
        Date d2=null;
        try {
            // here we are finding the difference between current DateTime and Expected DateTime
               d1=format.parse(Currentdate);
               d2= format.parse(TargetClearDateTime.substring(0,16));
               long diff = d2.getTime() - d1.getTime();
               long diffHours = diff/(60*60*1000)%24;
               long diffMinutes = diff/(60*1000)%60;
               long diffDays = diff/(24*60*60*1000);
            System.out.print(diffDays+"D"+","+diffHours+"H"+", "+"AND "+diffMinutes+" MINUTES REMAINING \n");
           // System.out.println();
            // Checking whether the TimeRemaining value taken from DOM is equal to the one we got from the difference
         Assert.assertEquals(DateTimeRemaining.toUpperCase(),diffDays+"D"+", "+diffHours+"H"+", "+" AND "+diffMinutes+" MINUTES REMAINING");//utils.searchAndAssertTextPresent(By.id("TargetClear_CountdownDisplay"),diffDays+"D"+","+diffHours+"H"+", "+"AND "+diffMinutes+" MINUTES REMAINING");
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

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
