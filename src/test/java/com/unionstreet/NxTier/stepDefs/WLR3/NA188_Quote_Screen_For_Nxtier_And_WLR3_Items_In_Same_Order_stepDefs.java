package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 24/10/2017.
 */
public class NA188_Quote_Screen_For_Nxtier_And_WLR3_Items_In_Same_Order_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I add a service from the quote details page for both Nxtier and WLR(\\d+)$")
    public void iAddAServiceFromTheQuoteDetailsPageForBothNxtierAndWLR(int arg0) throws SQLException, InterruptedException, UnsupportedEncodingException, ClassNotFoundException, AWTException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getNewBusinessCustomerPage().RanName);
        // adding Nxtier item
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
        webModel.getAddServicePage().searchAndSelectService(webModel.getNxTierServicesPage().CUSTOM_SERVICE_ON_ADD_SERVICE_PAGE,true);
        // adding WLR3 item
        webModel.getEditOrderPage().clickAddProductsAndServicesButton();
        webModel.getAddServicePage().searchAndAddService("New Provide Order",webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_new_provide__orderPage().selectLineTypeForNewProvide("ISDN30E");
        //populate SITE with assertions
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate PROVISION with assertions
        webModel.getWlr3_newProvide__provisionPage().populateProvisionPageWithAssertionsForISDN30();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__engineeringPage().assertionsForISDNE30NewProvidengineeringNotes();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate FEATURES with assertions
        webModel.getWlr3_newProvide__featuresPage().populateAndAssertFeaturesPageForISDN30();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate NUMBERING with assertions
        webModel.getWlr3_newProvide__numberingPage().assertNumberingOptionsForISDN30NewProvide("New SNDDI", "Automatically Allocated");
        webModel.getWlr3_newProvide__numberingPage().populateAndAssertSNDDIrangeForISDN30();
        webModel.getWlr3_newProvide__numberingPage().clickMoreDirInfoTab();
        webModel.getWlr3_newProvide__numberingPage().assertPresenceOfSNDDITabInDirInfo();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate DATE with assertions
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
    }

    @Then("^I should be able to see both the items in same order for CP$")
    public void iShouldBeAbleToSeeBothTheItemsInSameOrderForCP() throws SQLException, InterruptedException {
        webModel.getEditOrderPage().verifyOrderCompletionForNxtierAndWlr3ItemsForCP("customService");
    }
    @And("^I should be able to cancel the order$")
    public void iShouldBeAbleToCancelTheOrder() throws SQLException, InterruptedException, AWTException {
        webModel.getNxTierServicesPage().clickCancelNxtierServices("customService");
        webModel.getWlr3_orderDetails_page().clickCancelOrderForWLR3();
    }

    @Then("^I should not be able to see that particular order$")
    public void iShouldNotBeAbleToSeeThatParticularOrder() throws SQLException, InterruptedException {
        webModel.getOrdersManagerPage().assertOrderCancellationForNxtierAndWLR3Services();
    }
}
