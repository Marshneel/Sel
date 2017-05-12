package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 12/05/2017.
 */
public class NA131_WLR3_VirtualLines_Change_Of_Line_Type_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a change of line from Virtual line-Remote call forwarding to Virtual line-caller redirect$")
    public void iInitiateAChangeOfLineFromVirtualLineRemoteCallForwardingToVirtualLineCallerRedirect() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='ORCF00000002'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300912","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().confirmChangeOfOwnerShip();
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("ISDN Remote Call Forward (Current)","ISDN Caller Redirect");
    }

    @Then("^I should be able to check the flow and change remote call forwarding to caller redirect$")
    public void iShouldBeAbleToCheckTheFlowAndChangeRemoteCallForwardingToCallerRedirect() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Caller Redirect");
        webModel.getWlr3_orderDetails_page().assertCLIrequiredAlertMessageForVirtualLines("Caller Redirect");
        webModel.getWlr3_orderDetails_page().clickOnTheCLIAlertMessage();
        webModel.getWlr3_networkCallingFeaturesPage().editCallFeaturesForCallerRedirect_VirtualLines("0201234567");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().checkServiceMaintenanceForVirtualLines();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='ORCF00000002'");
    }

    @When("^I initiate a change of line from Virtual line-caller redirect to Virtual line-Remote call forwarding$")
    public void iInitiateAChangeOfLineFromVirtualLineCallerRedirectToVirtualLineRemoteCallForwarding() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OCR00000002'");
        webModel.getAddServicePage().searchAndAddService("Change Line Type Order");
        webModel.getWlr3_changeOfLineTypeOrderPage().addCLIsToTheOrder("01202300911","LU1 1DQ");
        webModel.getWlr3_changeOfLineTypeOrderPage().confirmChangeOfOwnerShip();
        webModel.getWlr3_changeOfLineTypeOrderPage().chooseLineType("ISDN Caller Redirect (Current)","ISDN Remote Call Forward");

    }

    @Then("^I should be able to check the flow and change from caller redirect to remote call forwarding$")
    public void iShouldBeAbleToCheckTheFlowAndChangeFromCallerRedirectToRemoteCallForwarding() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().assertCLIrequiredAlertMessageForVirtualLines("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().clickOnTheCLIAlertMessage();
        webModel.getWlr3_networkCallingFeaturesPage().editCallFeaturesForRemoteCallFor_VirtualLines("0201234567");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("0201234567");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().checkServiceMaintenanceForVirtualLines();
        webModel.getEditOrderPage().verifyOrderCompletion();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OCR00000002'");

    }
}
