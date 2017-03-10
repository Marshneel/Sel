package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 10/03/2017.
 */
public class NA103_WLR3_Advanced_Line_Numbering_Options_ISDN30_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate a new provide ISDN line order and navigate to advanced line numbering options$")
    public void iInitiateANewProvideISDNLineOrderAndNavigateToAdvancedLineNumberingOptions() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().selectLineTypeForNewProvide("ISDN30E");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().multipleClicksOnNextButton();

    }

    @Then("^I should be able to navigate through and perform assertions$")
    public void iShouldBeAbleToNavigateThroughAndPerformAssertions() throws InterruptedException {
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().newDDIRangeHasNoTabUnderDirInfoUnlessMBNclicked();
        webModel.getWlr3_newProvide_anaMultLine_numberingPage().deleteAndAssertAddedDDIRange();
    }
}
