package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 24/02/2017.
 */
public class NA100_WLR3_Basic_Premium_Single_Multi_ChangeOfLineType_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate a change of line from basic single to premium single$")
    public void iInitiateAChangeOfLineFromBasicSingleToPremiumSingle() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02012345678'");

        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        //former is the current line and the later is the line that you are switching to
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("02012345678","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Basic Analogue (Current)","Premium Analogue");
    }

    @Then("^I should be able to check all the required validations and complete the change order for basic to premium analogue$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOrderForBasicToPremiumAnalogue() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException, AWTException {
        webModel.getWlr3_line_information_page().setCareLevelForPremiumAndISDNLineSwitch("Level 1","2.5");
        //assert that the common features for single lines are highlighted
        webModel.getWlr3_orderDetails_page().verifyCommonNetworkCallingFeaturesForSingleLine("Call Sign","Presentation Number");
        webModel.getWlr3_directoryInformationPage().assertUniqueNetworkFeatureUnderDirectoryInfoForSingleLine("Call Sign");
        webModel.getWlr3_orderDetails_page().assertCLI("02012345678");
        webModel.getWlr3_orderDetails_page().assertLineCharges("Analogue Business Line");
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02012345678'");


    }

    @When("^I initiate a change of line from premium analogue to basic analogue$")
    public void iInitiateAChangeOfLineFromPremiumAnalogueToBasicAnalogue() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02063678369'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("02063678369","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Premium Analogue (Current)","Basic Analogue");
    }

    @Then("^I should be able to check all the required validations and complete the change order for premium to basic analogue$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOrderForPremiumToBasicAnalogue() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException, AWTException {
        //assert the termination type is absent on order summary page during premium to basic line switch
        webModel.getWlr3_orderDetails_page().assertAbsenceOfTerminationType("Linebox");
        webModel.getWlr3_orderDetails_page().assertValidationMessageOnOrderDetailsPage("Contact Details have not been entered correctly");
       webModel.getUtils().zoomOut();
        webModel.getWlr3_siteInformationPage().loadSiteInfo();
        webModel.getUtils().setStdZoom();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assertAndPopulateTerminationTypeForBasicLineSwitch("NTTP","Line Box");
        webModel.getWlr3_siteInformationPage().setUpTRCband();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_appointmentPage().populateHazardAndWarningNotes();
        webModel.getWlr3_orderDetails_page().assertLineCharges("Analogue Residential Line");
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02063678369'");

    }

    @When("^I initiate a change of line from basic analogue to premium multiple$")
    public void iInitiateAChangeOfLineFromBasicAnalogueToPremiumMultiple() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02012345678'");

        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("02012345678","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Basic Analogue (Current)","Analogue Multiline");
    }

    @Then("^I should be able to check all the required validations and complete the change order for basic to multiple$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOrderForBasicToMultiple() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        //asserting the warning message that says the number of lines have increased to 2
        webModel.getWlr3_orderDetails_page().assertWarningMessageOnSummaryPage("Number of lines increased to 2");
        //asserting the warning message that says the netowrk feature call sign (that is unique to single line) is unavailable during multi-line switch
        webModel.getWlr3_orderDetails_page().assertWarningMessageOnSummaryPage("Network Feature Call Sign is not available on a Analogue Multiline");
        webModel.getWlr3_orderDetails_page().assertingTheNumberOfLinesForMultiLineSwitch("2");
       //assert that the features that are native to single line are not available during multiline switch
        webModel.getWlr3_orderDetails_page().assertTheAbsenceOfFeatureUnderNetworkFeatures("Call Sign");
        webModel.getWlr3_line_information_page().setCareLevelForPremiumAndISDNLineSwitch("Level 1","2.5");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assertTerminationTypeForPremiumLine("NTTP","Line Box");
       webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().populateHazardAndWarningNotes();
        webModel.getWlr3_orderDetails_page().assertLineCharges("Analogue Multi-Line");
        webModel.getWlr3_orderDetails_page().assertNtwrkCallFeaturesAndDirectoryInfoForMultiLine("Call Sign");
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02012345678'");

    }

    @When("^I initiate a change of line type from multi to basic analogue$")
    public void iInitiateAChangeOfLineTypeFromMultiToBasicAnalogue() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='01202300909'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300909","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("Analogue Multiline (Current)","Basic Analogue");
    }

    @Then("^I should be able to check all the required validations and complete the change order from multi to analogue basic$")
    public void iShouldBeAbleToCheckAllTheRequiredValidationsAndCompleteTheChangeOrderFromMultiToAnalogueBasic() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        // assert un availability of network feature that is exclusive to multiline during single line switch
        webModel.getWlr3_orderDetails_page().assertWarningMessageOnSummaryPage("Network Feature unknown: Bypass number - individual line");
        webModel.getWlr3_line_information_page().setCareLevelForBasicLineSwitch("Level 1");
        webModel.getWlr3_siteInformationPage().loadSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
       //assert that the termination type that is exclusive to premium line is absent during the basic line switch
        webModel.getWlr3_siteInformationPage().assertAndPopulateTerminationTypeForBasicLineSwitch("NTTP","Line Box");
        webModel.getWlr3_siteInformationPage().setUpTRCband();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_appointmentPage().populateHazardAndWarningNotes();
        webModel.getWlr3_orderDetails_page().assertLineCharges("Analogue Residential Line");
        webModel.getWlr3_orderDetails_page().assertingTheNumberOfLinesForSingleLineSwitch("2");
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='01202300909'");
    }

    @When("^I initiate a change of line type service on the CLI that is not owned$")
    public void iInitiateAChangeOfLineTypeServiceOnTheCLIThatIsNotOwned() throws InterruptedException, SQLException, UnsupportedEncodingException, ClassNotFoundException {
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='01202300908'");
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300908","LU1 1DQ");
    }

    @Then("^A validation message requesting confirmation of ownership is displayed$")
    public void aValidationMessageRequestingConfirmationOfOwnershipIsDisplayed() {
    webModel.getWlr3_changeOfLineTypeOrderPage().confirmationOfOwnerShipMessage();
    }
}
