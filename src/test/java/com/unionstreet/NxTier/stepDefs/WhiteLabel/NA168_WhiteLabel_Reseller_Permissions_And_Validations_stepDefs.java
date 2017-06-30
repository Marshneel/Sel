package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.stepDefs.WLR3.NA45_Reseller_Login_stepDefs;
import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 30/06/2017.
 */
public class NA168_WhiteLabel_Reseller_Permissions_And_Validations_stepDefs {
    WebModel webModel=new WebModel();

    NA45_Reseller_Login_stepDefs na45=new NA45_Reseller_Login_stepDefs();

    @When("^I create a site$")
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
        webModel.getContactManagerPage().assertSiteIsNonBillingSite();
    }






    @When("^I navigate to relevant pages and I should be able to perform the required assertions$")
    public void iNavigateToRelevantPagesAndIShouldBeAbleToPerformTheRequiredAssertions() throws InterruptedException {


        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsReseller();
    }


}
