package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 15/06/2017.
 */
public class NA154_WLR3_ISDN2_Standard_NewProvide_Line_numbering_selectFromList_stepDefs {
   WebModel webModel=new WebModel();

    @Then("^I should be able to check all the validations for select number from the list option for ISDN(\\d+) standard line$")
    public void iShouldBeAbleToCheckAllTheValidationsForSelectNumberFromTheListOptionForISDNStandardLine(int arg0) throws InterruptedException, UnsupportedEncodingException, SQLException, ClassNotFoundException {
        webModel.getWlr3_newProvide__numberingPage().ISDN2_selectFromList_fancyNumbers();
        webModel.getWlr3_newProvide__numberingPage().ISDN2_selectFromList_selectingSameNumberTwice();
        webModel.getWlr3_newProvide__numberingPage().ISDN2_selectFromList_assertAssignedNumberAbsentFromList();
        webModel.getWlr3_newProvide__numberingPage().ISDN2standard_selectingANewNumber();
    }
}
