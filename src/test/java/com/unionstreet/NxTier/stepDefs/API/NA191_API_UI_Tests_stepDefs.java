package com.unionstreet.NxTier.stepDefs.API;

import com.unionstreet.support.ElementUtils;
import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.JSONObject;

import java.sql.SQLException;

import static com.unionstreet.com.unionstreet.NxTier.pages.OrdersManagerPage.QUOTE_RanName;

/**
 * Created by rajeshg on 14/09/2017.
 */


public class NA191_API_UI_Tests_stepDefs {

    WebModel webModel=new WebModel();
    private String randomCompanyName;
    private String siteIDfromResponse;

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



}

