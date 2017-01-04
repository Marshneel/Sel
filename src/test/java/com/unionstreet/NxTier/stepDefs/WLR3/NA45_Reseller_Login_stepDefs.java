package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rajeshg on 22/09/2016.
 */
public class NA45_Reseller_Login_stepDefs {

    WebModel webModel = new WebModel();


    @And("^have created a new site for a company$")
    public void haveCreatedANewSiteForACompany() throws InterruptedException {
        webModel.getNewBusinessCustomerPage().clickContactManagerButton();
        webModel.getNewBusinessCustomerPage().clickAddNewCustomerButton();
        webModel.getNewBusinessCustomerPage().addCompanyInfoForNewBusinessCustomerCreatedWithDefaultContactTypes();
        webModel.getNewBusinessCustomerPage().addSiteInfoForNewBusinessCustomer();
        webModel.getNewBusinessCustomerPage().addSiteContactInfoForNewBusinessCustomer();
        webModel.getContactManagerPage().clickOnResellerUnderCustomerDetails();
        webModel.getContactManagerPage().clickCompanySite();
        webModel.getContactManagerPage().addNewSiteForReseller();
    }

    @When("^I access create Quote tab and select the above company from the company dropdown$")
    public void iAccessCreateQuoteTabAndSelectTheAboveCompanyFromTheCompanyDropdown() {
        webModel.getContactManagerPage().navigateToHomePage();
        webModel.getDashBoardPage().clickOrderManagerButton();
    }

    @Then("^The newly created site should appear under the site drop down$")
    public void theNewlyCreatedSiteShouldAppearUnderTheSiteDropDown() throws InterruptedException {
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
        webModel.getContactManagerPage().assertNewlyCreatedSiteByResellerOnQuotePage();

    }
}