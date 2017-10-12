package com.unionstreet.SipTrunkPlus.stepDefs;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by rajeshg on 06/09/2017.
 */
public class NA188_SipTrunkPlus_Providers_stepDefs {
    WebModel webModel=new WebModel();
    @When("^I create a provider from the providers page under settings$")
    public void iCreateAProviderFromTheProvidersPageUnderSettings() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().loadSettings();
        webModel.getSipTrunkPlus_providerPage().clickProvidersOnSettingDropDown();
        webModel.getSipTrunkPlus_providerPage().loadAddProviderPage();

    }

    @Then("^I should be able to assign and add them to the resellers$")
    public void iShouldBeAbleToAssignAndAddThemToTheResellers() throws InterruptedException {
        webModel.getSipTrunkPlus_providerPage().populateNewProviderPage("1","2","3");
       webModel.getSipTrunkPlus_dashBoardPage().clickSlider();
        webModel.getSipTrunkPlus_dashBoardPage().clickNewResellerButton();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_General(true,"New reseller");
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Additional(true);
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_Personalization();
        webModel.getSipTrunkPlus_addResellerPage().addNewResellerPage_BusinessAddress("New reseller","United Kingdom");
        webModel.getSipTrunkPlus_dashBoardPage().assignProviderToResellerAndPopulateMandatoryFields(webModel.getSipTrunkPlus_providerPage().providerName);


    }
    @And("^I should not be able to delete the provider unless I delete the same from the reseller$")
    public void iShouldNotBeAbleToDeleteTheProviderUnlessIDeleteTheSameFromTheReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().loadRoot();
        webModel.getSipTrunkPlus_dashBoardPage().loadSettings();
        webModel.getSipTrunkPlus_providerPage().clickProvidersOnSettingDropDown();
        webModel.getSipTrunkPlus_dashBoardPage().deletingProviderFromResellerConfiguration(webModel.getSipTrunkPlus_providerPage().providerName);
        webModel.getSipTrunkPlus_dashBoardPage().popMessageDenyingProviderDeletion();
        webModel.getSipTrunkPlus_dashBoardPage().searchAndLoadReseller("New reseller"+webModel.getSipTrunkPlus_addResellerPage().ranResellerName);
        webModel.getSipTrunkPlus_dashBoardPage().loadOptions();
        webModel.getSipTrunkPlus_dashBoardPage().loadProvidersFromResellerDashBoard();
        webModel.getSipTrunkPlus_dashBoardPage().deletingProviderFromResellerConfiguration(webModel.getSipTrunkPlus_providerPage().providerName);
        webModel.getSipTrunkPlus_dashBoardPage().successfulDeletion();
        webModel.getSipTrunkPlus_dashBoardPage().loadRoot();
        webModel.getSipTrunkPlus_dashBoardPage().clickOnReseller("New reseller"+webModel.getSipTrunkPlus_addResellerPage().ranResellerName);
        webModel.getSipTrunkPlus_dashBoardPage().deleteAccount();
    }


    @Given("^I am logged in as a master user and a reseller with provider added have already been created$")
    public void iAmLoggedInAsAMasterUserAndAResellerWithProviderAddedHaveAlreadyBeenCreated() throws InterruptedException {
        webModel.getSipTrunkPlus_loginPage().loginAsMasterUser();
    }

    @When("^I navigate to the additional page under the created reseller$")
    public void iNavigateToTheAdditionalPageUnderTheCreatedReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().clickSlider();
        webModel.getSipTrunkPlus_dashBoardPage().searchAndLoadReseller("ResellerForAutoTest");
        webModel.getSipTrunkPlus_dashBoardPage().loadOptions();
        webModel.getSipTrunkPlus_dashBoardPage().loadAdditional();


    }

    @Then("^I should be not be able to un assign the assigned provider$")
    public void iShouldBeNotBeAbleToUnAssignTheAssignedProvider() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().assign_unAssignProvider("ProviderForAutoTest",true,false);
        webModel.getSipTrunkPlus_dashBoardPage().assertUsedProvidersCannotBeAssigned("ProviderForAutoTest");
        webModel.getSipTrunkPlus_dashBoardPage().yesOrOk("OK");
    }

    @And("^When I delete the provider from the specific reseller then I should be able to un assign the reseller$")
    public void whenIDeleteTheProviderFromTheSpecificResellerThenIShouldBeAbleToUnAssignTheReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().loadOptions();
        webModel.getSipTrunkPlus_dashBoardPage().loadProvidersFromResellerDashBoard();
        webModel.getSipTrunkPlus_dashBoardPage().deletingProviderFromResellerConfiguration("ProviderForAutoTest");
        webModel.getSipTrunkPlus_dashBoardPage().successfulDeletion();
        webModel.getSipTrunkPlus_dashBoardPage().loadOptions();
        webModel.getSipTrunkPlus_dashBoardPage().loadAdditional();
        webModel.getSipTrunkPlus_dashBoardPage().assign_unAssignProvider("ProviderForAutoTest",true,false);
        webModel.getSipTrunkPlus_dashBoardPage().saveChanges();
        webModel.getSipTrunkPlus_dashBoardPage().assign_unAssignProvider("ProviderForAutoTest",false,true);
        webModel.getSipTrunkPlus_dashBoardPage().saveChanges();
        webModel.getSipTrunkPlus_dashBoardPage().assignProviderToResellerAndPopulateMandatoryFields("ProviderForAutoTest");
    }

    @When("^I try to delete the reseller$")
    public void iTryToDeleteTheReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().clickSlider();
        webModel.getSipTrunkPlus_dashBoardPage().searchAndLoadReseller("ResellerForAutoTest");
        webModel.getSipTrunkPlus_dashBoardPage().deleteAccount();

    }

    @Then("^a validation message should be shown and the reseller should not be deleted$")
    public void aValidationMessageShouldBeShownAndTheResellerShouldNotBeDeleted()  {
        webModel.getSipTrunkPlus_dashBoardPage().assertResellerCannotBeDeleted("ResellerForAutoTest");

    }

    @When("^I navigate to the provider under reseller$")
    public void iNavigateToTheProviderUnderReseller() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().clickSlider();
        webModel.getSipTrunkPlus_dashBoardPage().searchAndLoadReseller("ResellerForAutoTest");
        webModel.getSipTrunkPlus_dashBoardPage().loadOptions();
        webModel.getSipTrunkPlus_dashBoardPage().loadProvidersFromResellerDashBoard();
        webModel.getSipTrunkPlus_dashBoardPage().loadEditProviderScreen("ProviderForAutoTest");
        webModel.getSipTrunkPlus_dashBoardPage(). populateResellerSideProviderCredentials();
        webModel.getSipTrunkPlus_dashBoardPage().loadEditProviderScreen("ProviderForAutoTest");
    }
}
