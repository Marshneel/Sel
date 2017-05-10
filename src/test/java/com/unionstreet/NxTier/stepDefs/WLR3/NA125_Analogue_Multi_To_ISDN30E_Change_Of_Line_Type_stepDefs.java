package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 04/05/2017.
 */
public class NA125_Analogue_Multi_To_ISDN30E_Change_Of_Line_Type_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a change of line from analogue multi to ISDN(\\d+)E$")
    public void iInitiateAChangeOfLineFromAnalogueMultiToISDNE(int arg0) throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        //former is the current line and the later is the line that you are switching to
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300909","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Analogue Multiline (Current)","ISDN30E");

    }

    @Then("^I should be able to check all the required validations and complete the change of line type order from analogue Multi to ISDN(\\d+)E$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromAnalogueMultiToISDNE(int arg0) throws InterruptedException {
    webModel.getWlr3_orderDetails_page().assertDefaultAndEditableChannels("8");
        webModel.getWlr3_orderDetails_page().editChannelNumberForPremiumAndISDNlines("Numer of Channels","8","999");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Bypass number");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Presentation Number");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Anonymous Call Reject");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().errorMessages_WhenLineIsChangedFromAnalogueToISDN();
        webModel.getWlr3_orderDetails_page().errorMessagesWhenEngineeringVisitIsRequired();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("0209876543");
        webModel.getWlr3_siteInformationPage().populateFloorAndRoomForNewProvideIDSN2();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();





    }

    @When("^I initiate a change of line from ISDN(\\d+)E to analogue multi$")
    public void iInitiateAChangeOfLineFromISDNEToAnalogueMulti(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        //former is the current line and the later is the line that you are switching to
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI3000000001'");
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300930","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("ISDN30E (Current)","Analogue Multiline");
    }

    @Then("^I should be able to check all the required validations and complete the change of line type order from ISDN(\\d+)E to analogue multi$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromISDNEToAnalogueMulti(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().editChannelNumberForPremiumAndISDNlines("Numer of Lines","2","99");
        webModel.getWlr3_orderDetails_page().errorMessagesWhenEngineeringVisitIsRequired();
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("6 Octet Sub Addressing");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Presentation Number (Type 1)");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("0209876543");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI3000000001'");
    }
}
