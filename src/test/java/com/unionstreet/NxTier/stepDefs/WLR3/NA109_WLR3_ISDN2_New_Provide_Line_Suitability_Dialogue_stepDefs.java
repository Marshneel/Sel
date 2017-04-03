package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 27/03/2017.
 */
public class NA109_WLR3_ISDN2_New_Provide_Line_Suitability_Dialogue_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate any of the ISDN(\\d+) new provide without addressKey$")
    public void iInitiateAnyOfTheISDNNewProvideWithoutAddressKey(int arg0) throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().selectLineTypeForNewProvide("ISDN2 Standard");
    }

    @Then("^An error message requesting the address match is highlighted$")
    public void anErrorMessageRequestingTheAddressMatchIsHighlighted()  {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().assertAddressMatchErrorMessage();

    }

    @And("^When I assign an address key under siteDetails of that customer, and initiate the ISDN(\\d+) new provide order$")
    public void whenIAssignAnAddressKeyUnderSiteDetailsOfThatCustomerAndInitiateTheISDNNewProvideOrder(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getAddSiteDetailsPage().assignAddressKeyToSite();
        webModel.getUtils().getOrdersPage();
        webModel.getOrdersManagerPage().searchQuoteByBcRN();
        webModel.getOrdersManagerPage().clickOnQuoteID();
        webModel.getAddServicePage().searchAndAddService("New Provide Order");
        webModel.getWlr3_new_provide_analogue_multiline_orderPage().selectLineTypeForNewProvide("ISDN2 Standard");
    }

    @Then("^The line suitability dialogue should be highlighted$")
    public void theLineSuitabilityDialogueShouldBeHighlighted() {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().assertLineSuitabilityMessage();
    }

    @And("^perform an address search and choose the address under installation address$")
    public void performAnAddressSearchAndChooseTheAddressUnderInstallationAddress() throws InterruptedException {
       webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ");
    }
}
