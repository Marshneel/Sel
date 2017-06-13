package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 13/06/2017.
 */
public class NA151_SDSK_URL_Manipulation_stepDefs {

    WebModel webModel=new WebModel();
    @Given("^I am logged in as a CP without access rights$")
    public void iAmLoggedInAsACPWithoutAccessRights() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getServiceDeskPage().revokingServiceDeskPermissions();
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().loadServiceDesk();

    }
    @When("^I try to navigate to service desk page the access should be denied$")
    public void iTryToNavigateToServiceDeskPageTheAccessShouldBeDenied()  {
        webModel.getServiceDeskPage().assertServiceDeskAccessDenied();

    }

    @And("^when I am granted the service desk access to CP$")
    public void whenIAmGrantedTheServiceDeskAccessToCP() throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException {
        webModel.getUtils().scrollBack();
        webModel.getServiceDeskPage().grantingServiceDeskAccess();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsCP();

    }

    @Then("^Based on the status of the account and SLA, I should be able to or unable to navigate ahead via pasting the URL$")
    public void basedOnTheStatusOfTheAccountAndSLAIShouldBeAbleToOrUnableToNavigateAheadViaPastingTheURL() throws AWTException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='0', defServiceLevel_id='1' where ID='138'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getUtils().enterServiceDeskURLandCLickEnter("166");
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='0' where ID='138'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getUtils().enterServiceDeskURLandCLickEnter("166");
        webModel.getServiceDeskPage().assertServiceDeskAccessDenied();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='138'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getUtils().enterServiceDeskURLandCLickEnter("166");
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='138'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=1");
        webModel.getUtils().enterServiceDeskURLandCLickEnter("166");
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='138'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=2");
        webModel.getUtils().enterServiceDeskURLandCLickEnter("166");
        webModel.getServiceDeskPage().assertServiceDeskAccessDenied();



    }

    @Given("^I am logged in as a agent without access rights$")
    public void iAmLoggedInAsAAgentWithoutAccessRights() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getServiceDeskPage().revokingServiceDeskPermissions();
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsAgent();
        webModel.getDashBoardPage().loadServiceDesk();
    }


    @And("^when I am granted the service desk access to agent$")
    public void whenIAmGrantedTheServiceDeskAccessToAgent() throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException {
        webModel.getUtils().scrollBack();
        webModel.getServiceDeskPage().grantingServiceDeskAccess();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsAgent();
    }

    @Given("^I am logged in as a reseller without access rights$")
    public void iAmLoggedInAsAResellerWithoutAccessRights() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getServiceDeskPage().revokingServiceDeskPermissions();
        webModel.getLoginPage().zoomOutOnLoginPage();
        webModel.getLoginPage().loginAsReseller();
        webModel.getDashBoardPage().loadServiceDesk();
    }

    @And("^when I am granted the service desk access to reseller$")
    public void whenIAmGrantedTheServiceDeskAccessToReseller() throws Throwable {
        webModel.getUtils().scrollBack();
        webModel.getServiceDeskPage().grantingServiceDeskAccess();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().loginAsReseller();
    }
}
