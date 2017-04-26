package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * Created by rajeshg on 17/10/2016.
 */
public class NA60_WLR3_Analogue_Transfer_Address_Lookup_stepDefs {

    WebModel webModel = new WebModel();
    NA44_Agent_Login_stepDefs na44_agent_login_stepDefs = new NA44_Agent_Login_stepDefs();

    @And("^I create a new business customer and quote$")
    public void iCreateANewBusinessCustomerAndQuote() throws InterruptedException {
        na44_agent_login_stepDefs.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getOrdersManagerPage().createQuote();
        webModel.getOrdersManagerPage().searchQuoteByBcRN();
        webModel.getOrdersManagerPage().clickOnQuoteID();
    }

    @And("^I assign WLR transfer order service to the newly created quote$")
    public void iAssignWLRTransferOrderServiceToTheNewlyCreatedQuote() throws InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Transfer Order");
        webModel.getWlr3_orderDetails_page().enterPhoneNumberAndPostCodeToInitiateTheTransfer("01202300908", "lu1 1dq");
    }

    @When("^I access postcode search under installation address tab and enter incorrect post code$")
    public void iAccessPostcodeSearchUnderInstallationAddressTabAndEnterIncorrectPostCode() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().accessInstallationAddressPage();
        webModel.getWlr3_installationAddressPage().EnterPostCodeInSearchAddressByPostCode("GU22 9DY");
        webModel.getWlr3_installationAddressPage().EnterPostCodeInSearchAddressByPostCode("lu11dq");
    }

    @Then("^Error should be thrown for incorrect postCode$")
    public void errorShouldBeThrownForIncorrectPostCode() {
        webModel.getWlr3_installationAddressPage().assertErrorMessageUponEnteringWrongPostCode();
        webModel.getWlr3_installationAddressPage().assertErrorMessageUponEnteringInvalidPostCode();
    }

    @And("^When i enter valid post code$")
    public void WhenIEnterValidPostCode() throws Throwable {
        webModel.getWlr3_installationAddressPage().EnterPostCodeInSearchAddressByPostCode("lu1 1dq");
    }

    @Then("^I should be able to search and select the address by post code$")
    public void iShouldBeAbleToSearchAndSelectTheAddressByPostCode() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        webModel.getWlr3_orderDetails_page().pickAndAssertPostCodeOnWLR3OrderPage("LU1 1DQ");
        System.out.println("NA60a completed");
    }

    @When("^Access addressKey search under installation address tab and enter invalid address key$")
    public void accessAddressKeySearchUnderInstallationAddressTabAndEnterInvalidAddressKey() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().accessInstallationAddressPage();
        webModel.getWlr3_installationAddressPage().accessAddressKeyTab();
        webModel.getWlr3_installationAddressPage().enterAddressKeyInSearchAddressByAddressKey("00001043137");
    }

    @Then("^Error should be thrown for invalid address key$")
    public void errorShouldBeThrownForInvalidAddressKey() {
        webModel.getWlr3_orderDetails_page().assertErrorMessageUponEnteringInvalidAddressKey();
    }

    @And("^When i enter valid address key$")
    public void whenIEnterValidAddrressKey() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().enterAddressKeyInSearchAddressByAddressKey("A00001043137");
    }

    @Then("^I should be able to search and select the address by address key$")
    public void iShouldBeAbleToSearchAndSelectTheAddressByAddressKey() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        webModel.getWlr3_orderDetails_page().pickAndAssertPostCodeOnWLR3OrderPage("LU1 1DQ");
        System.out.println("NA60b completed");
    }

    @When("^I access advanced search under installation address tab and enter valid combinations$")
    public void iAccessAdvancedSearchUnderInstallationAddressTabAndEnterValidCombinations() throws InterruptedException {
        webModel.getWlr3_installationAddressPage().accessInstallationAddressPage();
        webModel.getWlr3_installationAddressPage().accessAdvancedSearchTab();
        webModel.getWlr3_installationAddressPage().enterValidAddressSearchCombinations();
    }

    @Then("^I should be able to search and select the address$")
    public void iShouldBeAbleToSearchAndSelectTheAddress() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
        webModel.getUtils().checkPoint("NA60c completed");

    }
}
