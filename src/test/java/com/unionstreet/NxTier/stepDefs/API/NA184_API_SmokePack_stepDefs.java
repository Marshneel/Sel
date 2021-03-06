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


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rajeshg on 01/09/2017.
 */
public class NA184_API_SmokePack_stepDefs {

WebModel webModel=new WebModel();
    private String siteIDfromQueryCrude;
    private String siteIDfromResponse;
    int siteIDfromQueryInteger;
    String randomSiteName;


    @Given("^I make an API GET request call for sites$")
    public void iMakeAnAPIGETRequestCallForSites() {

webModel.getRestServices().executeGetRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/site");
    }

    @Then("^I should be able to see the response (\\d+)$")
    public void iShouldBeAbleToSeeTheResponse( int actualCode) throws Exception {
        assertThat(webModel.getRestServices().response.statusCode(), is(actualCode));
    }

    @Given("^I make an invalid API GET request call for sites$")
    public void iMakeAnInvalidAPIGETRequestCallForSites()  {
        webModel.getRestServices().executeGetRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/sites");

    }

    @Given("^I make a valid POST request to create a site")
    public void iMakeAValidPOSTRequestToCreateASite() throws SQLException {
        JSONObject createSitePayload = new ElementUtils().getPayload("newSite");
        randomSiteName=webModel.getUtils().randomName();
        createSitePayload.replace("ShortName",randomSiteName);
        webModel.getRestServices().executePostRequest(createSitePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/site");
        siteIDfromResponse=webModel.getRestServices().response.path("Id").toString();
        siteIDfromQueryCrude=webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where ShortName='"+randomSiteName+"'");
        webModel.getUtils().result.next();
        String siteIDfromQueryString =  webModel.getUtils().result.getString("SiteID");
        siteIDfromQueryInteger =  webModel.getUtils().result.getInt(1);
        assertThat(siteIDfromResponse,is(siteIDfromQueryString));



    }

    @And("^when I delete the newly created site$")
    public void whenIDeleteTheNewlyCreatedSite() {
        webModel.getRestServices().executeDeleteRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/site/"+siteIDfromQueryInteger+"");
    }

    @And("^I should be able to assert site deletion$")
    public void iShouldBeAbleToAssertSiteDeletion() throws SQLException {
        siteIDfromQueryCrude=webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where ShortName='"+randomSiteName+"'");
        webModel.getUtils().result.next();
     try {
         webModel.getUtils().result.getString("SiteID");
     }catch (SQLException e){
         System.out.println(" no result");
     }
    }

    @Given("^I make a valid PATCH request to update an existing site details$")
    public void iMakeAValidPATCHRequestToUpdateAnExistingSiteDetails()  {
        JSONObject updateCompanyPayload = new ElementUtils().getPayload("updateSiteDetailsInFull");
        randomSiteName=webModel.getUtils().randomName();
        updateCompanyPayload.replace("SiteName",randomSiteName);
        updateCompanyPayload.replace("ShortName",randomSiteName);
        webModel.getRestServices().executePATCHRequest(updateCompanyPayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/site/10");

    }

    @And("^I should be able to assert the updated site details$")
    public void iShouldBeAbleToAssertTheUpdatedSiteDetails() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
    webModel.getUtils().sqlQuery("portal", "test01-sql01", "NxtierE2E", "select ShortName from Sitedetails where SiteName='"+randomSiteName+"'");
        webModel.getUtils().result.next();
        String shortName= webModel.getUtils().result.getString("ShortName");
        Assert.assertEquals(shortName,randomSiteName);
        webModel.getUtils().sqlQuery("portal", "test01-sql01", "NxtierE2E", "select SiteID from Sitedetails where SiteName='"+randomSiteName+"'");
        webModel.getUtils().result.next();
        String SiteID= webModel.getUtils().result.getString("SiteID");
        Assert.assertEquals(SiteID,"10");
    }
}
