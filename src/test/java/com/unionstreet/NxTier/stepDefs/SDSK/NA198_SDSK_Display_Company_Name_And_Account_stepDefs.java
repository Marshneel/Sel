package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NA198_SDSK_Display_Company_Name_And_Account_stepDefs
{
    WebModel webModel=new WebModel();
    NA193_SDSK_OpenReach_Site_Information_stepDefs na193 = new NA193_SDSK_OpenReach_Site_Information_stepDefs();

    @When("^I raise an open reach incident and submit it$")
    public void iRaiseAnOpenReachIncidentAndSubmitIt() throws java.lang.Exception
    {
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update SiteDetails set SiteName ='Adam As A Reseller',ShortName='Adam' where SiteID='311'");
        webModel.getDashBoardPage().loadServiceDesk();
        webModel.getServiceDeskPage().loadLoginIncidentPageAndAssertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByAccountName("Adam As A Reseller");
        webModel.getServiceDeskPage().clickOnResult("Adam");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_callerDetailsTriagePage().non_OpenReachIncident_Triage();
        //na193.iNavigateToServiceDeskPageToRaiseAnOpenreachIncidentWithAnalogueLinetype();
        //webModel.getServiceDesk_ticketDetailsPage().SaveAndSubmitIncident();

    }


    @And("^I should be able to validate that company and site name are displayed when company and site name are not same$")
    public void iShouldBeAbleToValidateThatCompanyAndSiteNameAreDisplayedWhenCompanyAndSiteNameAreNotSame()
    {
        webModel.getServiceDesk_actionsPage().assertCompanyAndSiteNameAreDisplayedOnViewAndAmmendDetailsPage("Adam As A Reseller","Richmond");
    }

    @And("^I should be able to validate that company and short name are displayed when company and site name are same$")
    public void iShouldBeAbleToValidateThatCompanyAndShortNameAreDisplayedWhenCompanyAndSiteNameAreSame() throws java.lang.Exception
    {
        //webModel.getServiceDesk_actionsPage().assertCompanyAndShortNameAreDisplayedOnViewAndAmmendDetailsPage("Adam As A Reseller","Adam As A Reseller");
        webModel.getServiceDesk_actionsPage().assertCompanyAndShortNameAreDisplayedOnViewAndAmmendDetailsPage("Adam As A Reseller","Adam");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update SiteDetails set SiteName ='Not the Reseller site',ShortName='Not the Reseller site' where SiteID='311'");

    }

    @And("^I should be able to validate that only company name should be displayed when company and site name are same and short name is null or empty$")
    public void iShouldBeAbleToValidateThatOnlyCompanyNameShouldBeDisplayedWhenCompanyAndSiteNameAreSameAndShortNameIsNullOrEmpty() throws java.lang.Exception
    {
        webModel.getServiceDesk_actionsPage().assertOnlyCompanyDisplayedOnViewAndAmmendDetailsPage("Adam As A Reseller"," ");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update SiteDetails set SiteName ='Not the Reseller site',ShortName='Not the Reseller site' where SiteID='311'");

    }

    @When("^I raise an incident and submit it$")
    public void iRaiseAnIncidentAndSubmitIt() throws java.lang.Exception
    {
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");
        webModel.getDashBoardPage().loadServiceDesk();
        webModel.getServiceDeskPage().loadLoginIncidentPageAndAssertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByAccountName("Adam As A Reseller");
        webModel.getServiceDeskPage().clickOnResult("Rich421");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_callerDetailsTriagePage().non_OpenReachIncident_Triage();

    }

    @When("^I raise a incident and submit it$")
    public void iRaiseAIncidentAndSubmitIt() throws java.lang.Exception
    {

        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update incident_types set is_default=NULL");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueNumber='0' where ID='150'");
        webModel.getUtils().sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update SiteDetails set SiteName ='Adam As A Reseller',ShortName=' ' where SiteID='311'");
        webModel.getDashBoardPage().loadServiceDesk();
        webModel.getServiceDeskPage().loadLoginIncidentPageAndAssertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByAccountName("Adam As A Reseller");
        webModel.getServiceDeskPage().clickOnResult("");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDesk_callerDetailsTriagePage().clickNextAfterPopulatingContact();
        webModel.getServiceDesk_callerDetailsTriagePage().non_OpenReachIncident_Triage();

    }
}
