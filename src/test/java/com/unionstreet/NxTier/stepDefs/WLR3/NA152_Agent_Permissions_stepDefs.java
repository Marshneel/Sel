package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 06/06/2017.
 */
public class NA152_Agent_Permissions_stepDefs {

    WebModel webModel=new WebModel();
    NA44_Agent_Login_stepDefs na44_agent_login_stepDefs = new NA44_Agent_Login_stepDefs();

    @Given("^CP has issued few tariff and free minute plans$")
    public void cpHasIssuedFewTariffAndFreeMinutePlans() throws InterruptedException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)");
        webModel.getConfigManagerPage().assignFreeMinutesPlanToAgent("Mobile 250 Free Mins (UK and Mob");
        webModel.getSettingsPage().clickSettingsButton();
        webModel.getSettingsPage().issueTariffAndFreeMinutePermissionsToAgent("agent");
        webModel.getDashBoardPage().logOut();
    }

    @When("^I am logged in as agent with out Zoom$")
    public void iAmLoggedInAsAgentWithOutZoom() throws InterruptedException {
        webModel.getLoginPage().loginAsAgent();
    }


    @And("^navigate to see config manager page$")
    public void navigateToSeeConfigManagerPage() {
        webModel.getCompanyMenuPage().clickConfigManager();
    }

    @Then("^I should be able to see the tariff and free minute plans$")
    public void iShouldBeAbleToSeeTheTariffAndFreeMinutePlans() {
        webModel.getConfigManagerPage().assertTariff("Sell 2p NGCS AC (+60 sec)");
        webModel.getConfigManagerPage().assertFreeMinutes("Mobile 250 Free Mins (UK and Mob");
    }

    @And("^I should not be able to edit them$")
    public void iShouldNotBeAbleToEditThem() {
        webModel.getConfigManagerPage().assertFreeMinutesAreNotEditable("Mobile 250 Free Mins (UK and Mob");
        webModel.getConfigManagerPage().assertTariffAreNotEditable("Sell 2p NGCS AC (+60 sec)");
    }


    @When("^I navigate to config manager$")
    public void iNavigateToConfigManager() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Group_Permissions set [Add]='1', [View]='1',[Edit]='1', [Delete]='1' where GTypeID='b99d95f9-bbec-45b1-abc2-db70df79c4ce' and Name='Free Minutes Details'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Group_Permissions set [Add]='1', [View]='1',[Edit]='1', [Delete]='1' where GTypeID='b99d95f9-bbec-45b1-abc2-db70df79c4ce' and Name='Tariff Details'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Group_Permissions set [Add]='1', [View]='1',[Edit]='1', [Delete]='1' where GTypeID='b99d95f9-bbec-45b1-abc2-db70df79c4ce' and Name='Tariff Rates'");
    }

    @Then("^I should be able to make editable tariff and free minute plans$")
    public void iShouldBeAbleToMakeEditableTariffAndFreeMinutePlans() throws InterruptedException {
        webModel.getConfigManagerPage().addTariffPlan();
        webModel.getConfigManagerPage().addFreeMinutesPlan();
       webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().editTariffPlan();
        webModel.getConfigManagerPage().editFreeMinutePlan();
    }

    @When("^I navigate to contact manager page and search for the contact$")
    public void iNavigateToContactManagerPageAndSearchForTheContact() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCommonMethods().search(webModel.getNewBusinessCustomerPage().RanName);


    }

    @Then("^I should be able to find it$")
    public void iShouldBeAbleToFindIt()  {
        webModel.getUtils().waitForElementVisible(By.xpath("//a[contains(text(),'"+webModel.getNewBusinessCustomerPage().RanName+"')]"));
    }

    @When("^I create tariff and free minute plans$")
    public void iCreateTariffAndFreeMinutePlans() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        iNavigateToConfigManager();
        webModel.getConfigManagerPage().addTariffPlan();
        webModel.getConfigManagerPage().addFreeMinutesPlan();
    }

    @Then("^I should be able to assign them to my customers$")
    public void iShouldBeAbleToAssignThemToMyCustomers() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        na44_agent_login_stepDefs.haveCreatedANewCustomer();
        webModel.getCommonMethods().search(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getUtils().clickBtn(By.xpath("//a[contains(text(),'"+webModel.getNewBusinessCustomerPage().RanName+"')]"));
        webModel.getCompanyMenuPage().assertAgentCreatedTariffandFreeMinutes();

    }

    @Given("^CP has issued tariff and free minute plans to customers assigned under me$")
    public void cpHasIssuedTariffAndFreeMinutePlansToCustomersAssignedUnderMe() throws InterruptedException {
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Sell 2p NGCS AC (+60 sec)");
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Buy BT Wholesale");
        webModel.getConfigManagerPage().assignFreeMinutesPlanToAgent("Mobile 250 Free Mins (UK and Mob");
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickPricingDetails();
        webModel.getCompanyMenuPage().assignTariffAndFreeMinutesToCustomer("Mobile Gamma 1GB Data","Sell Data Tariff");
        webModel.getDashBoardPage().logOut();


    }

    @And("^navigate to pricing details of that particular customer$")
    public void navigateToPricingDetailsOfThatParticularCustomer() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickPricingDetails();
    }

    @Then("^I should be able to see and remove them$")
    public void iShouldBeAbleToSeeAndRemoveThem() throws InterruptedException {
        webModel.getCompanyMenuPage().assertCPAssignedTariffAndFreeMinutes("sinfo_LCR_Tariff","sinfo_Data_Tariff","Sell Data Tariff","Mobile Gamma 1GB Data");
        webModel.getCompanyMenuPage().removeCPAssignedTariffAndFreeMinutes();
    }

    @And("^I should not be able to see them once they are removed unless they are assigned to me$")
    public void iShouldNotBeAbleToSeeThemOnceTheyAreRemovedUnlessTheyAreAssignedToMe() throws InterruptedException {
    webModel.getCompanyMenuPage().assertAgentCannotSeeCPAssignedTariffAndFreeMinutes("Sell Data Tariff","Mobile Gamma 1GB Data");
    webModel.getCompanyMenuPage().assertAgentCanOnlySeeAndAssignTariffAndFreeMinutePlansThatCPHasGivenPermissionFor("Sell 2p NGCS AC (+60 sec)","Buy BT Wholesale");
    }


}
