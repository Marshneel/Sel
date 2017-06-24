package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 23/06/2017.
 */
public class NA161_WhiteLabel_CreatePackage_stepDefs {
   WebModel webModel=new WebModel();
    NA152_WhiteLabel_Agent_Permissions_stepDefs na152=new NA152_WhiteLabel_Agent_Permissions_stepDefs();

    @Given("^I have been assigned tariffs and free minutes by the CP$")
    public void iHaveBeenAssignedTariffsAndFreeMinutesByTheCP() throws AWTException, InterruptedException {
        na152.cpHasIssuedFewTariffAndFreeMinutePlans();

    }

    @And("^I navigate to the package manager$")
    public void iNavigateToThePackageManager() {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().clickAdd();



    }

    @Then("^I should be able to create business and consumer packages$")
    public void iShouldBeAbleToCreateBusinessAndConsumerPackages() throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getConfigManagerPage().createPackage("1","Sell 2p NGCS AC (+60 sec)","[@disabled='True']",true);
        webModel.getConfigManagerPage().clickAdd();
        webModel.getConfigManagerPage().createPackage("2","Sell 2p NGCS AC (+60 sec)","[@checked='checked']",false);
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update tariffnames set Consumer='0' where TariffName='Sell 2p NGCS AC (+60 sec)'");
        webModel.getConfigManagerPage().clickAdd();
        webModel.getUtils().assertElementNotPresent(By.xpath("//option[contains(text(),'Sell 2p NGCS AC (+60 sec)')]"));
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update tariffnames set Consumer='1' where TariffName='Sell 2p NGCS AC (+60 sec)'");

    }


    @When("^I assign a package to agent$")
    public void iAssignAPackageToAgent() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().assignPackageToAgent("Winter Special Promotion","checkbox1");

    }

    @Then("^He should not be able to edit it$")
    public void heShouldNotBeAbleToEditIt()  {

    }
}
