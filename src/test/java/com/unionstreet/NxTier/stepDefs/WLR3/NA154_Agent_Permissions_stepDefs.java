package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Given;

/**
 * Created by RajeshG on 06/06/2017.
 */
public class NA154_Agent_Permissions_stepDefs {

    WebModel webModel=new WebModel();

    @Given("^CP has issued few tariff and free minute plans$")
    public void cpHasIssuedFewTariffAndFreeMinutePlans() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getCompanyMenuPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlansToAgent();



    }
}
