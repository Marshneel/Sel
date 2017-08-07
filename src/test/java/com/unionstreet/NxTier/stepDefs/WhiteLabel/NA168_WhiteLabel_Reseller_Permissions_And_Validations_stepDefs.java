package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.stepDefs.WLR3.NA45_Reseller_Login_stepDefs;
import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 30/06/2017.
 */
public class NA168_WhiteLabel_Reseller_Permissions_And_Validations_stepDefs {
    WebModel webModel = new WebModel();

    NA45_Reseller_Login_stepDefs na45 = new NA45_Reseller_Login_stepDefs();


    @Given("^CP has added a service charge to one of my sites$")
    public void cpHasAddedAServiceChargeToOneOfMySites() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCommonMethods().search("site called business customer");
        webModel.getCompanyMenuPage().addServiceChargeToCustomerOrSite("site called business customer");
    }

    @When("^I login as a reseller and access that particular charge$")
    public void iLoginAsAResellerAndAccessThatParticularCharge() throws InterruptedException {
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsReseller();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCommonMethods().search("site called business customer");

    }

    @Then("^I should see the charges at reseller's point of view$")
    public void iShouldSeeTheChargesAtResellerSPointOfView() throws InterruptedException {
        webModel.getCompanyMenuPage().assertChargesForResellerAndAgent("site called business customer","Additional Channels T-Reference",true,false);
    }


    @When("^i create a site$")
    public void iCreateASite() throws InterruptedException {
        na45.haveCreatedANewSiteForACompany();
    }

    @Then("^that site should automatically become the non-billing site$")
    public void thatSiteShouldAutomaticallyBecomeTheNonBillingSite() throws InterruptedException {
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer(webModel.getNewBusinessCustomerPage().Reseller_RanName);
        webModel.getUtils().switchToNewWindow();
        webModel.getContactManagerPage().assertSiteIsNonBillingSite("reseller");
    }
}
