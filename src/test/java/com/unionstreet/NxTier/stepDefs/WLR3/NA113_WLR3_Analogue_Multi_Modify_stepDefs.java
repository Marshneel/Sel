package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 12/04/2017.
 */
public class NA113_WLR3_Analogue_Multi_Modify_stepDefs {

    WebModel webModel = new WebModel();

    @And("^Provide a valid CLI and post code$")
    public void provideAValidCLIAndPostCode() throws InterruptedException {
        webModel.getWlr3_modify_orderPage().assertTextOnModifyOrderPage();
        webModel.getWlr3_modify_orderPage().initiatingModifyOrder("01202300909", "LU1 1DQ");
        webModel.getWlr3_orderDetails_page().textOnWLR3OrderPage();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().zoomOutOnInstallationAddressUnderModifyOrder();
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getWlr3_orderDetails_page().assertAddress("Kenilworth Road", "AppleGarth", "The Willows", "26","A00001043137");
    }


    @Then("^I should be able to access line numbering options and perform validations$")
    public void iShouldBeAbleToAccessLineNumberingOptionsAndPerformValidations() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_orderDetails_page().clickLineNumbering();
        webModel.getWlr3_lineNumberingPage().validationForEmptyCallForwardCLIField_Under_SpecifyNewNumber("Caller Redirect", "01582213000");
        webModel.getWlr3_lineNumberingPage().validatePreviousNumberManagementOptionsInModifyOrder("Caller Redirect", "02012345678");
        webModel.getWlr3_orderDetails_page().assertCallForwardAndRedirect("01202300909", "02012345678", "Quarterly Caller Redirect");
        webModel.getWlr3_orderDetails_page().clickLineNumbering();
        webModel.getWlr3_lineNumberingPage().clickNoChangeTab();
        webModel.getWlr3_lineNumberingPage().validatePreviousNumberManagementOptionsInModifyOrder("Remote Call Forward", "02012345678");
        webModel.getWlr3_orderDetails_page().assertCallForwardAndRedirect("01202300909", "02012345678", "Remote Call Forward");
        webModel.getWlr3_orderDetails_page().clickLineNumbering();
        webModel.getWlr3_lineNumberingPage().takeNumberFromAnotherWorkingLine_emptyFieldValidations();
        webModel.getWlr3_lineNumberingPage().takeNumberFromAnotherWorkingLine_populateFields("02063678369", "02012345678");


    }


    @Then("^I should be able to check the validations$")
    public void iShouldBeAbleToCheckTheValidations() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().clickLineNumbering();
        webModel.getWlr3_lineNumberingPage().checkValidationsOnEmptyCLIField_UnderAutomaticallyAssign("Caller Redirect");

    }
}


