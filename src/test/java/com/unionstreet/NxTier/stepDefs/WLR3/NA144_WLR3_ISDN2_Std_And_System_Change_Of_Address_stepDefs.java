package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 25/05/2017.
 */
public class NA144_WLR3_ISDN2_Std_And_System_Change_Of_Address_stepDefs {

    WebModel webModel=new WebModel();
    @When("^I initiate a change of address service on ISDN(\\d+) standard line$")
    public void iInitiateAChangeOfAddressServiceOnISDNStandardLine(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI2E00000002'");
        webModel.getAddServicePage().searchAndAddService("Change of Address",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("01202300913","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().saveLineSelection();
    }

    @Then("^I should be able to check and verify whether the number of channels is not editable$")
    public void iShouldBeAbleToCheckAndVerifyWhetherTheNumberOfChannelsIsNotEditable() throws InterruptedException, SQLException, UnsupportedEncodingException, ClassNotFoundException {
        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(1);
        webModel.getWlr3_newProvide__provisionPage().assertChannelOptionsAbsent();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().closeWizard();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertChannelsNotEditable();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000002'");



    }

    @When("^I initiate a change of address service on ISDN(\\d+) system line$")
    public void iInitiateAChangeOfAddressServiceOnISDNSystemLine(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI2E00000003'");
        webModel.getAddServicePage().searchAndAddService("Change of Address",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().textOnChangeOfAddressOrderPage();
        webModel.getWlr3_addRemoveAuxLinePage().populateCLIandPostCode("01202300920","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().saveLineSelection();
    }

    @Then("^I should be able to check and verify whether the number of channels is editable$")
    public void iShouldBeAbleToCheckAndVerifyWhetherTheNumberOfChannelsIsEditable() throws InterruptedException, SQLException, UnsupportedEncodingException, ClassNotFoundException {
        webModel.getWlr3_installationAddressPage().searchForAddress("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().pickAddressFromSearchResults();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(1);
        webModel.getWlr3_newProvide__provisionPage().assertChannelOptionsPresent();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().closeWizard();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertChannelsAreEditable();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000003'");
    }
}
