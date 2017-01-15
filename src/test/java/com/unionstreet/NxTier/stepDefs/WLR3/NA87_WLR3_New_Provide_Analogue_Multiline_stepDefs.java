package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class NA87_WLR3_New_Provide_Analogue_Multiline_stepDefs {

    WebModel webModel=new WebModel();




    @And("^add WLR analogue multiline order to the quote$")
    public void addWLRAnalogueMultilineOrderToTheQuote() throws InterruptedException {
    webModel.getAddServicePage().searchAndAddService("New Provide Order");

    }

    @When("^I access analogue multiline tab and provide all the required data$")
    public void iAccessAnalogueMultilineTabAndProvideAllTheRequiredData() throws Throwable {
    webModel.getWlr3_new_provide_analogue_multiline_orderPage().clickAnalogueMultilineTab();
        //add installation address and assert on the orderDetails screen
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().populateAndAssertInstallationAddressUnderSite("LU1 1DQ");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26");
        //enter emergency info
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().populateEmergencyInfo("emergency info");
        //populating site contacts
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().populateSiteContact("07894040256");
        //edit servicesCharges
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().editAndAssertServicesCharges("200");
        //go to provision
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate installation info
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().populateLinePlantSummary();
        //go to Engineering
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populating engineering notes
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().populatingEngineeringNotes("engieering notes");
        //go to features
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //populate network features
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().populateNetworkFeatures();
        //go to next
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().navigateToNextScreen();
        //check line numbering and populate directory info
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().checkLineNumberingTabAndPopulateDirectoryInfo("Directory info");


    }

    @Then("^I should be able to navigate throught the wizard and perform assertions$")
    public void iShouldBeAbleToNavigateThroughtTheWizardAndPerformAssertions() throws Throwable {

    }
}
