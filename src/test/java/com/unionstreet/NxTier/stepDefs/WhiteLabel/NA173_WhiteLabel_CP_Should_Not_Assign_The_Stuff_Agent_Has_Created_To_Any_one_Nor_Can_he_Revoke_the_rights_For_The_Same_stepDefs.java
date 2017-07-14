package com.unionstreet.NxTier.stepDefs.WhiteLabel;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;

/**
 * Created by RajeshG on 14/07/2017.
 */
public class NA173_WhiteLabel_CP_Should_Not_Assign_The_Stuff_Agent_Has_Created_To_Any_one_Nor_Can_he_Revoke_the_rights_For_The_Same_stepDefs {
    WebModel webModel = new WebModel();

    @Then("^I should not be able to assign that particular plan to any one else and I should not be able to revoke the permissions of the creator$")
    public void iShouldNotBeAbleToAssignThatParticularPlanToAnyOneElseAndIShouldNotBeAbleToRevokeThePermissionsOfTheCreator() throws InterruptedException {
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getCreateTariffPage().cpCannotAssignAgentsPlanToAnyOneElseNorCanHeRevokeIt(webModel.getCreateTariffPage().RanTariffPlanName, "HrefAssignTarrifs", "Abacus Consultants");
        try {
            webModel.getCommonMethods().navigateToHome();
        } catch (Exception e) {
            webModel.getUtils().checkAlert();
        }
        webModel.getDashBoardPage().clickConfigManager();

        webModel.getConfigManagerPage().accessFreeMinutesTab();
        webModel.getConfigManagerPage().cpCannotAssignAgentsFreeMinutesAndPackagesToAnyOneElseNorCanHeRevokeIt(webModel.getConfigManagerPage().RanFreeMinutePlanName, "HrefAssignFreeMinutes", "Abacus Consultants","4");
        try {
            webModel.getCommonMethods().navigateToHome();
        } catch (Exception e1) {
            webModel.getUtils().checkAlert();
        }
        webModel.getDashBoardPage().clickConfigManager();
        webModel.getConfigManagerPage().loadPackageManager();
        webModel.getConfigManagerPage().cpCannotAssignAgentsFreeMinutesAndPackagesToAnyOneElseNorCanHeRevokeIt(webModel.getConfigManagerPage().RanPackageName, "HrefAssignPackage", "Abacus Consultants","8");
    }
}
