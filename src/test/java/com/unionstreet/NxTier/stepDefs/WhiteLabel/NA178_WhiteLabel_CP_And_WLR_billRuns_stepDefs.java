package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 11/08/2017.
 */
public class NA178_WhiteLabel_CP_And_WLR_billRuns_stepDefs {
    WebModel webModel =new WebModel();

    @And("^there are billRuns already created$")
    public void thereAreBillRunsAlreadyCreated() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set name='Normal', hidden='0', billnow='0',defaultBillrunID=NULL where ID='5'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set name='WLR' where ID='10'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set OwnedByCompanyId='140' where ID='10'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set name='BillNow' where ID='9'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set name='Hide_BillNow' where ID='1'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set name='Hidden' where ID='7'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update billrun set billnow='0',defaultBillrunID=NULL where ID='7'");


    }

    @When("^I navigate to the relevant pages then I should be able to check all the validations for non-WLR customer as a CP$")
    public void iNavigateToTheRelevantPagesThenIShouldBeAbleToCheckAllTheValidationsForNonWLRCustomerAsACP() throws InterruptedException {
        webModel.getCommonMethods().search("ABC Ltd");
        webModel.getCommonMethods().clickAndSwitchTo("Head Office");
        webModel.getCompanyMenuPage().validateBillRunForNon_WLR_underInvoicingDetails();
        webModel.getCompanyMenuPage().validateBillRunForNon_WLR_serviceCharges();
        webModel.getCommonMethods().search("ABC Ltd");
        webModel.getCommonMethods().clickAndSwitchTo("Head Office");
        webModel.getCompanyMenuPage().validateBillRunForNon_WLR_underCLI();
        webModel.getCompanyMenuPage().validateBillRunForNonWLR_underRevenueAssurance();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCompanyMenuPage().validateBillRun_underAgentInfo();
    }

    @When("^I navigate to the relevant pages then I should be able to check all the validations for WLR customer as a CP$")
    public void iNavigateToTheRelevantPagesThenIShouldBeAbleToCheckAllTheValidationsForWLRCustomerAsACP() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set agent_id=NULL,agent_contact_id=NULL, AgentContact=NULL where ID='141'");
        webModel.getCommonMethods().search("WLR");
        webModel.getCommonMethods().clickAndSwitchTo("WLR");
        webModel.getCompanyMenuPage().validateBillRunForWLR_underInvoicingDetails_cutomerSetToNonWLR();
        webModel.getCompanyMenuPage().validateBillRunForWLR_underInvoicingDetails_cutomerSetToWLR();

        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set agent_id=NULL,agent_contact_id=NULL, AgentContact=NULL where ID='141'");
        webModel.getCommonMethods().search("WLR");
        webModel.getCommonMethods().clickAndSwitchTo("WLR");
        webModel.getCompanyMenuPage().validateBillRunForWLR_underServiceCharges();
        webModel.getUtils().closeCurrentPage();
        webModel.getUtils().switchToPreviousWindow(0);
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set agent_id=NULL,agent_contact_id=NULL, AgentContact=NULL where ID='141'");
        webModel.getCommonMethods().search("WLR");
        webModel.getCommonMethods().clickAndSwitchTo("WLR");
        webModel.getCompanyMenuPage().validateBillRunForWLR_underCLI();


    }

    @Given("^I am logged in as a WhiteLabelReseller$")
    public void iAmLoggedInAsAWhiteLabelReseller() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException, AWTException {

       try{ webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "insert into UserLogin (ContactID,Username,Password,GID,IsLoginAllowed,LastLoggedInDate,IsRestrict) values ('60','whitelabelreseller','5000:w5xPNQMZWgt8fYbEzfKOPuAB+lPOmfJN:Na1KXcM/UV2KBdxKcVz1pxCFGF3aAAQW','b99d95f9-bbec-45b1-abc2-db70df79c4ce','1',getdate(),'0')");}
       catch (SQLException e){
           System.out.println("WhiteLabelReseller already created");
       }
               webModel.getLoginPage().login("whiteLabelReseller", "password");

    }

    @When("^I navigate to the relevant pages then I should be able to check all the validations for WLR customer as a WhiteLabelReseller$")
    public void iNavigateToTheRelevantPagesThenIShouldBeAbleToCheckAllTheValidationsForWLRCustomerAsAWhiteLabelReseller() throws InterruptedException {
        webModel.getCommonMethods().search("WLR");
        webModel.getCommonMethods().clickAndSwitchTo("WLR");
        webModel.getCompanyMenuPage().assertBillRunWhenLoggedInAsWLR_underInvoicingDetails("customerOfWLR");
        webModel.getCompanyMenuPage().assertBillRunWhenLoggedInAsWLR_underServiceCharges("customerOfWLR");
        webModel.getCommonMethods().search("WLR");
        webModel.getCommonMethods().clickAndSwitchTo("WLR");
        webModel.getCompanyMenuPage().assertBillRunWhenLoggedInAsWLR_underCLI("customerOfWLR");
        webModel.getCompanyMenuPage().validateBillRunForWLR_underRevenueAssurance();
    }

}
