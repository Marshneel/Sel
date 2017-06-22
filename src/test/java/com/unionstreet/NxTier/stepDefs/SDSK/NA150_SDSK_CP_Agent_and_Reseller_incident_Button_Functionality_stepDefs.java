package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 02/06/2017.
 */
public class NA150_SDSK_CP_Agent_and_Reseller_incident_Button_Functionality_stepDefs {
    WebModel webModel=new WebModel();


    @When("^I access service desk page and search for a \"([^\"]*)\" with \"([^\"]*)\"$")
    public void iAccessServiceDeskPageAndSearchForAWith(String accountName, String ID) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='0', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByAccountName(accountName);
        webModel.getServiceDeskPage().clickOnResult(accountName);
    }

    @Then("^I should be able to check the functionality of the create incident button by searching for \"([^\"]*)\" and switching between various stages of account hold/active status with and without SLA for company with \"([^\"]*)\"$")
    public void iShouldBeAbleToCheckTheFunctionalityOfTheCreateIncidentButtonBySearchingForAndSwitchingBetweenVariousStagesOfAccountHoldActiveStatusWithAndWithoutSLAForCompanyWith(String accountName, String ID)throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getServiceDeskPage().accountStatus_And_SlaStatus("Ok","Default");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().scrollBack();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id=NULL where ID='"+ID+"'");
        webModel.getServiceDeskPage().searchByAccountName(accountName);
        webModel.getServiceDeskPage().clickOnResult(accountName);
        webModel.getServiceDeskPage().accountStatus_And_SlaStatus("On Hold","No SLA Assigned");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDeskPage().assertNoSLAwarningPopUp();
        webModel.getUtils().scrollBack();
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=2");
        webModel.getServiceDeskPage().searchByAccountName(accountName);
        webModel.getServiceDeskPage().clickOnResult(accountName);
        webModel.getServiceDeskPage().accountStatus_And_SlaStatus("On Hold","Default");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDeskPage().assertAccountOnHoldRedPopUp();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=1");
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByAccountName(accountName);
        webModel.getServiceDeskPage().clickOnResult(accountName);
        webModel.getServiceDeskPage().accountStatus_And_SlaStatus("On Hold","Default");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDeskPage().assertAccountOhHoldYellowPopUp();
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().scrollBack();
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getServiceDeskPage().searchByAccountName(accountName);
        webModel.getServiceDeskPage().clickOnResult(accountName);
        webModel.getServiceDeskPage().accountStatus_And_SlaStatus("On Hold","Default");
        webModel.getServiceDeskPage().clickIncidentButton();
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
    }


}
