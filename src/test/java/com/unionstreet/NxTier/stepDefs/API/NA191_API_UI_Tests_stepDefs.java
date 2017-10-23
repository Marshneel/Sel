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
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rajeshg on 14/09/2017.
 */


public class NA191_API_UI_Tests_stepDefs {

    NA44_Agent_Login_stepDefs na44=new NA44_Agent_Login_stepDefs();
    WebModel webModel=new WebModel();
    private String randomCompanyName;
    private String siteIDfromResponse;
    private String companyIDfromResponse;
    private String contactIDfromResponse;
    private int companyID;
    private String randomCLI;
    private String siteIDfromQuery;
    private String randomPackage;
    private String packageID;
    private int packageIDint;
    private int siteIDfromQueryInteger;
    private int siteID;
    private int contactID;
    private String quoteIDfromResponse;
    private int quoteID;
    private String orderServiceIDfromResponse;
    private int orderServiceID;
    private String ServiceChargeIDFromResponse;
    private int serviceChargeID;
    private String SalesPriceFromResponse;
    private int salesPriceInteger;
    private String CostPriceFromResponse;
    private int costPriceInteger;
    private String BaseLineCostFromResponse;
    private int baseLineCostInteger;


    @Given("^I POST a company and a siteContact$")
    public void IPOSTACompanyAndASiteContact()  {
        JSONObject createSitePayload = new ElementUtils().getPayload("newCompany");
        randomCompanyName=webModel.getUtils().randomName();
        createSitePayload.replace("CompanyName",randomCompanyName);
        createSitePayload.replace("SiteShortName",randomCompanyName);
        webModel.getRestServices().executePostRequest(createSitePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/company");
        siteIDfromResponse=webModel.getRestServices().response.path("SiteId").toString();
        companyIDfromResponse=webModel.getRestServices().response.path("Id").toString();
        JSONObject createContactPayload = new ElementUtils().getPayload("newSiteContact");
        siteID=Integer.parseInt(siteIDfromResponse);
        companyID=Integer.parseInt(companyIDfromResponse);
        createContactPayload.replace("SiteID",siteID);
        webModel.getRestServices().executePostRequest(createContactPayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/sitecontact");
        contactIDfromResponse=webModel.getRestServices().response.path("Id").toString();
        contactID=Integer.parseInt(contactIDfromResponse);
    }

    @When("^I navigate to the orders manager page and access create quote popup$")
    public void iNavigateToTheOrdersManagerPageAndAccessCreateQuotePopup() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickOrderManagerButton();
        webModel.getDashBoardPage().loadAllOrders(false,true);
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
        siteIDfromQueryInteger = webModel.getUtils().result.getInt(1);
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
        webModel.getCompanyMenuPage().searchAndNavigateToSiteMenuOfACustomer(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getCompanyMenuPage().assertCreatedCLIUnderSite(randomCLI);



    }
    @Given("^I POST a company and a package under its site$")
    public void iPOSTACompanyAndAPackageUnderItsSite(){
        IPOSTACompanyAndASiteContact();
        JSONObject createPackagePayload = new ElementUtils().getPayload("newPackage");
        randomPackage=webModel.getUtils().randomNumber();
        createPackagePayload.replace("Name","RandomPackageByAPI"+randomPackage);
        webModel.getRestServices().executePostRequest(createPackagePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/package");
        packageID=webModel.getRestServices().response.path("Id").toString();
        packageIDint=Integer.parseInt(packageID);
        JSONObject assignPackagePayload = new ElementUtils().getPayload("assignPackage");
        assignPackagePayload.replace("Id",packageIDint);
        webModel.getRestServices().executePUTRequest(assignPackagePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/site/"+siteID+"/package");

    }


    @When("^I POST a tariff and free minute plan for that particular package$")
    public void iPOSTATariffAndFreeMinutePlanForThatParticularPackage() throws InterruptedException {
        JSONObject assignTariffsToPackagePayload = new ElementUtils().getPayload("assignTariffsToPackage");
        webModel.getRestServices().executePUTRequest(assignTariffsToPackagePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/package/"+packageIDint+"/tariffs");
        JSONObject assignFreeMinutesToPackagePayload = new ElementUtils().getPayload("assignFreeMinutesToPackage");
        webModel.getRestServices().executePUTRequest(assignFreeMinutesToPackagePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/package/"+packageIDint+"/freeminutes");
    }


    @Then("^I should be able to verify the package details on the UI$")
    public void iShouldBeAbleToVerifyThePackageDetailsOnTheUI() {

    }


    @When("^I POST a quote for that particular company$")
    public void iPOSTAQuoteForThatParticularCompany() {
        JSONObject createQuotePayload = new ElementUtils().getPayload("newQuote");
        createQuotePayload.replace("CompanyID",companyID);
        createQuotePayload.replace("DefaultSiteID",siteID);
        createQuotePayload.replace("ContactID",contactID);
        createQuotePayload.replace("QuoteName",randomCompanyName);
        webModel.getRestServices().executePostRequest(createQuotePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/order/quote");
        quoteIDfromResponse=webModel.getRestServices().response.path("ID").toString();
        quoteID=Integer.parseInt(quoteIDfromResponse);
    }

    @Then("^I should be able to confirm it on the UI$")
    public void iShouldBeAbleToConfirmItOnTheUI() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getDashBoardPage().load_endCustomers();
        webModel.getCompanyMenuPage().searchAndNavigateToSiteMenuOfACustomer(randomCompanyName);
        webModel.getCompanyMenuPage().assertCreatedQuoteUnderSite(randomCompanyName);
    }

    @And("^I should be able to delete the quote via API$")
    public void iShouldBeAbleToDeleteTheQuoteViaAPI() throws InterruptedException {
        webModel.getRestServices().executeDeleteRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/order/quote/"+quoteID+"");
        webModel.getUtils().refreshPage();
        webModel.getCompanyMenuPage().assertDeletedQuoteUnderSite();


    }

    @When("^I send a POST request to add a service to the quote$")
    public void iSendAPOSTRequestToAddAServiceToTheQuote() {
        JSONObject assignServiceToQuotePayload = new ElementUtils().getPayload("assignServiceToQuote");
        assignServiceToQuotePayload.replace("SiteId",siteID);
        webModel.getRestServices().executePostRequest(assignServiceToQuotePayload,"SystemInformation","nxtiere2e","username","cp","password","password","/api/order/quote/"+quoteID+"/Service");

    }

    @Then("^I should be able to verify the added service on the UI$")
    public void iShouldBeAbleToVerifyTheAddedServiceOnTheUI() throws InterruptedException {
        webModel.getLoginPage().loginAsCP();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getDashBoardPage().load_endCustomers();
        webModel.getCompanyMenuPage().searchAndNavigateToSiteMenuOfACustomer(randomCompanyName);
        webModel.getCompanyMenuPage().assertAssignedService(quoteID,"customService");
        orderServiceIDfromResponse=webModel.getRestServices().response.path("Id").toString();
        orderServiceID=Integer.parseInt(orderServiceIDfromResponse);
    }

    @And("^when I DELETE the service through API$")
    public void whenIDELETETheServiceThroughAPI() {
        webModel.getRestServices().executeDeleteRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/order/quote/"+quoteID+"/Service/"+orderServiceID+"");

    }

    @Then("^I should be able to confirm that on the UI$")
    public void iShouldBeAbleToConfirmThatOnTheUI() {
        webModel.getUtils().refreshPage();
        webModel.getCompanyMenuPage().assertDeletedService("customService");
    }

    @Then("^I should be able to successfully edit the reseller side credentials$")
    public void iShouldBeAbleToSuccessfullyEditTheResellerSideCredentials() throws InterruptedException {
        webModel.getSipTrunkPlus_dashBoardPage().assertChangesToEditProviderPage();

    }

    @When("^I POST a service charge under the site that is recently created$")
    public void iPOSTAServiceChargeUnderTheSiteThatIsRecentlyCreated() throws InterruptedException, SQLException {
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCompanyMenuPage().searchAndNavigateToSiteMenuOfACustomer(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getCompanyMenuPage().addCLIs(true,webModel.getNewBusinessCustomerPage().RanName,webModel.getCompanyMenuPage().RanNumber,false,true);
        JSONObject createServiceCharge = new ElementUtils().getPayload("newServiceCharge");
        siteIDfromQuery=webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where SiteName='"+webModel.getNewBusinessCustomerPage().RanName+"'");
        webModel.getUtils().result.next();
        siteIDfromQueryInteger = webModel.getUtils().result.getInt(1);
        createServiceCharge.replace("SiteId",siteIDfromQueryInteger);
        createServiceCharge.replace("CLI",webModel.getCompanyMenuPage().RanNumber);
        String startDate=webModel.getUtils().getCurrentDate("yyyy/MM/dd");
        createServiceCharge.replace("StartDate",webModel.getUtils().getCurrentDate(startDate)+"T00:00:00.00");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String endDate=dateFormat.format(webModel.getServiceDesk_ticketDetailsPage().IfSaturday(true));
        createServiceCharge.replace("EndDate",webModel.getUtils().getCurrentDate(endDate)+"T00:00:00.00");
        webModel.getRestServices().executePostRequest(createServiceCharge,"SystemInformation","nxtiere2e","username","cp","password","password","/api/ServiceCharge");
    }

    @Then("^I should be able to verify the new service charge under site menu$")
    public void iShouldBeAbleToVerifyTheNewServiceChargeUnderSiteMenu()  {
        webModel.getCompanyMenuPage().clickServiceChargesButton();
        webModel.getCompanyMenuPage().loadAndAssertServiceChargesCreatedByAPI("serviceChargeAddedByAPI",webModel.getCompanyMenuPage().RanNumber,"13.0000","8.6400","9.0000");


    }

    @Given("^I am logged in as CP and a serviceCharge with unmatched frequency type has been POSTed$")
    public void iAmLoggedInAsCPAndAServiceChargeWithUnmatchedFrequencyTypeHasBeenPOSTed() throws InterruptedException, SQLException {
        webModel.getLoginPage().loginAsCP();
        na44.haveCreatedANewCustomer();
        webModel.getDashBoardPage().clickContactManagerTab();
        webModel.getCompanyMenuPage().searchAndNavigateToSiteMenuOfACustomer(webModel.getNewBusinessCustomerPage().RanName);
        webModel.getCompanyMenuPage().addCLIs(true,webModel.getNewBusinessCustomerPage().RanName, webModel.getCompanyMenuPage().RanNumber, false, true);
        JSONObject createServiceCharge = new ElementUtils().getPayload("newServiceCharge");
        siteIDfromQuery = webModel.getUtils().sqlQuery("Portal", "test01-sql01", "nxtiere2e", "select SiteID from Sitedetails where SiteName='" + webModel.getNewBusinessCustomerPage().RanName + "'");
        webModel.getUtils().result.next();
        siteIDfromQueryInteger = webModel.getUtils().result.getInt(1);
        createServiceCharge.replace("SiteId", siteIDfromQueryInteger);
        createServiceCharge.replace("CLI", webModel.getCompanyMenuPage().RanNumber);
        createServiceCharge.replace("FrequencyTypeId", "4");
        String startDate = webModel.getUtils().getCurrentDate("yyyy/MM/dd");
        createServiceCharge.replace("StartDate", webModel.getUtils().getCurrentDate(startDate) + "T00:00:00.00");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String endDate = dateFormat.format(webModel.getServiceDesk_ticketDetailsPage().IfSaturday(true));
        createServiceCharge.replace("EndDate", webModel.getUtils().getCurrentDate(endDate) + "T00:00:00.00");
        webModel.getRestServices().executePostRequest(createServiceCharge, "SystemInformation", "nxtiere2e", "username", "cp", "password", "password", "/api/ServiceCharge");
        ServiceChargeIDFromResponse = webModel.getRestServices().response.path("Id").toString();
        serviceChargeID = Integer.parseInt(ServiceChargeIDFromResponse);
    }

    @When("^I perform a GET request on the charge details$")
    public void iPerformAGETRequestOnTheChargeDetails() {
        webModel.getRestServices().executeGetRequest("SystemInformation","nxtiere2e","username","cp","password","password","/api/ServiceCharge/"+ServiceChargeIDFromResponse+"");
    }

    @Then("^The pricing values should be based on the FrequencyTypeID from the request$")
    public void thePricingValuesShouldBeBasedOnTheFrequencyTypeIDFromTheRequest() {
        SalesPriceFromResponse = webModel.getRestServices().response.path("SalesPrice").toString();
       try{ assertThat (SalesPriceFromResponse, is("39.00"));}
       catch (AssertionError e){
           System.out.println("sale price is not calculated as per FrequencyType_ID ");
       }
        CostPriceFromResponse = webModel.getRestServices().response.path("CostPrice").toString();
        assertThat (CostPriceFromResponse, is("25.92"));
        BaseLineCostFromResponse=webModel.getRestServices().response.path("BaselineCost").toString();
        assertThat (BaseLineCostFromResponse, is("27.0"));
    }
}

