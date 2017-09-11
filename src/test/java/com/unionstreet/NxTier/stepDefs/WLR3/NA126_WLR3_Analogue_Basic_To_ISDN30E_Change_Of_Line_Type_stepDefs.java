package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 04/05/2017.
 */
public class NA126_WLR3_Analogue_Basic_To_ISDN30E_Change_Of_Line_Type_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a change of line type from analogue basic single to ISDN(\\d+)E$")
    public void iInitiateAChangeOfLineTypeFromAnalogueBasicSingleToISDNE(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02012345678'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        //former is the current line and the later is the line that you are switching to
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("02012345678", "LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Basic Analogue (Current)", "ISDN30E");

    }

    @Then("^I should be able to check all the required validations and complete the change of line type order from analogue basic to ISDN(\\d+)E$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromAnalogueBasicToISDNE(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertDefaultAndEditableChannels("8");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Number of lines increased to 8");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Call Sign");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Presentation Number");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().editChannelNumberForPremiumAndISDNlines("Numer of Channels", "8", "999");
        webModel.getWlr3_orderDetails_page().errorMessages_WhenLineIsChangedFromAnalogueToISDN();
        webModel.getWlr3_orderDetails_page().errorMessagesWhenEngineeringVisitIsRequired();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("0209876543");
        webModel.getWlr3_siteInformationPage().populateFloorAndRoomForNewProvideIDSN2();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_line_information_page().setCareLevelForPremiumAndISDNLineSwitch("Level 1","2");
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02012345678'");
    }


    @When("^I initiate a change of line from ISDN(\\d+)E to analogue basic$")
    public void iInitiateAChangeOfLineFromISDNEToAnalogueBasic(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI3000000001'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        //former is the current line and the later is the line that you are switching to
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300945", "LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("ISDN30E (Current)", "Basic Analogue");
    }

    @Then("^I should be able to check all the required validations and complete the change of line type order from ISDN(\\d+)E to analogue basic$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromISDNEToAnalogueBasic(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("6 Octet Sub Addressing");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Presentation Number (Type 1)");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Anonymous Call Reject");
        webModel.getWlr3_orderDetails_page().errorMessagesWhenEngineeringVisitIsRequired();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("0209876543");
        webModel.getWlr3_newProvide__provisionPage().terminationTypeForAnalogueBasicLine();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI3000000001'");

    }
}