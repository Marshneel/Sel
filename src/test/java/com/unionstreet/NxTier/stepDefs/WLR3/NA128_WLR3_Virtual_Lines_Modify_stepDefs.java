package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 10/05/2017.
 */
public class NA128_WLR3_Virtual_Lines_Modify_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a modify order on an Remote Call Forward Virtual Line$")
    public void iInitiateAModifyOrderOnAnRemoteCallForwardVirtualLine() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='ORCF00000002'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR3 ISDN RCF' where serviceid='ORCF00000002'");
        webModel.getAddServicePage().searchAndAddService("Modify Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("01202300912", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^I should be able to check the flow of the remote call forward_virtual line$")
    public void iShouldBeAbleToCheckTheFlowOfTheRemoteCallForward_virtualLine() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().assertRemovedFeature("Raw Call Data");
        webModel.getWlr3_orderDetails_page().loadNetworkFeatures();
        webModel.getWlr3_networkCallingFeaturesPage().editCallFeaturesForRemoteCallFor_VirtualLines("");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().assertCLIrequiredAlertMessageForVirtualLines("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().assertSavedSiteContactTelephoneNumber("07894040256");
        webModel.getWlr3_orderDetails_page().assertTextUnderCharges("Raw Call Data");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().checkServiceMaintenanceForVirtualLines("1","2","2.5","3","4");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='ORCF00000002'");





    }

    @When("^I initiate a modify order on an Caller Redirect Virtual Line$")
    public void iInitiateAModifyOrderOnAnCallerRedirectVirtualLine() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OCR00000002'");
        webModel.getAddServicePage().searchAndAddService("Modify Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("01202300911", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^I should be able to check the flow of the caller redirect_virtual line$")
    public void iShouldBeAbleToCheckTheFlowOfTheCallerRedirect_virtualLine() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Caller Redirect");
        webModel.getWlr3_orderDetails_page().loadNetworkFeatures();
        webModel.getWlr3_networkCallingFeaturesPage().toggleBetweenQuarterlyToMonthly_CallerRedirectVirtualLines();
        webModel.getWlr3_orderDetails_page().assertRemovedFeature("Raw Call Data");
        webModel.getWlr3_orderDetails_page().loadNetworkFeatures();
        webModel.getWlr3_networkCallingFeaturesPage().assertChangedFrequencyForCallerRedirect_VirtualLine();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OCR00000002'");





    }
}
