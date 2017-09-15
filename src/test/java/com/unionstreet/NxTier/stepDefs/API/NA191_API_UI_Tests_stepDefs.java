package com.unionstreet.NxTier.stepDefs.API;

import com.unionstreet.NxTier.stepDefs.WLR3.NA44_Agent_Login_stepDefs;
import com.unionstreet.support.ElementUtils;
import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static com.unionstreet.com.unionstreet.NxTier.pages.OrdersManagerPage.QUOTE_RanName;

/**
 * Created by rajeshg on 14/09/2017.
 */


public class NA191_API_UI_Tests_stepDefs {

    NA44_Agent_Login_stepDefs na44=new NA44_Agent_Login_stepDefs();
    WebModel webModel=new WebModel();
    private String randomCompanyName;
    private String siteIDfromResponse;
    private String randomCLI;
    private String siteIDfromQuery;

    @Given("^I am POST a company and a siteContact$")
    public void iAmPOSTACompanyAndASiteContact()  {
        JSONObject createSitePayload = new ElementUtils().getPayload("newCompany");
        randomCompanyName=webModel.getUtils().randomName();
        createSitePayload.replace("CompanyName",randomCompanyName);
        createSitePayload.replace("SiteShortName",randomCompanyName);
        webModel.getRestServices().executePostRequest(createSitePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/company");
        siteIDfromResponse=webModel.getRestServices().response.path("SiteId").toString();
        JSONObject createContactPayload = new ElementUtils().getPayload("newSiteContact");
       int siteID=Integer.parseInt(siteIDfromResponse);
        createContactPayload.replace("SiteID",siteID);
        webModel.getRestServices().executePostRequest(createContactPayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/sitecontact");
    }

    @When("^I navigate to the orders manager page and access create quote popup$")
    public void iNavigateToTheOrdersManagerPageAndAccessCreateQuotePopup() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getOrdersManagerPage().clickCreateQuoteButton();
    }

    @Then("^I should be able to select the company and contact that was earlier created by API$")
    public void iShouldBeAbleToSelectTheCompanyAndContactThatWasEarlierCreatedByAPI() throws InterruptedException, SQLException {
        webModel.getOrdersManagerPage().createQuote(randomCompanyName);
        webModel.getOrdersManagerPage().searchQuoteByBcRN(randomCompanyName);

    }

    @And("^I should be able to see the site contact auto populated by the contact posted by the API$")
    public void iShouldBeAbleToSeeTheSiteContactAutoPopulatedByTheContactPostedByTheAPI() throws SQLException, InterruptedException {
        webModel.getOrdersManagerPage().loadOrdersManagerAndClickOnQuoteID(webModel.getOrdersManagerPage().QUOTE_RanName);
        webModel.getAddServicePage().searchAndAddService("New Provide Order",QUOTE_RanName);
        webModel.getWlr3_new_provide__orderPage().clickAnalogueMultilineTab();
        webModel.getWlr3_new_provide__orderPage().assertAPIpostedSiteContact();
    }


    @Given("^I am logged in as CP and there is a business customer already created$")
    public void iAmLoggedInAsCPAndThereIsABusinessCustomerAlreadyCreated() throws InterruptedException {
        webModel.getLoginPage().doLogin();
        na44.haveCreatedANewCustomer();

    }

    @When("^I POST a CLI for the site$")
    public void iPOSTACLIForTheSite() throws SQLException {
        JSONObject createCLIPayload = new ElementUtils().getPayload("newCLI");
        randomCLI=webModel.getUtils().randomNumber();
        siteIDfromQuery=webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where SiteName='"+webModel.getNewBusinessCustomerPage().RanName+"'");
        webModel.getUtils().result.next();
       int siteIDfromQueryInteger = webModel.getUtils().result.getInt(1);
        createCLIPayload.replace("SiteId",siteIDfromQueryInteger);
        createCLIPayload.replace("CLI",randomCLI);
        String startDate=webModel.getUtils().getCurrentDate("yyyy/MM/dd");
        createCLIPayload.replace("StartDate",webModel.getUtils().getCurrentDate(startDate)+"T00:00:00.00");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String endDate=dateFormat.format(webModel.getServiceDesk_ticketDetailsPage().IfSaturday(true));
        createCLIPayload.replace("EndDate",webModel.getUtils().getCurrentDate(endDate)+"T00:00:00.00");
        webModel.getRestServices().executePostRequest(createCLIPayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/CLI");
    }

    @Then("^I should be able to verify the newly posted CLI$")
    public void iShouldBeAbleToVerifyTheNewlyPostedCLI() throws SQLException, InterruptedException {
        webModel.getCompanyMenuPage().assertCreatedCLI(webModel.getNewBusinessCustomerPage().RanName,randomCLI);



    }
}

