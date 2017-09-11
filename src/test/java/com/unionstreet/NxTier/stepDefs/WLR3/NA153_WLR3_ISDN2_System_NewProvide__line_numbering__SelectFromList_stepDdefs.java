package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 15/06/2017.
 */
public class NA153_WLR3_ISDN2_System_NewProvide__line_numbering__SelectFromList_stepDdefs {

    WebModel webModel=new WebModel();


    @And("^navigate to line numbering tab$")
    public void navigateToLineNumberingTab() throws InterruptedException {
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateAndAssertInstallationAddressUnderSITE("LU1 1DQ","A00001043137");
        webModel.getwlr3_newProvide_anaMultLine_sitePage().populateSiteContactUnderSITE("07894040256");
        webModel.getWlr3_new_provide__orderPage().multipleClicksOnNextButton(4);
        webModel.getWlr3_newProvide__numberingPage().loadAdvancedLineNumbering();

    }

    @Then("^I should be able to check all the validations for select number from the list option for ISDN(\\d+) system line$")
    public void iShouldBeAbleToCheckAllTheValidationsForSelectNumberFromTheListOptionForISDNSystemLine(int arg0) throws ClassNotFoundException, SQLException, InterruptedException, UnsupportedEncodingException {
        webModel.getWlr3_newProvide__numberingPage().ISDN2_selectFromList_fancyNumbers("01582213131","01582213333");
        webModel.getWlr3_newProvide__numberingPage().ISDN2_selectFromList_selectingSameNumberTwice("01202300908");
       webModel.getWlr3_newProvide__numberingPage().ISDN2_selectFromList_assertAssignedNumberAbsentFromList("01582213000","01202300908","01582216165");
        webModel.getWlr3_newProvide__numberingPage().ISDN2system_selectFromList_addingDDIrange();
        webModel.getWlr3_newProvide__numberingPage().ISDN2system_selectFromList_switchingToSNDDIandAssigingASingleNumber("01582213000","01582216000");
        webModel.getWlr3_newProvide__numberingPage().ISDN2system_selectFromList_changingNumberCluster("01582220000","01582216027","01582214235");

    }
}
