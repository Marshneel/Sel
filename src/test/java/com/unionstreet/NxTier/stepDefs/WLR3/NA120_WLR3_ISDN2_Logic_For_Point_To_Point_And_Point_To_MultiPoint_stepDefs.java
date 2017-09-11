package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

/**
 * Created by RajeshG on 19/04/2017.
 */
public class NA120_WLR3_ISDN2_Logic_For_Point_To_Point_And_Point_To_MultiPoint_stepDefs {
    WebModel webModel=new WebModel();
    NA108_WLR3_ISDN2_New_Provide_Standard_And_System_stepDefs na108=new NA108_WLR3_ISDN2_New_Provide_Standard_And_System_stepDefs();



    @When("^I provide all the required info and access the line information on the edit order page$")
    public void iProvideAllTheRequiredInfoAndAccessTheLineInformationOnTheEditOrderPage() throws InterruptedException, SQLException {
        na108.iShouldBeAbleToCheckAndValidateTheFlowOfISDN_StandardLine();
        webModel.getWlr3_orderDetails_page().getToWLR3QuotePage(webModel.getNewBusinessCustomerPage().RanName);
    }

    @Then("^I should be able to check all point_to_multipoint validations$")
    public void iShouldBeAbleToCheckAllPoint_to_pointValidations() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().assertingPointToMultiPointTextOnSummaryPage();
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().assertPointToMultiPointConfigForISDN2Standard();



    }

    @Then("^I should be able to check all point_to_Point validations$")
    public void iShouldBeAbleToCheckAllPoint_to_multiPointValidations() throws InterruptedException, SQLException {
        webModel.getWlr3_orderDetails_page().assertingPointToPointTextOnSummaryPage();
        webModel.getWlr3_orderDetails_page().loadLineInfo();
        webModel.getWlr3_line_information_page().convertingPointToPoint_To_PointToMultiPointWithSingleSNDDI();
        webModel.getWlr3_orderDetails_page().assertingPointToMultiPointTextOnSummaryPage();
        webModel.getWlr3_lineNumberingPage().addingExtraSNDDI(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertingErrorMessageChangeFromPointToPoint_To_PointToMultiPoint();
        webModel.getWlr3_lineNumberingPage().addingExtraDDIRange(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getWlr3_orderDetails_page().assertingErrorMessageChangeFromPointToPoint_To_PointToMultiPoint();

    }
}
