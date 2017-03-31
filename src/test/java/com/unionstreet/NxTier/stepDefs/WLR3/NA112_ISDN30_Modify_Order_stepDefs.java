package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 28/03/2017.
 */

public class NA112_ISDN30_Modify_Order_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a modify order on an ISDN(\\d+) line$")
    public void iInitiateAModifyOrderOnAnISDNLine(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        //own the ISDN30 line
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns='490871001' where serviceid='OI3000000001'");
        webModel.getAddServicePage().searchAndAddService("Modify Order");
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrderWithWrongCLI();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("01202300945", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();




    }

    @Then("^I should be able to check the flow of the ISDN(\\d+) modify$")
    public void iShouldBeAbleToCheckTheFlowOfTheISDNModify(int arg0) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {


        //check the post code text (existing postCode for Modify order)
        webModel.getWlr3_orderDetails_page().postCodeTextForModifyOrder();
        //assert that the site info do not have main power with in 3 meters and events& exhibitions
       webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();
        webModel.getWlr3_siteInformationPage().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().assertionForISDN30ModifyEngineeringNotes();
        //assert that site info do not have provision info
        webModel.getWlr3_siteInformationPage().assertProvisionTypeAbsentInISDN30Modify();
        //assert standby power and radioDeliveryOK buttons are present under lineInfo
        webModel.getWlr3_line_information_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertLineInfoForISDN30();
        webModel.getWlr3_summary_charges_page().editChargesForISDN30Modify();
        webModel.getWlr3_orderDetails_page().assertEditedChargesForISDN30Modify();
        webModel.getWlr3_orderDetails_page().clickLineNumbering();
        webModel.getWlr3_lineNumberingPage().addingNewSNDDIBeyondTheRangeForISDN30Modify();
        webModel.getWlr3_lineNumberingPage().deleteActionAndAddingNewSNDDIForISDN30Modify();
        webModel.getWlr3_lineNumberingPage().revertingDeleteActionOnLineNumberingPopUpForISDN30Modify();
        webModel.getWlr3_lineNumberingPage().mBNValidationOnLineNumberingPopUpForISDN30Modify("01202300923","01202300924","01202300930","To be allocated");
//disown the ISDN 30 line
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set OwningDuns=NULL where serviceid='OI3000000001'");
    }
}
