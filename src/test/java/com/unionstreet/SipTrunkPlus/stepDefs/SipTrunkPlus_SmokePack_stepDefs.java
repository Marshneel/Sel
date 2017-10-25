package com.unionstreet.SipTrunkPlus.stepDefs;
import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;

/**
 * Created by rajeshg on 03/08/2017.
 */
public class SipTrunkPlus_SmokePack_stepDefs {
    WebModel webModel=new WebModel();

    @Given("^I am logged in as a master user$")
    public void iAmLoggedInAsAMasterUser() throws InterruptedException {
        webModel.getSipTrunkPlus_loginPage().loginAsMasterUser();


    }

    @When("^I click on the create user tab and provide I should be able to create a valid reseller account$")
    public void iClickOnTheCreateUserTabAndProvideIShouldBeAbleToCreateAValidResellerAccount() throws InterruptedException {
       webModel.getSipTrunkPlus_dashBoardPage().clickSlider();
        webModel.getSipTrunkPlus_dashBoardPage().clickNewResellerButton();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_General(true,"New reseller");
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Additional(false);
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Personalization();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_BusinessAddress("New reseller","United Kingdom");
    }

    @And("^I should be able to search and find the created account$")
    public void iShouldBeAbleToSearchAndFindTheCreatedAccount() throws InterruptedException, AWTException {
     webModel.getSipTrunkPlus_dashBoardPage().assertCreatedReseller();
        webModel.getSipTrunkPlus_dashBoardPage().loadRoot();
        webModel.getSipTrunkPlus_dashBoardPage().searchAndLoadReseller("New reseller"+webModel.getSipTrunkPlus_addResellerPage().ranResellerName);
        webModel.getSipTrunkPlus_dashBoardPage().deleteResellerAccount(false);

    }

    @Given("^I am logged in as a master user and have created a reseller$")
    public void iAmLoggedInAsAMasterUserAndHaveCreatedAReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_loginPage().loginAsMasterUser();
        webModel.getSipTrunkPlus_dashBoardPage().clickSlider();
        webModel.getSipTrunkPlus_dashBoardPage().clickNewResellerButton();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_General(true,"New reseller");
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Additional(false);
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
        webModel.getSipTrunkPlus_dashBoardPage().loadRoot();
        webModel.getSipTrunkPlus_dashBoardPage().searchAndLoadReseller("New reseller"+webModel.getSipTrunkPlus_addResellerPage().ranResellerName);

    }

    @And("^I should be able to search and delete the newly created clients account$")
    public void iShouldBeAbleToSearchAndDeleteTheNewlyCreatedClientsAccount() throws InterruptedException, AWTException {
        webModel.getSipTrunkPlus_dashBoardPage().assertNewlyCreatedClient();
        webModel.getSipTrunkPlus_dashBoardPage().deleteResellerAccount(true);
    }
}
