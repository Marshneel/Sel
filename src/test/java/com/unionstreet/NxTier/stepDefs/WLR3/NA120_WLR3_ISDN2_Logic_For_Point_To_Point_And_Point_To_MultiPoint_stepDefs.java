package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 19/04/2017.
 */
public class NA120_WLR3_ISDN2_Logic_For_Point_To_Point_And_Point_To_MultiPoint_stepDefs {
    WebModel webModel=new WebModel();
    NA108_WLR3_ISDN2_New_Provide_stepDefs na108=new NA108_WLR3_ISDN2_New_Provide_stepDefs();



    @When("^I provide all the required info and access the line information on the edit order page$")
    public void iProvideAllTheRequiredInfoAndAccessTheLineInformationOnTheEditOrderPage() throws InterruptedException {
        na108.iShouldBeAbleToCheckAndValidateTheFlowOfISDN_StandardLine();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage();
    }

    @Then("^I should be able to check all point_to_point validations$")
    public void iShouldBeAbleToCheckAllPoint_to_pointValidations() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertingPointToMultiPointTextOnSummaryPage();
        webModel.getWlr3_line_information_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertPointToMultiPointConfigForISDN2Standard();



    }

    @Then("^I should be able to check all point_to_multiPoint validations$")
    public void iShouldBeAbleToCheckAllPoint_to_multiPointValidations() throws InterruptedException {
        webModel.getWlr3_orderDetails_page().assertingPointToPointTextOnSummaryPage();
        webModel.getWlr3_line_information_page().loadLineInfo();
        webModel.getWlr3_line_information_page().convertingPointToPoint_To_PointToMultiPointWithSingleSNDDI();
        webModel.getWlr3_orderDetails_page().assertingPointToMultiPointTextOnSummaryPage();

    }
}
