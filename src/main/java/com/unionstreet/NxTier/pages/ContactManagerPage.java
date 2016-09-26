package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class ContactManagerPage {
    public final String SEARCH_BUTTON = "txtsearch";
    public final String CREATEQUOTE_SELECTCOMPANY = "CompanyId";
    public final String CREATEQUOTE_SELECTSITE = "SiteId";
    public final String HOMEPAGE_BUTTON="//span[@title='Home']";
    private final String COMPANYDETAILS_BUTTON="HrefCompanyDetails";
    private final String COMPANYSITES="HrefCompanySites";
    private final String CHANNELDETAILS_AGENT="DAgentCommission_agent_id";
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    CommonMethods commonMethods = new CommonMethods();
    private String newSiteName;


    public void assertNewBusinessCustomer() throws InterruptedException {
        try {
            newBusinessCustomerPage.clickContactManagerButton();
            utils.sendText(By.id(SEARCH_BUTTON), newBusinessCustomerPage.RanName);
            utils.keyBoardEnter(By.id(SEARCH_BUTTON));
            utils.verifyStringMatch(By.linkText(newBusinessCustomerPage.RanName), newBusinessCustomerPage.RanName);
        } catch (Exception e) {
        }
    }



    public void clickCompanySite() {
        utils.clickBtn(By.id(COMPANYSITES));

    }
    public void clickOnResellerUnderCustomerDetails(){
        commonMethods.search("reseller");
        utils.clickBtn(By.linkText("reseller"));
        utils.switchToNewWindow();
    }

    public void addNewSiteForReseller() {
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(companyMenuPage.SITEDETAILS_SITE_NAME));
        newSiteName = utils.randomName();
        utils.sendText(By.id(companyMenuPage.SITEDETAILS_SITE_NAME), newSiteName);
        utils.clickBtn(By.id(companyMenuPage.SITEDETAILS_SHORT_NAME));
        utils.sendText(By.id(companyMenuPage.SITEDETAILS_SHORT_NAME), newSiteName);
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToParentWindow();
    }

    public void navigateToHomePage() {
        utils.clickBtn(By.xpath(HOMEPAGE_BUTTON));

    }

    public void assertNewlyCreatedSiteByResellerOnQuotePage() throws InterruptedException {
        utils.selectByVisibleText(By.id(CREATEQUOTE_SELECTCOMPANY), "reseller");
        utils.selectByVisibleText(By.id(CREATEQUOTE_SELECTSITE), newSiteName);

    }

    public void searchForBusinessCustomer(String customer_name) {
        utils.sendText(By.id(SEARCH_BUTTON), customer_name);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.clickBtn(By.linkText(customer_name));
        utils.switchToNewWindow();

    }

    public void assignAnAgentForBC() throws InterruptedException {
        utils.clickBtn(By.id(COMPANYDETAILS_BUTTON));
        utils.selectByVisibleText(By.id(CHANNELDETAILS_AGENT), "agent");
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToParentWindow();


    }


}