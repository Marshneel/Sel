package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 17/05/2017.
 */
public class NA137_WLR3_Premium_Multiline_Transfer_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate a transfer order on a Multiline$")
    public void iInitiateATransferOrderOnAMultiline() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='01202300909'");
        webModel.getAddServicePage().searchAndAddService("Transfer Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300909", "lu1 1dq");

    }

    @Then("^I should be able to check the flow of the transfer order on Multiline$")
    public void iShouldBeAbleToCheckTheFlowOfTheTransferOrderOnMultiline() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().assertTerminationTypeForPremiumLine("NTTP","Line Box");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().switchBetweenTerminationTypes("Line Box");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().errorMessagesWhenEngineeringVisitIsRequired();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_siteInformationPage().assertValidationMessageForSiteInfoPhoneNumber();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().switchBetweenTerminationTypes("NTTP");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().assertValidationMessageWhenTerminationTypeIsSwitched();
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertAndPopulateSignalTypeWhenSwitchedToNTTP();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();








    }
}
