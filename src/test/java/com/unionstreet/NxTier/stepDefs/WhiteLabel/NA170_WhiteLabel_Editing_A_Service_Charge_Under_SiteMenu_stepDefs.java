package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 03/07/2017.
 */
public class NA170_WhiteLabel_Editing_A_Service_Charge_Under_SiteMenu_stepDefs {
    WebModel webModel =new WebModel();
    @When("^I search for a business customer and navigate to add service charge page$")
    public void iSearchForABusinessCustomerAndNavigateToAddServiceChargePage() throws InterruptedException {
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer("business customer agent assigned");
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickServiceChargesButton();

    }
    @Then("^I should be able to perform the required validations and create new service charge for that customer$")
    public void iShouldBeAbleToPerformTheRequiredValidationsAndCreateNewServiceChargeForThatCustomer(){
        webModel.getCompanyMenuPage().addServicePage_PriceRevertsBackWhenFieldIsEmpty();
        webModel.getCompanyMenuPage().addServicePage_editPriceAndSaveChanges();
        webModel.getCompanyMenuPage().addServicePage_assertPriceRevertsBackWhenEmptyEvenAfterSavingChanges();
    }
}
