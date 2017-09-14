package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 13/04/2017.
 */
public class NA117_WLR3_ISDN30_Change_Of_Address_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a change of address service for ISDN(\\d+)$")
    public void iInitiateAChangeOfAddressServiceForISDN(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI3000000001'");
        webModel.getAddServicePage().searchAndAddService("Change of Address",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("01202300945","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().confirmChangeOfOwnerShip();
    }

    @Then("^I should be able to check the validations and complete the change of address for ISDN(\\d+)$")
    public void iShouldBeAbleToCheckTheValidationsAndCompleteTheChangeOfAddressForISDN(int arg0) throws InterruptedException, SQLException, AWTException {
        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateEmergencyInfo();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__provisionPage().provisionPageForISDN30ChangeOfAddress();
        webModel.getWlr3_new_provide__orderPage().navigateToNextWithJavaCLick();
        webModel.getUtils().setStdZoom();
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(3);
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().openReachAddressValidationForISDN30();
        webModel.getWlr3_orderDetails_page().editOpenReachManaged();
        Thread.sleep(1000);
        webModel.getEditOrderPage().verifyOrderCompletion();
    }
}
