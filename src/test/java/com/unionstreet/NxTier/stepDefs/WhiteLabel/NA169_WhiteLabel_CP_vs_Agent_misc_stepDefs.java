package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 30/06/2017.
 */
public class NA169_WhiteLabel_CP_vs_Agent_misc_stepDefs {

    WebModel webModel = new WebModel();

    @When("^I navigate to create service charge page$")
    public void iNavigateToCreateServiceChargePage() throws InterruptedException {

        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCommonMethods().search("business customer agent assigned");
    }
    @Then("^I should be able to see the cost, sell and baseline prices during the charge creation$")
    public void iShouldBeAbleToSeeTheCostSellAndBaselinePricesDuringTheChargeCreation()  {
        webModel.getCompanyMenuPage().addServiceChargeToCustomerOrSite("business customer agent assigned");

    }



    @Given("^CP has assigned a service charge to one of my customers$")
    public void cpHasAssignedAServiceChargeToOneOfMyCustomers() throws InterruptedException {
       webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCommonMethods().search("business customer agent assigned");
        webModel.getCompanyMenuPage().addServiceChargeToCustomerOrSite("business customer agent assigned");
        webModel.getDashBoardPage().logOut();
    }

    @And("^navigate to that particular charge page$")
    public void navigateToThatParticularChargePage() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCommonMethods().search("business customer agent assigned");


    }

    @Then("^I should be able to see the prices as an agent point of view$")
    public void iShouldBeAbleToSeeThePricesAsAnAgentPointOfView(){
        webModel.getCompanyMenuPage().assertChargesForResellerAndAgent("business customer agent assigned","Additional Channels T-Reference",false,true);

    }






















    @When("^I navigate to the required pages then I should be able to cary out required validations as a CP$")
    public void iNavigateToTheRequiredPagesThenIShouldBeAbleToCaryOutRequiredValidationsAsACP() throws InterruptedException {

        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        //webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickInvoicingDetailsButton();
        webModel.getCompanyMenuPage().assertBillRunIsPresentForCPUnderInvoicingDetails();
        webModel.getCompanyMenuPage().clickServiceChargesButton();
        webModel.getCompanyMenuPage().assertBillRunAndChargeTypeUnderAddServices(true);

    }

    @When("^I navigate to the required pages then I should be able to cary out required validations as an agent$")
    public void iNavigateToTheRequiredPagesThenIShouldBeAbleToCaryOutRequiredValidationsAsAnAgent() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
      //  webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickInvoicingDetailsButton();
        webModel.getCompanyMenuPage().assertBillRunIsAbsentForAgentUnderInvoicingDetails();
        webModel.getCompanyMenuPage().clickServiceChargesButton();
        webModel.getCompanyMenuPage().assertBillRunAndChargeTypeUnderAddServices(false);
    }


}
