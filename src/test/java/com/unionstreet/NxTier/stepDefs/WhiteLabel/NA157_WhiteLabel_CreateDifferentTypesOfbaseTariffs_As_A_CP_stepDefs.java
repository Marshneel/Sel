package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;

import java.awt.*;

/**
 * Created by RajeshG on 20/06/2017.
 */
public class NA157_WhiteLabel_CreateDifferentTypesOfbaseTariffs_As_A_CP_stepDefs {

    WebModel webModel=new WebModel();

    @Then("^I should be able to create the (\\d+) different types of CP tariffs$")
    public void iShouldBeAbleToCreateTheDifferentTypesOfCPTariffs(int arg0) throws InterruptedException, AWTException {
        webModel.getCreateTariffPage().createBlankTariff("3","1","0",true,false);
        webModel.getCommonMethods().search(webModel.getCreateTariffPage().RanTariffPlanName);
        webModel.getCreateTariffPage().assertCreatedTariff("Sell","Fixed Line");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("","@value",true);
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Agent Call Tariff 2","10","checkbox0");
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().createTariffPlanBasedOnOtherPlan("3","2","1","2","Agent Call Tariff 2");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20","@value",true);
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Agent Call Tariff 2","20","checkbox0");
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20","@value",true);
        webModel.getConfigManagerPage().navigateToAddTariffPlan();
        webModel.getCreateTariffPage().createTariffPlanBasedOnOtherPlan("3","2","2","2","Agent Call Tariff 2");
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("40.0000","@basevalue",false);
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().assignTariffPlanToAgent("Agent Call Tariff 2","10","checkbox0");
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().assertChargesOfTariffThatIsBasedOnAnAnotherTariff("20.0000","@basevalue",false);
    }
}
