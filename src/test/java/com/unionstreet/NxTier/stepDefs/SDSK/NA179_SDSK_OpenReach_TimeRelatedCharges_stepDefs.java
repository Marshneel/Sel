package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by rajeshg on 07/08/2017.
 */
public class NA179_SDSK_OpenReach_TimeRelatedCharges_stepDefs {
    WebModel webModel=new WebModel();

    @Then("^I should be able to validate the charges$")
    public void iShouldBeAbleToValidateTheCharges()  {
        webModel.getServiceDesk_ticketDetailsPage().validateTimeRelatedCharges();


}

    @And("^I should be able to assert that the time related charges is unavailable for ISD(\\d+) and virtual lines$")
    public void iShouldBeAbleToAssertThatTheTimeRelatedChargesIsUnavailableForISDAndVirtualLines(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR RCF' where serviceid='ORCF00000002'");
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(true,"01202300912","WLR RCF","2","2",false,"LU1 1DQ");
        webModel.getServiceDesk_ticketDetailsPage().assertLineTestAndTRCAbsentForISDN30AndVirtualLines();
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set CareLevel='4' where serviceid='OI3000000001'");
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(true,"01202300945","WLR3 ISDN 30 ETSI","8","4",true,"LU1 1DQ");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "MockCVF", "update installations set product='WLR3 ISDN RCF' where serviceid='ORCF00000002'");


    }
}
