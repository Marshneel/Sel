package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 22/05/2017.
 */
public class NA138_WLR3_ISDN2System_AnalogueBasic_Change_Of_Line_Type_And_ViceVersa_stepDefs {

    WebModel webModel = new WebModel();

    @When("^I initiate a change of line from ISDN(\\d+) system to basic analogue$")
    public void iInitiateAChangeOfLineFromISDNSystemToBasicAnalogue(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI2E00000003'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300920", "LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("ISDN2 System (Current)", "Basic Analogue");
    }

    @Then("^Then I should be able to check all the required validations and complete the change of line type order from ISDN(\\d+) system to basic analogue$")
    public void thenIShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromISDNSystemToBasicAnalogue(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {

        webModel.getWlr3_orderDetails_page().verifyLineTypeAndProvisionType("ISDN2 System > Basic Analogue", "Convert");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertSignalTypeIsUnAvailableForLineBox();
        webModel.getWlr3_line_information_page().assertEnabledFieldsUnderLineInfoForTransferOrder();
        webModel.getWlr3_line_information_page().verifySMPFcodePresent();
        webModel.getWlr3_line_information_page().verifyLineInformationTab("Level 1", "1");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_newProvide__provisionPage().terminationTypeForAnalogueBasicLine();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000003'");

    }


    @When("^I initiate a change of line from basic analogue to ISDN(\\d+) system$")
    public void iInitiateAChangeOfLineFromBasicAnalogueToISDNSystem(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02012345678'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("02012345678", "LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Basic Analogue (Current)", "ISDN2 System");
    }

    @Then("^Then I should be able to check all the required validations and complete the change of line type order from basic analogue to ISDN(\\d+) system$")
    public void thenIShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromBasicAnalogueToISDNSystem(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {

        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Number of lines increased to 2");
        webModel.getWlr3_orderDetails_page().verifyLineTypeAndProvisionType("Basic Analogue > ISDN2 System", "Convert");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Number of lines increased to 2");
        webModel.getWlr3_orderDetails_page().assertChannelsAreEditable();
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().setCareLevelPlanAndDigitsToSwitchForISDNLines("Level 1", "2", "1 and 15", "15");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("0209876543");
        webModel.getWlr3_siteInformationPage().populateFloorAndRoomForNewProvideIDSN2();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02012345678'");
    }
}
