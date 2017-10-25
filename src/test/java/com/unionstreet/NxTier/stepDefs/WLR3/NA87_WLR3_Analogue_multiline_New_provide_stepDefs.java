package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by RajeshG on 13/01/2017.
 */
public class NA87_WLR3_Analogue_multiline_New_provide_stepDefs {

    WebModel webModel = new WebModel();


    @And("^add WLR new provide order to the quote$")
    public void addWLRNewProvideOrderToTheQuote() throws InterruptedException, SQLException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order",webModel.getNewBusinessCustomerPage().RanName);

    }

    @When("^I access analogue multiline tab and provide all the required data$")
    public void iAccessAnalogueMultilineTabAndProvideAllTheRequiredData() throws Throwable {
        webModel.getWlr3_new_provide__orderPage().clickAnalogueMultilineTab();
        //add installation address and assert on the orderDetails screen
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderSITE();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        //enter emergency info
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateEmergencyInfoUnderSITE("emergency info");
        //populating site contacts
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        //edit servicesCharges
        webModel.getwlr3_newProvide_anaMultLine_sitePage().editAndAssertServicesChargesUnderSITE("200");
        //go to provision
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate installation info
        webModel.getWlr3_newProvide__provisionPage().validateNumberOfLinesUnderProvisionForMultiline();
        webModel.getWlr3_newProvide__provisionPage().populateLinePlantSummaryUnderPROVISION();
        webModel.getWlr3_newProvide__provisionPage().assertUnavailabilityOfTakeOverWorkingLineForMultiLineNewProvide();
        //go to Engineering
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populating engineering notes
        webModel.getWlr3_newProvide__engineeringPage().populatingEngineeringNotesUnderENGINEERING("engineering notes");
        //go to features
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate network features
        webModel.getWlr3_newProvide__featuresPage().populateNetworkFeaturesUnderFEATURES();
        //go to numbering
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //check line numbering and populate directory info
        webModel.getWlr3_newProvide__numberingPage().PopulateDirectoryInfoUnderNUMBERING("Sinclaire");
        webModel.getWlr3_newProvide__numberingPage().verifyLineNumberingUnderNUMBERING();
        //go to data
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        //populate hazard and warning notes
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazard note", "warning notes");
        //finish off the order
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
    }

    @Then("^I should be able to navigate throught the wizard and complete the order$")
    public void iShouldBeAbleToNavigateThroughtTheWizardAndCompleteTheOrder() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_line_information_page().setSignalType();
        webModel.getEditOrderPage().verifyOrderCompletion();
        //assert that the order is completed by verifying for the presence of green tick
        webModel.getEditOrderPage().verifyOrderCompletion();
    }
}
