package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.stepDefs.WLR3.NA44_Agent_Login_stepDefs;
import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 29/06/2017.
 */
public class NA167_WhiteLabel_ValidatePricingDetailsPage_As_A_CP_stepDefs {
   WebModel webModel=new WebModel();
    NA44_Agent_Login_stepDefs na44=new NA44_Agent_Login_stepDefs();


    @When("^I create a customer and navigate to pricing details$")
    public void iCreateACustomerAndNavigateToPricingDetails() throws InterruptedException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getContactManagerPage().searchAndClickBusinessCustomer(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getUtils().switchToNewWindow();
        webModel.getCompanyMenuPage().clickPricingDetails();


    }

    @And("^select a package from the dropdown$")
    public void selectAPackageFromTheDropdown() throws InterruptedException {
        webModel.getCompanyMenuPage().selectingPackageFromDropDown("Gamma Mobile Contract Package 1");

    }

    @Then("^I should be able to perform extensive validations on pricing details page$")
    public void iShouldBeAbleToPerformExtensiveValidationsOnPricingDetailsPage() throws InterruptedException {
        webModel.getCompanyMenuPage().validatePricingDetailsPage_assertCheckedTariffsAndInitialSaveWithFreeMinutePackageAssertions();
        webModel.getCompanyMenuPage().validatePricingDetailsPage_unCheckPackageFreeMinutesAndAddNativeFreeMinutes("Voice - 500 UK Loc & Nat");
        webModel.getCompanyMenuPage().validatePricingDetailsPage_assertTariffDropDownCannotBeUnselectedWhenOnPackage("Mobile Gamma Sharer 2000");
        webModel.getCompanyMenuPage().validatePricingDetailsPage_selectingNativeTariffFromDropDown("Sell Data Tariff","Buy");
    }

}
