package com.unionstreet.NxTier.stepDefs.API;

import com.unionstreet.support.ElementUtils;
import com.unionstreet.support.WebModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static com.unionstreet.support.BaseClass.utils;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rajeshg on 01/09/2017.
 */
public class NA184_API_SmokePack_stepDefs {

WebModel webModel=new WebModel();
    private String companyIDfromQueryCrude;
    private String companyIDfromResponse;
    int companyIDfromQueryInteger;
    String randomCompanyName;


    @Given("^I make an API GET request call for sites$")
    public void iMakeAnAPIGETRequestCallForSites() {

webModel.getRestServices().executeGetRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/site");
    }

    @Then("^I should be able to see the response (\\d+)$")
    public void iShouldBeAbleToSeeTheResponse( int actualCode)  {
        assertThat(webModel.getRestServices().response.statusCode(),is(actualCode));
    }

    @Given("^I make an invalid API GET request call for sites$")
    public void iMakeAnInvalidAPIGETRequestCallForSites()  {
        webModel.getRestServices().executeGetRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/sites");

    }

    @Given("^I make a valid POST request to create a company$")
    public void iMakeAValidPOSTRequestToCreateACompany() throws SQLException {
        JSONObject createCompanyPayload = new ElementUtils().getPayload("newCompany");
        randomCompanyName=webModel.getUtils().randomName();
        createCompanyPayload.replace("ShortName",randomCompanyName);
        webModel.getRestServices().executePostRequest(createCompanyPayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/site");
        companyIDfromResponse=webModel.getRestServices().response.path("Id").toString();
        companyIDfromQueryCrude=webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where ShortName='"+randomCompanyName+"'");
        webModel.getUtils().result.next();
        String companyIDfromQueryString = utils.result.getString("SiteID");
        companyIDfromQueryInteger = utils.result.getInt(1);
        assertThat(companyIDfromResponse,is(companyIDfromQueryString));



    }

    @And("^when I delete the newly created site$")
    public void whenIDeleteTheNewlyCreatedSite() {
        webModel.getRestServices().executeDeleteRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/site/"+companyIDfromQueryInteger+"");
    }

    @And("^I should be able to assert site deletion$")
    public void iShouldBeAbleToAssertSiteDeletion() throws SQLException {
        companyIDfromQueryCrude=webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where ShortName='"+randomCompanyName+"'");
        webModel.getUtils().result.next();
     try {
          utils.result.getString("SiteID");
     }catch (SQLException e){
         System.out.println(" no result");
     }
    }

    @Given("^I make a valid PUT request to update an existing company details$")
    public void iMakeAValidPUTRequestToUpdateAnExistingCompanyDetails()  {
        JSONObject updateCompanyPayload = new ElementUtils().getPayload("updateCompanyDetailsInFull");
        randomCompanyName=webModel.getUtils().randomName();
        updateCompanyPayload.replace("SiteName",randomCompanyName);
        updateCompanyPayload.replace("ShortName",randomCompanyName);
        webModel.getRestServices().executePUTRequest(updateCompanyPayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/site/10");

    }

    @And("^I should be able to assert the updated company details$")
    public void iShouldBeAbleToAssertTheUpdatedCompanyDetails() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
    webModel.getUtils().sqlQuery("portal", "test01-sql01", "NxtierE2E", "select ShortName from Sitedetails where SiteName='"+randomCompanyName+"'");
        webModel.getUtils().result.next();
        String shortName=utils.result.getString("ShortName");
        Assert.assertEquals(shortName,randomCompanyName);
        webModel.getUtils().sqlQuery("portal", "test01-sql01", "NxtierE2E", "select SiteID from Sitedetails where SiteName='"+randomCompanyName+"'");
        webModel.getUtils().result.next();
        String SiteID=utils.result.getString("SiteID");
        Assert.assertEquals(SiteID,"10");
    }
}
