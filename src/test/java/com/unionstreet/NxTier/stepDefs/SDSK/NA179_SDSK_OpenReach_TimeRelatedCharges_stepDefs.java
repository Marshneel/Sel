package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by rajeshg on 07/08/2017.
 */
public class NA179_SDSK_OpenReach_TimeRelatedCharges_stepDefs {
    WebModel webModel=new WebModel();

    @Then("^I should be able to validate the charges$")
    public void iShouldBeAbleToValidateTheCharges()  {
        webModel.getServiceDesk_loginIncidentPage().validateTimeRelatedCharges();


}

    @And("^I should be able to assert that the time related charges is unavailable for ISD(\\d+) and virtual lines$")
    public void iShouldBeAbleToAssertThatTheTimeRelatedChargesIsUnavailableForISDAndVirtualLines(int arg0) throws InterruptedException {
        webModel.getServiceDesk_loginIncidentPage().selectCLIToObtainInstallationDetails("01202300912","WLR RCF","2","2",false);
        webModel.getServiceDesk_loginIncidentPage().assertLineTestAndTRCAbsentForISDN30AndVirtualLines();
        webModel.getServiceDesk_loginIncidentPage().selectCLIToObtainInstallationDetails("01202300945","WLR3 ISDN 30 ETSI","8","4",true);


    }
}
