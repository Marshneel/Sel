package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class NA87_WLR3_New_Provide_Analogue_Multiline_stepDefs {

    WebModel webModel = new WebModel();


    @And("^add WLR analogue multiline order to the quote$")
    public void addWLRAnalogueMultilineOrderToTheQuote() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");

    }

    @When("^I access analogue multiline tab and provide all the required data$")
    public void iAccessAnalogueMultilineTabAndProvideAllTheRequiredData() throws Throwable {
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().clickAnalogueMultilineTab();
        //add installation address and assert on the orderDetails screen
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26");
        //enter emergency info
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateEmergencyInfoUnderSITE("emergency info");
        //populating site contacts
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        //edit servicesCharges
        webModel.getwlr3_newProvide_anaMultLine_sitePage().editAndAssertServicesChargesUnderSITE("200");
        //go to provision
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate installation info
        webModel.getWlr3_newProvide_anaMultLine_provisionPage().populateLinePlantSummaryUnderPROVISION();
        //go to Engineering
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populating engineering notes
        webModel.getWlr3_newProvide_anaMultLine_engineeringPage().populatingEngineeringNotesUnderENGINEERING("engineering notes");
        //go to features
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate network features
        webModel.getWlr3_newProvide_anaMultLine_featuresPage().populateNetworkFeaturesUnderFEATURES();
        //go to numbering
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //check line numbering and populate directory info
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().PopulateDirectoryInfoUnderNUMBERING("Sinclaire");
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().verifyLineNumberingUnderNUMBERING();
        //go to data
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate hazard and warning notes
        webModel.getWlr3_newProvide_anaMultLine_datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        //finish off the order
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();


    }

    @Then("^I should be able to navigate throught the wizard and complete the order$")
    public void iShouldBeAbleToNavigateThroughtTheWizardAndCompleteTheOrder() throws InterruptedException {
        //assert that the order is completed by verifying for the presence of green tick
        webModel.getEditOrderPage().verifyOrderCompletion();

    }


}
