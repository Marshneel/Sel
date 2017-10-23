package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
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

    @Given("^I am logged in with \"([^\"]*)\" and \"([^\"]*)\" without access rights$")
    public void iAmLoggedInWithAndWithoutAccessRights(String userName, String passWord) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getLoginPage().login(userName, passWord);
       webModel.getServiceDeskPage().revokingServiceDeskPermissions();

    }
    @When("^I try to navigate to service desk page the access should be denied$")
    public void iTryToNavigateToServiceDeskPageTheAccessShouldBeDenied () throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getDashBoardPage().loadServiceDesk();
      webModel.getServiceDeskPage().clickLogAnIncidentButton();
      try{   webModel.getServiceDeskPage().assertServiceDeskAccessDenied();
     }catch (Exception e){
          webModel.getServiceDeskPage().revokingServiceDeskPermissions();
          webModel.getServiceDeskPage().clickLogAnIncidentButton();

      }}

    @And("^when I am granted the service desk access and I login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void whenIAmGrantedTheServiceDeskAccessAndILoginWithAnd(String userName, String passWord) throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException {
        webModel.getUtils().scrollBack();
        webModel.getServiceDeskPage().grantingServiceDeskAccess();
        webModel.getDashBoardPage().logOut();
        webModel.getLoginPage().login(userName, passWord);
        webModel.getDashBoardPage().loadServiceDesk();
    }

    @Then("^Based on the status of the account and SLA, I should be able to or unable to log a ticket for business customer with \"([^\"]*)\" and \"([^\"]*)\" via pasting the URL$")
    public void basedOnTheStatusOfTheAccountAndSLAIShouldBeAbleToOrUnableToLogATicketForBusinessCustomerWithAndViaPastingTheURL(String ID, String SiteID) throws UnsupportedEncodingException, SQLException, ClassNotFoundException, AWTException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='0', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getUtils().enterServiceDeskURLandCLickEnter(""+SiteID+"");
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='0' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getUtils().enterServiceDeskURLandCLickEnter(""+SiteID+"");
        webModel.getServiceDeskPage().assertServiceDeskAccessDenied();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=0");
        webModel.getUtils().enterServiceDeskURLandCLickEnter(""+SiteID+"");
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=1");
        webModel.getUtils().enterServiceDeskURLandCLickEnter(""+SiteID+"");
        webModel.getServiceDeskPage().assertAccessGrantedToLoginIncident();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set isOnHold='1', defServiceLevel_id='1' where ID='"+ID+"'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update account_onhold_actions set servicedesk_action=2");
        webModel.getUtils().enterServiceDeskURLandCLickEnter(""+SiteID+"");
        webModel.getServiceDeskPage().assertServiceDeskAccessDenied();
        webModel.getServiceDeskPage().revokingServiceDeskPermissions();
    }


}
