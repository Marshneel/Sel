package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 15/05/2017.
 */
public class NA129_WLR3_ISDN2_Standard_To_Basic_Analogue_Change_Of_Line_Type_stepDefs {

    WebModel webModel= new WebModel();

    @When("^I initiate a change of line from ISDN(\\d+) standard to basic analogue$")
    public void iInitiateAChangeOfLineFromISDNStandardToBasicAnalogue(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI2E00000002'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300913","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("ISDN2 Standard (Current)","Basic Analogue");

    }

    @Then("^Then I should be able to check all the required validations and complete the change of line type order from ISDN(\\d+) standard to basic analogue$")
    public void thenIShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromISDNStandardToBasicAnalogue(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("20 Octet Sub Addressing");
        webModel.getWlr3_line_information_page().setCareLevelForBasicLineSwitch("Level 1");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("0209876543");
        webModel.getWlr3_newProvide__provisionPage().terminationTypeForAnalogueBasicLine();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().accessAppointmentpage();
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        webModel.getWlr3_appointmentPage().saveAppointments();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000002'");

    }

    @When("^I initiate a change of line from basic analogue to ISDN(\\d+) standard$")
    public void iInitiateAChangeOfLineFromBasicAnalogueToISDNStandard(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("02012345678","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Basic Analogue (Current)","ISDN2 Standard");
    }

    @Then("^Then I should be able to check all the required validations and complete the change of line type order from basic analogue to ISDN(\\d+) standard$")
    public void thenIShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOfLineTypeOrderFromBasicAnalogueToISDNStandard(int arg0) throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Number of lines increased to 2");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Call Sign");
        webModel.getWlr3_orderDetails_page().assertChannelsNotEditable();
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("Presentation Number");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().setCareLevelPlanAndDigitsToSwitchForISDNLines("Level 1","2","1 and 15","15");
        webModel.getWlr3_orderDetails_page().assertNumberOfDigitsToSwitchOnOrderDetailsPage("15");
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
}
