package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 30/06/2017.
 */
public class NA169_WhiteLabel_CP_vs_Agent_misc_stepDefs {

    WebModel webModel = new WebModel();
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
