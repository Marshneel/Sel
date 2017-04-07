package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 17/02/2017.
 */
public class NA99_WLR3_Analogue_Batch_Transfer_stepDefs {
    WebModel webModel=new WebModel();

    @When("^I initiate a batch transfer and submit it withOut selecting the order owner$")
    public void iInitiateABatchTransferAndSubmitItWithOutSelectingTheOrderOwner() throws InterruptedException, AWTException {
        webModel.getAddServicePage().searchAndAddService("Batch Transfer Order");
        webModel.getWlr3_batchTransferPage().addCLIsToTheOrder("01202300908","LU1 1DQ");
        webModel.getEditOrderPage().submitBatchOrderBeforeOIDsGenerated();
    }

    @Then("^An error message should be thrown$")
    public void anErrorMessageShouldBeThrown() {
        webModel.getEditOrderPage().errorMessageWhenOrderSubmittedWithOutOIDs();
    }

    @When("^I initiate a batch transfer and enter the CLIs with a happy path CSV file$")
    public void iInitiateABatchTransferAndEnterTheCLIsWithAHappyPathCSVFile() throws Throwable {
        webModel.getAddServicePage().searchAndAddService("Batch Transfer Order");
        webModel.getWlr3_batchTransferPage().
        loadCSVFile("happyPathcsvFile.txt");

}

    @Then("^The data should be populated without any errors$")
    public void theDataShouldBePopulatedWithoutAnyErrors()  {
        webModel.getWlr3_batchTransferPage().assertNoErrorUponImport();
    }

    @When("^I initiate a batch transfer and upload a csv file that has no CLI$")
    public void iInitiateABatchTransferAndUploadACsvFileThatHasNoCLI() throws AWTException, InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Batch Transfer Order");
        webModel.getWlr3_batchTransferPage().loadCSVFile("noCLIcsvFile.txt");
    }

    @Then("^an error list message should be thrown$")
    public void anErrorListMessageShouldBeThrown()  {
        webModel.getWlr3_batchTransferPage().assertErrorMessageUponUploadingCSVfileWithOutCLI();


    }

    @When("^I initiate a batch order and upload a csv file with populate missing PC and EI box checked$")
    public void iInitiateABatchOrderAndUploadACsvFileWithPopulateMissingPCAndEIBoxChecked() throws AWTException, InterruptedException {
        webModel.getAddServicePage().searchAndAddService("Batch Transfer Order");
        webModel.getWlr3_batchTransferPage().loadCSVFile("nopostCodeAndNoEIcsvFile.txt");

    }

    @Then("^An error stating the missing parameters is displayed$")
    public void anErrorStatingTheMissingParametersIsDisplayed()  {
        webModel.getWlr3_batchTransferPage().assertErrorMessageForPostCodeAndEmergencyInfo();

    }

    @When("^I upload the file with populate missing postCode and emergencyInfo checked in$")
    public void iUploadTheFileWithPopulateMissingPostCodeAndEmergencyInfoCheckedIn() throws InterruptedException, AWTException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
       webModel.getWlr3_batchTransferPage().insertPostCodeInToSite();
        webModel.getEditOrderPage().getToAddServicePage();
        webModel.getAddServicePage().searchAndAddService("Batch Transfer Order");
        webModel.getWlr3_batchTransferPage().checkPopulateMissingPostCodeAndEmergencyInfo();
        webModel.getWlr3_batchTransferPage().loadCSVFile("nopostCodeAndNoEIcsvFile.txt");
    }
}
