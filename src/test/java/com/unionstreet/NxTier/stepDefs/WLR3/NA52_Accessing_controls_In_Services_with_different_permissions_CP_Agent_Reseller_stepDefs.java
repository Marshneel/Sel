package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 06/10/2016.
 */
public class NA52_Accessing_controls_In_Services_with_different_permissions_CP_Agent_Reseller_stepDefs {
    WebModel webModel=new WebModel();
    NA44_Agent_Login_stepDefs na44_agent_login_stepDefs = new NA44_Agent_Login_stepDefs();

    @And("^create a new quote and access a service$")
    public void createANewQuoteAndAccessAService() throws InterruptedException {
        na44_agent_login_stepDefs.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().clickCreateQuoteButton();
        webModel.getDashBoardPage().createQuote();
        webModel.getDashBoardPage().searchQuoteByBcRN();
        webModel.getDashBoardPage().clickOnQuoteID();
        webModel.getDashBoardPage().addServiceToQuote("permissions");
    }

    @Then("^the CP only control should be visible and accessible$")
    public void theCPOnlyControlShouldBeVisibleAndAccessible() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getDashBoardPage().assertCPonlyCheckBoxPresentAndAccessible();


    }

    @And("^this should be verified by checking the back end$")
    public void thisShouldBeVerifiedByCheckingTheBackEnd() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlQuery("select SellPrice from Order_Services_Products where OrderServicesID="+webModel.getUtils().id+"");
        webModel.getUtils().assertThereIsCharge("SellPrice",600);
    }

    @Then("^the CP only control should be invisible$")
    public void theCPOnlyControlShouldBeInvisible() {
        webModel.getDashBoardPage().assertCPonlyCheckBoxIsAbsent();

    }

    @And("^the absence of the charge should be verified in the back end$")
    public void theAbsenceOfTheChargeShouldBeVerifiedInTheBackEnd() throws SQLException, UnsupportedEncodingException, ClassNotFoundException {
        webModel.getUtils().sqlQuery("select SellPrice from Order_Services_Products where OrderServicesID="+webModel.getUtils().id+"");
        webModel.getUtils().assertThereIsNoCharge();
    }
}
