package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 22/05/2017.
 */
public class NA140_WLR3_Multiline_Change_Of_Address_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a change of address service on multiline$")
    public void iInitiateAChangeOfAddressServiceOnMultiline() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02087654321'");
        webModel.getAddServicePage().searchAndAddService("Change of Address",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("02087654321", "LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().saveLineSelection();
    }

    @Then("^I should be able to check the validations and complete the change of address for multiline$")
    public void iShouldBeAbleToCheckTheValidationsAndCompleteTheChangeOfAddressForMultiline() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {

        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(1);
        webModel.getWlr3_newProvide__provisionPage().validationForNumberOfLinesForMultiline("0", "100", "10");
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(4);
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertChannelsAreEditable();
        webModel.getWlr3_orderDetails_page().verifyLineTypeAndProvisionType("Analogue Multiline", "New Line Plant");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assertTakeOverWorkingLineAbsent();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02087654321'");

    }
}
