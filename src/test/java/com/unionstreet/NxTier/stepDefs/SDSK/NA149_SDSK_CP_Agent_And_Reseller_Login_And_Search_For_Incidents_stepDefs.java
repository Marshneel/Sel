package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.NxTier.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by RajeshG on 01/06/2017.
 */
public class NA149_SDSK_CP_Agent_And_Reseller_Login_And_Search_For_Incidents_stepDefs {

    WebModel webModel=new WebModel();

    @When("^I navigate to service desk page and provide relevant info as a CP$")
    public void iNavigateToServiceDeskPageAndProvideRelevantInfoAsACP() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update incidents set site_id ='166',company_id='138'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set defServiceLevel_id='1' where name='business customer created by CP'");
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByShortName("CP");
        webModel.getServiceDeskPage().clickOnResult("CP");
    }
    @Then("^I should be able to search and find incidents relevant to CP$")
    public void iShouldBeAbleToSearchAndFindIncidentsRelevantToCP()  {
        webModel.getServiceDeskPage().assertAccountDetails("business customer created by CP");
        webModel.getServiceDeskPage().assertIncidents("Customer has moved and would like address updated");
        webModel.getServiceDeskPage().assertIncidents("Slow connection speed");
        webModel.getServiceDeskPage().assertIncidents("Changed bank and need new dd");
}

    @When("^I navigate to service desk page and provide relevant info as an agent$")
    public void iNavigateToServiceDeskPageAndProvideRelevantInfoAsAnAgent() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update incidents set site_id ='167',company_id='139'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set defServiceLevel_id='1' where name='business customer agent assigned'");
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByShortName("agent");
        webModel.getServiceDeskPage().clickOnResult("business customer agent assigned");
    }

    @Then("^I should be able to search and find incidents relevant to agent$")
    public void iShouldBeAbleToSearchAndFindIncidentsRelevantToAgent() {
        webModel.getServiceDeskPage().assertAccountDetails("business customer agent assigned");
        webModel.getServiceDeskPage().assertIncidents("Customer has moved and would like address updated");
        webModel.getServiceDeskPage().assertIncidents("Slow connection speed");
        webModel.getServiceDeskPage().assertIncidents("Changed bank and need new dd");
    }

    @When("^I navigate to service desk page and provide relevant info as a reseller$")
    public void iNavigateToServiceDeskPageAndProvideRelevantInfoAsAReseller() throws UnsupportedEncodingException, SQLException, ClassNotFoundException, InterruptedException {
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update incidents set site_id ='168',company_id='109'");
        webModel.getUtils().sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update company set defServiceLevel_id='1' where ID='109'");
        webModel.getDashBoardPage().loadServiceDesk("/nxtiere2e");
        webModel.getServiceDeskPage().assertTextOnServiceDesk();
        webModel.getServiceDeskPage().searchByShortName("site called business customer");
        webModel.getServiceDeskPage().clickOnResult("site called business customer");
    }

    @Then("^I should be able to search and find incidents relevant to reseller$")
    public void iShouldBeAbleToSearchAndFindIncidentsRelevantToReseller(){
        webModel.getServiceDeskPage().assertSiteUnderAccountDetails("business customer reseller");
        webModel.getServiceDeskPage().assertAccountDetails("reseller");
        webModel.getServiceDeskPage().assertIncidents("Customer has moved and would like address updated");
        webModel.getServiceDeskPage().assertIncidents("Slow connection speed");
        webModel.getServiceDeskPage().assertIncidents("Changed bank and need new dd");
    }


}
