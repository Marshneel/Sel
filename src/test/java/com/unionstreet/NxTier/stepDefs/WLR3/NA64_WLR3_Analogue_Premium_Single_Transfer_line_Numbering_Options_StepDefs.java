package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 26/10/2016.
 */
public class NA64_WLR3_Analogue_Premium_Single_Transfer_line_Numbering_Options_StepDefs {
    WebModel webModel = new WebModel();


    @When("^I access specify new number, select from list and automatically assign now with out populating installation address, an error should be thrown$")
    public void iAccessSpecifyNewNumberSelectFromListAndAutomaticallyAssignNowWithOutPopulatingInstallationAddressAnErrorShouldBeThrown() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().assertionForLineNumberingWithOutAddress();
    }

    @And("^when i populate the installation address field and access the same$")
    public void whenIPopulateTheInstallationAddressFieldAndAccessTheSame() throws InterruptedException, SQLException {
        webModel.getWlr3_lineNumberingPage().closeLineNumberingPage();
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_installationAddressPage().populateInstallationAddressPage();
        webModel.getWlr3_orderDetails_page().pickAndAssertPostCodeOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName,"LU1 1DQ");
    }

    @Then("^The error should not be seen$")
    public void theErrorShouldNotBeSeen() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().assertionForLineNumberingWithAddress();
    }


    @When("^I access line numbering page$")
    public void iAccessLineNumberingPage() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_installationAddressPage().populateInstallationAddressPage();
        webModel.getWlr3_orderDetails_page().pickAndAssertPostCodeOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName,"LU1 1DQ");
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^I should be able to check all required validations$")
    public void iShouldBeAbleToCheckAllRequiredValidations() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        //no change
        webModel.getWlr3_orderDetails_page().lineNumberingNoChangeWithAssertions("01202300908");
        //automatically assign now
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().lineNumberingAutomaticallyAssignWithAssertions();
        //specify new number
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().lineNumberingSpecifyNewNumber("01582213000");
        webModel.getWlr3_lineNumberingPage().assertionForLineNumberingSpecifyNewNumber(webModel.getNewBusinessCustomerPage().RanName,"01582213000");
        //select from the list
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().lineNumberingSelectFromList("01582213000");
        webModel.getWlr3_lineNumberingPage().assertionForSelectFromList("01582213000");
        //webModel.getWlr3_orderDetails_page().clickLineNumbering();
        //importing number from other networks: move number from another address
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().importNumberWithChangeOfAddress("01777777777", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().assertImportedLineWithChangeOfPostCodeAndAidOfGoldAddress(webModel.getNewBusinessCustomerPage().RanName,"01777777777");
        //importing number from other networks:  by letter of authority
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().importFromOtherNetworkWithLetterOfAuthority(webModel.getNewBusinessCustomerPage().RanName,"01777777777");
        webModel.getWlr3_orderDetails_page().assertImportedLineWithAidOfLetterOfAuthority(webModel.getNewBusinessCustomerPage().RanName,"01777777777");
        //importing number from other networks: by vic
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().importNumberWithVic(webModel.getNewBusinessCustomerPage().RanName,"01777777777", "HS009766509");
        webModel.getWlr3_orderDetails_page().assertNumberImportedWithVic(webModel.getNewBusinessCustomerPage().RanName,"01777777777", "HS009766509");
        //automatically assign now
        webModel.getWlr3_orderDetails_page().clickLineNumbering(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_lineNumberingPage().lineNumberingAutomaticallyAssignNumber("01582213000");
        webModel.getWlr3_lineNumberingPage().assertionForAutomaticallyAssign(webModel.getNewBusinessCustomerPage().RanName,"01582213000");
    }

    @When("^I access appointments page on the WLR order details page$")
    public void iAccessAppointmentsPageOnTheWLROrderDetailsPage() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_installationAddressPage().populateInstallationAddressPage();
        webModel.getWlr3_orderDetails_page().pickAndAssertPostCodeOnWLR3OrderPage(webModel.getNewBusinessCustomerPage().RanName,"LU1 1DQ");
        webModel.getWlr3_orderDetails_page().clickOnAppointment();
        webModel.getWlr3_appointmentPage().bookAppointmentGeneral("02/11/2016", "8:00-13:00");
    }

    @Then("^I should be able to perform the required validations$")
    public void iShouldBeAbleToPerformTheRequiredValidations() {
        webModel.getUtils().checkPoint("NA64b line numbering done");
    }
}
