package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rajeshg on 22/09/2016.
 */
public class NA49_OrderServiceAutomation_stepDefs {

    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44 = new NA44_Agent_Login_stepDefs();

    @And("^Have created a quote$")
    public void haveCreatedAQuote() throws InterruptedException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().createQuote();
    }

    @When("^I add a service from the quote details page$")
    public void iAddAServiceFromTheQuoteDetailsPage() {
        webModel.getDashBoardPage().searchQuoteByBcRN();
        webModel.getDashBoardPage().clickOnQuoteID();
        webModel.getDashBoardPage().clickAddProductsAndServicesButton();
    }

    @Then("^the control that is CP only should be visible$")
    public void theControlThatIsCPOnlyShouldBeVisible() throws InterruptedException {
        webModel.getDashBoardPage().assertCPonlyValuePresent();
    }
///////////////////////////////////////////////////////////////////////////////////////////

    @Then("^the control that is CP only should be invisible$")
    public void theControlThatIsCPOnlyShouldBeInvisible() throws InterruptedException {
        webModel.getDashBoardPage().assertCPonlyValueNotPresent();
    }
/////////////////////////////////////////////////////////////////////////////////////////////

    @When("^I access quote details and add a service without selecting the mandatory control$")
    public void iAccessQuoteDetailsAndAddAServiceWithoutSelectingTheMandatoryControl() {
        iAddAServiceFromTheQuoteDetailsPage();
        webModel.getDashBoardPage().searchAndSelectService();
    }

    @Then("^The quote should become invalid$")
    public void theQuoteShouldBecomeInvalid() {
        webModel.getDashBoardPage().assertInvalidQuoteBeforeSubmitting();
        webModel.getDashBoardPage().assertInvalidQuoteAfterSubmitting();
    }

    @And("^When I add the omitted control, the quote should become valid$")
    public void whenIAddTheOmittedControlTheQuoteShouldBecomeValid() {
        webModel.getDashBoardPage().clickService();
        webModel.getDashBoardPage().populateMandatoryField();
        webModel.getDashBoardPage().assertValidQuoteBeforeSubmitting();
        webModel.getDashBoardPage().assertValidQuoteAfterSubmitting();
    }

}
