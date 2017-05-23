package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by rajeshg on 18/10/2016.
 */
public class NA61_WLR3_Analogue_Premium_Single_Transfer_Obtaining_Initial_information_stepdefs {

    WebModel webModel = new WebModel();

    @Given("^I am logged in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iAmLoggedInWithAnd(String userName, String passWord) throws InterruptedException {
        webModel.getLoginPage().login(userName, passWord);
    }

    @When("^I populate network calling features and directory information$")
    public void iPopulateNetworkCallingFeaturesAndDirectoryInformation() throws InterruptedException, SQLException {
       webModel. getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_networkCallingFeaturesPage().populateNetworkCallingFeatures();
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_directoryInformationPage().populatingDirectoryInformation("Telecom");
    }

    @Then("^The saved information should be seen on the WLR order details page$")
    public void theSavedInformationShouldBeSeenOnTheWLROrderDetailsPage() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().assertPopulatedNetworkCallingFeaturesOnWlr3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertPopulatedDirectoryInformationOnWlr3OrderPage();
    }

    @And("^When i depopulate the network calling features and edit directory information$")
    public void whenIDepopulateTheNetworkCallingFeaturesAndEditDirectoryInformation() throws InterruptedException, SQLException {
       webModel.getWlr3_networkCallingFeaturesPage().enterNetworkFeatures(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_networkCallingFeaturesPage().depopulateNetworkCallingFeatures();
        webModel.getWlr3_directoryInformationPage().editDirectoryInformation(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^The changes should be manifested on the WLR order details page$")
    public void theChangesShouldBeManifestedOnTheWLROrderDetailsPage() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().assertDepopulatedNetworkCallingFeaturesOnWlr3OrderPage();
        webModel.getWlr3_orderDetails_page().assertDepopularedDirectoryInformationOnWlr3OrderPage();
        System.out.println("NA61a completed");
    }

    @When("^I access site information page and populate it$")
    public void iAccessSiteInformationPageAndPopulateIt() throws InterruptedException, SQLException {
       webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_installationAddressPage().populateInstallationAddressPage();
        webModel.getWlr3_orderDetails_page().pickAndAssertPostCodeOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName,"LU1 1DQ");
        webModel.getWlr3_siteInformationPage().populatingSiteInformation(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^The saved information should be seen under site information on the WLR order details page$")
    public void theSavedInformationShouldBeSeenUnderSiteInformationOnTheWLROrderDetailsPage() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertPopulatedSiteContactsOnWLR3OrderPage();
    }

    @And("^When i depopulate the information page$")
    public void whenIDepopulateTheInformationPage() throws InterruptedException {
        webModel.getWlr3_siteInformationPage().depopulateSiteInformation();
    }

    @Then("^The information should vanish under site information from the WLR order details page$")
    public void theInformationShouldVanishUnderSiteInformationFromTheWLROrderDetailsPage() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().assertDepopulatedSiteInformationOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getUtils().checkPoint("NA61b completed");

    }
}
