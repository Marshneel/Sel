package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by RajeshG on 28/02/2017.
 */
public class NA101_WLR3_ISDN30_New_Provide_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a new provide ISDN line order$")
    public void iInitiateANewProvideISDNLineOrder() throws InterruptedException, SQLException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide__orderPage().selectLineTypeForNewProvide("ISDN30E");

    }

    @Then("^I should be able to check the flow$")
    public void iShouldBeAbleToCheckTheFlow() throws InterruptedException, SQLException {
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
        webModel.getEditOrderPage().verifyOrderCompletion();
        //assertions on order summary page
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertISDNNewProvideSummaryPage("8", "100");


    }
}
