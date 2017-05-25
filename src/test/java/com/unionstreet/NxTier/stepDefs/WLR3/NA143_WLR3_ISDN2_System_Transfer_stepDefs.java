package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 25/05/2017.
 */
public class NA143_WLR3_ISDN2_System_Transfer_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I initiate a transfer service on ISDN(\\d+) system line$")
    public void iInitiateATransferServiceOnISDNSystemLine(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI2E00000003'");
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300920", "lu1 1dq");
    }

    @Then("^I should be able to check the flow for the ISDN(\\d+) system transfer order$")
    public void iShouldBeAbleToCheckTheFlowForTheISDNSystemTransferOrder(int arg0) throws SQLException, InterruptedException {
        webModel.getWlr3_orderDetails_page().verifyLineTypeAndProvisionType("ISDN2 System","Transfer");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertDisabledFieldsForISDN2linesInTransfer();
        webModel.getWlr3_line_information_page().setConfigurationForISDN2SystemInTransfer();
        webModel.getWlr3_orderDetails_page().loadDirectoryInfo();
        webModel.getWlr3_directoryInformationPage().changeDirectoryType("No Directory Entry Required");
        webModel.getWlr3_directoryInformationPage().saveAndCloseDirectoryInfo();
        webModel.getWlr3_orderDetails_page().assertChangedDirectoryType("Main");





    }
}
