package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import static com.unionstreet.NxTier.pages.NewBusinessCustomerPage.Reseller_RanName;

/**
 * Created by RajeshG on 16/01/2017.
 */
public class AddSiteDetailsPage {


    public final String HOMEPAGE_BUTTON = "//span[@title='Home']";
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    CommonMethods commonMethods = new CommonMethods();


    public void addNewSiteForReseller() throws InterruptedException {
        utils.waitForElementToBeClickable(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        //utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindowByJavaExeClick(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.clickBtn(By.id(companyMenuPage.SITEDETAILS_SITE_NAME));
        Reseller_RanName = utils.randomName();
        utils.sendText(By.id(companyMenuPage.SITEDETAILS_SITE_NAME), Reseller_RanName);
        utils.clickBtn(By.id(companyMenuPage.SITEDETAILS_SHORT_NAME));
        utils.sendText(By.id(companyMenuPage.SITEDETAILS_SHORT_NAME), Reseller_RanName);
        try {
            utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        } catch (Exception e) {
            utils.checkAlert();
        }
        utils.switchToParentWindow();
        utils.getDashBoardPage("/nxtiere2e");
    }

    public void navigateToHomePage() {
        utils.clickBtn(By.xpath(HOMEPAGE_BUTTON));
    }

    public void assignAddressKeyToSite() throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        utils.sqlExeQuery("Portal", "test01-sql01", "nxtiere2e", "update Sitedetails set bt_address_key='A00001043137', bt_address_key_type='Gold' where SiteName='" + newBusinessCustomerPage.RanName + "'");
    }


}
