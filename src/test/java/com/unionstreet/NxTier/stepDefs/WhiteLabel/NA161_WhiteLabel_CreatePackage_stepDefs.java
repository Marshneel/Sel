package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 23/06/2017.
 */
public class NA161_WhiteLabel_CreatePackage_stepDefs {
   WebModel webModel=new WebModel();
    NA152_WhiteLabel_Agent_Permissions_stepDefs na152=new NA152_WhiteLabel_Agent_Permissions_stepDefs();

    @Given("^I have been assigned tariffs and free minutes by the CP$")
    public void iHaveBeenAssignedTariffsAndFreeMinutesByTheCP() throws AWTException, InterruptedException {
        na152.cpHasIssuedFewTariffAndFreeMinutePlans();

    }

    @And("^I navigate to the package manager$")
    public void iNavigateToThePackageManager() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().addTariffPlan();
        webModel.getConfigManagerPage().addFreeMinutesPlan();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().clickAdd();



    }

    @Then("^I should be able to create business and consumer packages$")
    public void iShouldBeAbleToCreateBusinessAndConsumerPackages() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getConfigManagerPage().createPackage("1",webModel.getCreateTariffPage().RanTariffPlanName,true,true);
        webModel.getConfigManagerPage().saveAndAssertThePackage("[@disabled='True']");
        webModel.getConfigManagerPage().clickAdd();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update tariffnames set Consumer='1' where TariffName='Sell 2p NGCS AC (+60 sec)'");
        webModel.getConfigManagerPage().createPackage("2","Sell 2p NGCS AC (+60 sec)",false,false);
        webModel.getConfigManagerPage().saveAndAssertThePackage("[@checked='checked']");
      //  webModel.getConfigManagerPage().clickAdd();
     //   webModel.getUtils().assertElementNotPresent(By.xpath("//option[contains(text(),'Sell 2p NGCS AC (+60 sec)')]"));
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update tariffnames set Consumer='0' where TariffName='Sell 2p NGCS AC (+60 sec)'");

    }


    @When("^I assign a package to agent$")
    public void iAssignAPackageToAgent() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().assignPackageToAgent("Winter Special Promotion","checkbox1");

    }

    @Then("^He should not be able to edit it$")
    public void heShouldNotBeAbleToEditIt() throws InterruptedException {
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().assertCPAssignedPackagesAreNotEditable("Winter Special Promotion");
    }


    @When("^I create a package$")
    public void iCreateAPackage() throws InterruptedException, UnsupportedEncodingException, ClassNotFoundException {
        iNavigateToThePackageManager();
        webModel.getConfigManagerPage().createPackage("1",webModel.getCreateTariffPage().RanTariffPlanName,true,false);
        webModel.getConfigManagerPage().saveAndAssertThePackage("[@disabled='True']");
    }

    @Then("^I should be able to edit it$")
    public void iShouldBeAbleToEditIt() throws InterruptedException {
        webModel.getConfigManagerPage().editCreatedPackage();


    }

    @When("^I Add a package to a business customer$")
    public void iAddAPackageToABusinessCustomer() throws InterruptedException {
        iAssignAPackageToAgent();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getDashBoardPage().load_endCustomers();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickPricingDetails();
      webModel.getCompanyMenuPage().assignOrDeletePackageToCustomer("Gamma Mobile Contract Package 1");
        webModel.getDashBoardPage().logOut();

    }

    @Then("^The agent will be able to see and delete the package only but cannot re- assign it unless he has permissions$")
    public void theAgentWillBeAbleToSeeAndDeleteThePackageOnlyButCannotReAssignItUnlessHeHasPermissions() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getDashBoardPage().load_endCustomers();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickPricingDetails();
        webModel.getCompanyMenuPage().assignOrDeletePackageToCustomer("Select");
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickPricingDetails();
        webModel.getCompanyMenuPage().assertAgentCannotRe_AssignDeletedCustomerPackageUnlessItsAssignedToHim("Gamma Mobile Contract Package 1","Winter Special Promotion");

    }

    @Given("^CP has issued tariff and free minute permissions$")
    public void cpHasIssuedTariffAndFreeMinutePermissions() throws InterruptedException, AWTException {
        webModel.getLoginPage().doLogin();
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getDashBoardPage().loadTariffManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)","10","checkbox0");
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().loadPermissionGroups();
        webModel.getSettingsPage().issueTariffAndFreeMinutePermissionsToAgent("agent");
        webModel.getDashBoardPage().logOut();
    }
}
