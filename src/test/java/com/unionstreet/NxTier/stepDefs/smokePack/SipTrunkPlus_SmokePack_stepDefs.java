package com.unionstreet.NxTier.stepDefs.smokePack;
import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rajeshg on 03/08/2017.
 */
public class SipTrunkPlus_SmokePack_stepDefs {
    WebModel webModel=new WebModel();

    @Given("^I am logged in as a master user$")
    public void iAmLoggedInAsAMasterUser() throws InterruptedException {
        webModel.getLoginPage().loginAsMasterUser();


    }

    @When("^I click on the create user tab and provide I should be able to create a valid reseller account$")
    public void iClickOnTheCreateUserTabAndProvideIShouldBeAbleToCreateAValidResellerAccount() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().clickNewResellerButton();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_General(true,"New reseller");
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Additional();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Personalization();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_BusinessAddress("New reseller","United Kingdom");
    }

    @And("^I should be able to search and find the created account$")
    public void iShouldBeAbleToSearchAndFindTheCreatedAccount() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().SearchAndAssertReseller();
        webModel.getSipTrunkPlus_dashBoardPage().deleteResellerAccount(false);

    }

    @Given("^I am logged in as a master user and have created a reseller$")
    public void iAmLoggedInAsAMasterUserAndHaveCreatedAReseller() throws InterruptedException {
        webModel.getLoginPage().loginAsMasterUser();
        webModel.getSipTrunkPlus_dashBoardPage().clickNewResellerButton();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_General(true,"New reseller");
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Additional();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Personalization();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_BusinessAddress("New reseller","United Kingdom");
    }

    @When("^I click add client and provide all the valid info$")
    public void iClickAddClientAndProvideAllTheValidInfo() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().clickNewClientButton();
        webModel.getSipTrunkPlus_addResellerPage().addClient_ChooseReseller();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_General(false,"New client");
        webModel.getSipTrunkPlus_addResellerPage().addClient_additional("*DEFAULT_RESELLER_PROFILE");
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_BusinessAddress("New client","United Kingdom");

    }

    @Then("^I should be able to create a client for that particular reseller$")
    public void iShouldBeAbleToCreateAClientForThatParticularReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().SearchAndAssertReseller();

    }

    @And("^I should be able to search and delete the newly created clients account$")
    public void iShouldBeAbleToSearchAndDeleteTheNewlyCreatedClientsAccount() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().assertNewlyCreatedClient();

        webModel.getSipTrunkPlus_dashBoardPage().deleteResellerAccount(true);
    }
}
