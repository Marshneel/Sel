package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by RajeshG on 21/04/2017.
 */
public class NA121_WLR3_Single_Line_BasicAndPremium_New_Provide_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I access analogue basic single line tab and provide all the required data$")
    public void iAccessAnalogueBasicSingleLineTabAndProvideAllTheRequiredData()  {
        webModel.getWlr3_new_provide__orderPage().selectLineTypeTab("Basic Analogue");
    }

    @Then("^I should be able to navigate through the wizard and complete the order for analogue single basic$")
    public void iShouldBeAbleToNavigateThroughtTheWizardAndCompleteTheOrderForAnalogueSingleBasic() throws InterruptedException, SQLException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderSITE();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__provisionPage().terminationTypeForAnalogueBasicLine();
        webModel.getWlr3_newProvide__provisionPage().setProvisionTypeForNonMultiLine();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__engineeringPage().populatingEngineeringNotesUnderENGINEERING("engineering notes");
        webModel.getWlr3_newProvide__engineeringPage().setAdditionalSiteVisitReason();
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(3);
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        webModel.getWlr3_orderDetails_page().assertExcessConstructionCharges("Band 1 - Up to £300");
        webModel.getEditOrderPage().verifyOrderCompletion();



    }

    @When("^I access analogue premium single line tab and provide all the required data$")
    public void iAccessAnaloguePremiumSingleLineTabAndProvideAllTheRequiredData() {
        webModel.getWlr3_new_provide__orderPage().selectLineTypeTab("Premium Analogue");
    }

    @Then("^I should be able to navigate through the wizard and complete the order for analogue single premium$")
    public void iShouldBeAbleToNavigateThroughtTheWizardAndCompleteTheOrderForAnalogueSinglePremium() throws InterruptedException, SQLException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderSITE();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__provisionPage().terminationTypeForPremiumLine();
        webModel.getWlr3_newProvide__provisionPage().setProvisionTypeForNonMultiLine();
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__engineeringPage().populatingEngineeringNotesUnderENGINEERING("engineering notes");
        webModel.getWlr3_newProvide__engineeringPage().setAdditionalSiteVisitReason();
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(3);
        webModel.getWlr3_newProvide__datePage().populateHazardAndWarningNotesUnderDATE("hazardNotes", "warningNotes");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
        webModel.getWlr3_orderDetails_page().assertExcessConstructionCharges("Band 1 - Up to £300");
        webModel.getWlr3_line_information_page().setSignalType();
        webModel.getEditOrderPage().verifyOrderCompletion();
    }
}
