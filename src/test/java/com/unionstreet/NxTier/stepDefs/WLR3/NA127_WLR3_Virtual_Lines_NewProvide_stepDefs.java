package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 08/05/2017.
 */
public class NA127_WLR3_Virtual_Lines_NewProvide_stepDefs {
    WebModel webModel = new WebModel();

    @When("^I initiate a virtual line order for ISDN Remote Call Forward$")
    public void iInitiateAVirtualLineOrderForISDNRemoteCallForward() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Remote Call Forward");
    }

    @Then("^I should be able to check the flow and complete the virtual line order for ISDN remote call forward$")
    public void iShouldBeAbleToCheckTheFlowAndCompleteTheVirtualLineOrderForISDNRemoteCallForward() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderSITE();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ", "A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26", "A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__numberingPage().lineNumberingAlertMessageForVirtualLines();
        webModel.getWlr3_newProvide__numberingPage().disabledNext();
        webModel.getWlr3_newProvide__numberingPage().loadAdvancedLineNumbering();
        webModel.getWlr3_lineNumberingPage().lineNumberingAutomaticallyAssignNumber("01582213000");
        webModel.getWlr3_lineNumberingPage().assertionForNumberAllocationOnWizard("01582213000");
        webModel.getWlr3_newProvide__numberingPage().loadAdvancedLineNumbering();
        webModel.getWlr3_lineNumberingPage().lineNumberingSelectFromList("01582213000");
        webModel.getWlr3_lineNumberingPage().assertionForNumberAllocationOnWizard("01582213000");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_networkCallingFeaturesPage().assertFeaturesForRemoteCallFor_VirtualLines();
        webModel.getWlr3_new_provide__orderPage().saveAndSwitchToOrderSummaryPage();
        webModel.getWlr3_orderDetails_page().clickOnQuoteID();
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Raw Call Data");
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().assertCLIrequiredAlertMessageForVirtualLines("Remote Call Forwarding");
        webModel.getWlr3_orderDetails_page().clickOnTheCLIAlertMessage();
        webModel.getWlr3_networkCallingFeaturesPage().editCallFeaturesForRemoteCallFor_VirtualLines("0201234567");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("0201234567");
        webModel.getWlr3_orderDetails_page().assertRemovedFeature("Raw Call Data");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().checkServiceMaintenanceForVirtualLines();


    }

    @When("^I initiate a virtual line order for ISDN Caller Redirect$")
    public void iInitiateAVirtualLineOrderForISDNCallerRedirect() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Caller Redirect");
    }

    @Then("^I should be able to check the flow and complete the virtual line order for ISDN Caller Redirect$")
    public void iShouldBeAbleToCheckTheFlowAndCompleteTheVirtualLineOrderForISDNCallerRedirect() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderSITE();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ", "A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26", "A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_newProvide__numberingPage().lineNumberingAlertMessageForVirtualLines();
        webModel.getWlr3_newProvide__numberingPage().disabledNext();
        webModel.getWlr3_newProvide__numberingPage().loadAdvancedLineNumbering();
        webModel.getWlr3_lineNumberingPage().lineNumberingSpecifyNewNumber("01582213000");
        webModel.getWlr3_lineNumberingPage().assertionForNumberAllocationOnWizard("01582213000");
        webModel.getWlr3_new_provide__orderPage().navigateToNextScreen();
        webModel.getWlr3_networkCallingFeaturesPage().assertFeaturesForCallerRedirect();
        webModel.getWlr3_new_provide__orderPage().saveAndSwitchToOrderSummaryPage();
        webModel.getWlr3_orderDetails_page().clickOnQuoteID();
        webModel.getWlr3_orderDetails_page().assertCommonFeatures("Quarterly Caller Redirect");
        webModel.getWlr3_orderDetails_page().assertExclusiveFeatures("0201234567");
        webModel.getWlr3_orderDetails_page().loadNetworkFeatures();
        webModel.getWlr3_networkCallingFeaturesPage().editCallFeaturesForCallerRedirect_VirtualLines("");
        webModel.getWlr3_orderDetails_page().assertCLIrequiredAlertMessageForVirtualLines("Caller Redirect");
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().checkServiceMaintenanceForVirtualLines();



    }
}