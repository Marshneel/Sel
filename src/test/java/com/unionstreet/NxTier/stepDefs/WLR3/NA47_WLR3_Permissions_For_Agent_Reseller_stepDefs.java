package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by rajeshg on 22/09/2016.
 */
public class NA47_WLR3_Permissions_For_Agent_Reseller_stepDefs {

    WebModel webModel = new WebModel();

    @Given("^CP has revoked my WLR order permissions$")
    public void cpHasRevokedMyWLROrderPermissions() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().revokingAgentWLRPermissions();
        webModel.getDashBoardPage().logOut();
    }

    @Then("^I should not be able to see and edit them$")
    public void iShouldNotBeAbleToSeeAndEditThem() throws InterruptedException {
        //login as agent///////
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getSettingsPage().assertingWLROrdersWithOutRights();
        webModel.getDashBoardPage().logOut();
    }

    @And("^the orders are visible and editable once the CP issues the orders back agent rights$")
    public void theOrdersAreVisibleAndEditableOnceTheCPIssuesTheOrdersBack() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().issuingWLRPermissions();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getSettingsPage().assertingWLROrdersWithRights();
    }
/////////////////////two//////////////////////////////////

    @And("^the orders are visible and editable once the CP issues the orders back reseller rights$")
    public void theOrdersAreVisibleAndEditableOnceTheCPIssuesTheOrdersBackResellerRights() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().issuingWLRPermissions();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsReseller();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getSettingsPage().assertingWLROrdersWithRights();
    }
}
