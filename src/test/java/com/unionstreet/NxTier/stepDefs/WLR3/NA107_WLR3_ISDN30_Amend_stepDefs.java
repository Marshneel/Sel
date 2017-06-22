package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by RajeshG on 27/03/2017.
 */
public class NA107_WLR3_ISDN30_Amend_stepDefs {

    WebModel webModel=new WebModel();
    NA88_WLR3_Analogue_Premium_Single_Modify_stepDefs na88=new NA88_WLR3_Analogue_Premium_Single_Modify_stepDefs();

    @And("^there is an ISDN(\\d+) new provide order already submitted and in processing stage$")
    public void thereIsAnISDNNewProvideOrderAlreadySubmittedAndInProcessingStage(int arg0) throws InterruptedException, SQLException {
       //creation of business customer, quote and ISDN30 new provide creation and submission
        na88.iCreateANewBusinessCustomerWithAQuote();
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide__orderPage().selectLineTypeForNewProvide("ISDN30E");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(5);
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().clickSiteInfo();
        webModel.getWlr3_siteInformationPage().populateFloorAndRoomForNewProvideIDSN2();
        webModel.getWlr3_siteInformationPage().saveSiteInfoChanges();
        webModel.getEditOrderPage().accessOrder();
        webModel.getEditOrderPage().submitOrder();

    }

    @When("^I initiate an amend on the order$")
    public void iInitiateAnAmendOnTheOrder() throws InterruptedException, SQLException {
        webModel.getEditOrderPage().startAmendWithCustomerDelayReason();
    }

    @Then("^I should be able to assert edit tabs$")
    public void iShouldBeAbleToAssertEditTabs() throws Throwable {
        //start amending the ISDN30 order

        webModel.getWlr3_orderDetails_page().editTabsForISDN30AmendWithCustomerDelayReason();
        webModel.getWlr3_orderDetails_page().cancelAmendOrder();
        webModel.getEditOrderPage().startOrderAmend();
        webModel.getWlr3_orderDetails_page().editTabsForISDN30AmendOrder();
        webModel.getWlr3_orderDetails_page().clickSiteInfo();



    }


}
