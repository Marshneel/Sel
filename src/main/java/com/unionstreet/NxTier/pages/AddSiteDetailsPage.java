package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 16/01/2017.
 */
public class AddSiteDetailsPage {

    public static String Reseller_RanName;
    public final String HOMEPAGE_BUTTON = "//span[@title='Home']";
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    CommonMethods commonMethods = new CommonMethods();


    public void addNewSiteForReseller() throws InterruptedException {
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.clickBtn(By.id(companyMenuPage.SITEDETAILS_SITE_NAME));
        Reseller_RanName = utils.randomName();
        utils.sendText(By.id(companyMenuPage.SITEDETAILS_SITE_NAME),Reseller_RanName);
        utils.clickBtn(By.id(companyMenuPage.SITEDETAILS_SHORT_NAME));
        utils.sendText(By.id(companyMenuPage.SITEDETAILS_SHORT_NAME),Reseller_RanName);
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
        utils.switchToParentWindow();
        utils.getDashBoardPage();
    }

    public void navigateToHomePage() {
        utils.clickBtn(By.xpath(HOMEPAGE_BUTTON));
    }


}
