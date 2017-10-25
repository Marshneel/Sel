package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 17/05/2017.F
 */
public class NA136_WLR3_Basic_Analogue_Modify_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate a modify order on a Basic Analogue line$")
    public void iInitiateAModifyOrderOnABasicAnalogueLine() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='02012345678'");
        webModel.getAddServicePage().searchAndAddService("Modify Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("02012345678", "LU1 1DQ");
    }

    @Then("^I should be able to check the flow of the modify order on basic analogue$")
    public void iShouldBeAbleToCheckTheFlowOfTheModifyOrderOnBasicAnalogue() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException, AWTException {
webModel.getWlr3_orderDetails_page().verifyLineTypeAndProvisionType("Basic Analogue","Change");
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().assertInstallTypeAbsentInModifyOrder();
        webModel.getWlr3_siteInformationPage().populateTelNumberUnderSiteInfo("07894040256");
        webModel.getWlr3_siteInformationPage().assertTerminationTypeForBasicLines("Line Box","NTTP");
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertSignalTypeIsUnAvailableForLineBox();
        webModel.getWlr3_line_information_page().assertDisabledFieldsUnderLineInfoForInModifyOrder();
        webModel.getWlr3_line_information_page().verifyLineInformationTab("Level 1", "1");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='02012345678'");



    }
}
