package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 25/04/2017.
 */
public class NA122_WLR3_ISDN2_Standard_And_System_Modify_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a modify order on an ISDN(\\d+) Standard line$")
    public void iInitiateAModifyOrderOnAnISDNStandardLine(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI2E00000002'");
        webModel.getAddServicePage().searchAndAddService("Modify Order");
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("01202300913", "LU1 1DQ");

    }

    @Then("^I should be able to check the flow of the ISDN(\\d+) Standard modify$")
    public void iShouldBeAbleToCheckTheFlowOfTheISDNStandardModify(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertDigitsToSwitchForAllISDN("1 and 15","15");
        webModel.getWlr3_orderDetails_page().assertNumberOfDigitsToSwitchOnOrderDetailsPage("15");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assignAdditionalSiteVisitReasonThroughCheckBox();
        webModel.getWlr3_orderDetails_page().assertErrorMessageForHazardAndWarningNotes();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().de_AssignAdditionalSiteVisitReasonThroughCheckBox();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().assignAdditionalSiteVisitReasonThroughCheckBox();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getWlr3_orderDetails_page().assertAbsenceOfErrorMessageForHazardAndWarningNotes();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000002'");
    }

    @When("^I initiate a modify order on an ISDN(\\d+) System line$")
    public void iInitiateAModifyOrderOnAnISDNSystemLine(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI2E00000003'");
        webModel.getAddServicePage().searchAndAddService("Modify Order");
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("01202300920", "LU1 1DQ");

    }

    @Then("^I should be able to check the flow of the ISDN(\\d+) System modify$")
    public void iShouldBeAbleToCheckTheFlowOfTheISDNSystemModify(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().populateAndSaveEngineeringNotes();
        webModel.getWlr3_orderDetails_page().assertErrorMessageForUnwantedEngineeringNotes();
        webModel.getWlr3_orderDetails_page().editChannelNumberForPremiumAndISDNlines("Numer of Channels","2","60");
        webModel.getWlr3_orderDetails_page().assertErrorMessageForHazardAndWarningNotes();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getWlr3_orderDetails_page().assertAbsenceOfErrorMessageForHazardAndWarningNotes();
        webModel.getWlr3_orderDetails_page().assertAbsentErrorMessageForUnwantedEngineeringNotes();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000003'");
    }
}
