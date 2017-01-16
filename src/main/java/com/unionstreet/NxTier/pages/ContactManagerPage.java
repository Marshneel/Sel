package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class ContactManagerPage {

    public final String SEARCH_BUTTON = "txtsearch";
    public final String CREATEQUOTE_SELECTCOMPANY = "CompanyId";
    public final String CREATEQUOTE_SELECTSITE = "SiteId";

    private final String COMPANYDETAILS_BUTTON = "HrefCompanyDetails";
    private final String COMPANYSITES = "HrefCompanySites";
    private final String CHANNELDETAILS_AGENT = "DAgentCommission_agent_id";

    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CommonMethods commonMethods = new CommonMethods();
    AddSiteDetailsPage addSiteDetails = new AddSiteDetailsPage();


    public void assertNewBusinessCustomer() {

        newBusinessCustomerPage.clickContactManagerButton();
        utils.sendText(By.id(SEARCH_BUTTON), newBusinessCustomerPage.RanName);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.verifyStringMatch(By.linkText(newBusinessCustomerPage.RanName), newBusinessCustomerPage.RanName);
    }

    public void clickCompanySite() {
        utils.waitForElementVisible(By.id(COMPANYSITES));
        utils.clickBtn(By.id(COMPANYSITES));
    }

    public void clickOnResellerUnderCustomerDetails() throws InterruptedException {

        commonMethods.search("reseller");
        utils.waitForElementVisible(By.linkText("reseller"));
        utils.clickBtn(By.linkText("reseller"));
        utils.switchToNewWindow();
    }


    public void assertNewlyCreatedSiteByResellerOnQuotePage() {
        utils.selectByVisibleText(By.id(CREATEQUOTE_SELECTCOMPANY), "reseller");
        utils.selectByVisibleText(By.id(CREATEQUOTE_SELECTSITE), addSiteDetails.Reseller_RanName);
    }

    public void searchForBusinessCustomer(String customer_name) throws InterruptedException {
        utils.sendText(By.id(SEARCH_BUTTON), customer_name);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.waitForElementVisible(By.xpath("//a[text()='" + customer_name + "']"));
        utils.clickBtn(By.xpath("//a[text()='" + customer_name + "']"));
        utils.switchToNewWindow();
    }

    public void assignAnAgentForBC() {
        utils.waitForElementVisible(By.id(COMPANYDETAILS_BUTTON));
        utils.clickBtn(By.id(COMPANYDETAILS_BUTTON));
        utils.selectByVisibleText(By.id(CHANNELDETAILS_AGENT), "agent");
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.switchToParentWindow();
        utils.getOrdersPage();
    }

}