package com.unionstreet.NxTier_smokePack.pages;

import com.unionstreet.NxTier_smokePack.support.ElementUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static com.unionstreet.NxTier_smokePack.support.BaseClass.driver;

public class NewBusinessCustomerPage {
    public static String RanName;
    public final String ADD_BUSINESSCUSTOMER_CLI_SERVICE_CHARGES_BUTTON = "Add";
    //TODO
    public final String SAVE_BUTTON = ".save";
    public final String SAVEDMESSAGE_INFO = "Message_Info";
    public final String CONTACTMANAGER_BUTTON = "HrefContactManager";
    private final String COMPANYNAME_FIELD = "DCompany_name";
    private final String SITENAME_FIELD = "DSiteDetails_SiteName";
    private final String SHORTNAME_FIELD = "DSiteDetails_ShortName";
    private final String FIRSTNAME = "DSiteContact_christian";
    private final String EMAIL_FIELD = "DSiteContact_EMail";
    ElementUtils utils = new ElementUtils();

    public void clickContactManagerButton() {
        utils.clickBtn(By.id(CONTACTMANAGER_BUTTON));
    }

    public void onAddNewBusinessCustomerPage() {
        utils.clickBtn(By.linkText(ADD_BUSINESSCUSTOMER_CLI_SERVICE_CHARGES_BUTTON));
        utils.switchToNewWindow();
    }

    public void companyInfoForNewBusinessCustomer() {
        RanName = RandomStringUtils.randomAlphabetic(8);
        utils.sendText(By.id(COMPANYNAME_FIELD), RanName);
    }

    public void siteInfoForNewBusinessCustomer() {
        try {
            utils.sendText(By.id(SITENAME_FIELD), utils.getProperty("siteName"));
            utils.sendText(By.id(SHORTNAME_FIELD), utils.getProperty("shortName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void siteContactInfoForNewBusinessCustomer() {
        try {
            utils.sendText(By.id(FIRSTNAME), utils.getProperty("firstName"));
            utils.sendText(By.id(EMAIL_FIELD), utils.getProperty("email"));
            utils.clickBtn(By.cssSelector(SAVE_BUTTON));
            utils.verifyStringMatch(By.id(SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
            driver.close();
            driver.switchTo().window(utils.parentWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}