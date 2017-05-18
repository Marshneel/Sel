package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 17/05/2017.
 */
public class NA135_WLR3_Analogue_Basic_Transfer_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a transfer order on a Basic Analogue line$")
    public void iInitiateATransferOrderOnABasicAnalogueLine() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02012345678'");
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("02012345678", "lu1 1dq");
    }

    @Then("^I should be able to check the flow of the transfer order on basic analogue$")
    public void iShouldBeAbleToCheckTheFlowOfTheTransferOrderOnBasicAnalogue() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().verifyLineTypeAndProvisionType("Basic Analogue","Transfer");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertSignalTypeIsUnAvailableForLineBox();
        webModel.getWlr3_line_information_page().assertEnabledFieldsUnderLineInfoForTransferOrder();
        webModel.getWlr3_line_information_page().verifyLineInformationTab("Level 1", "1"); webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().assertInstallTypePresentInTransferOrder();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assertTerminationTypeForBasicLines("Line Box","NTTP");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();




    }
}
