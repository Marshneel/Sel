package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class NewBusinessCustomerPage {
    public static String RanName;
    public final String ADD_BUTTON = "Add";
    //TODO
    public final String SAVE_BUTTON = ".save";
    public final String SAVEDMESSAGE_INFO = "Message_Info";
    public final String CONTACTMANAGER_BUTTON = "HrefContactManager";
    private final String COMPANYNAME_FIELD = "DCompany_name";
    private final String SITENAME_FIELD = "DSiteDetails_SiteName";
    private final String SHORTNAME_FIELD = "DSiteDetails_ShortName";
    private final String FIRSTNAME = "DSiteContact_christian";
    private final String EMAIL_FIELD = "DSiteContact_EMail";
    private final String CONTACTTYPE_AGENT = "//label[@for='DCompany_Is_Agent']";
    private final String CONTACTTYPE_RESELLER = "//label[@for='DCompany_is_reseller']";
    private final String VATPOPUP = "//span[@class='ui-button-text'][contains(text(),'Yes')]";
    ElementUtils utils = new ElementUtils();

    public void clickContactManagerButton() {
        utils.clickBtn(By.id(CONTACTMANAGER_BUTTON));
    }

    public void clickAddNewCustomerButton() {
        try {
            utils.clickBtn(By.linkText(ADD_BUTTON));

            utils.switchToNewWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void companyInfoForNewBusinessCustomer() {
        try {
            utils.clickBtnWithWait(By.id(COMPANYNAME_FIELD));
            RanName = utils.randomName();
            utils.sendText(By.id(COMPANYNAME_FIELD), RanName);
            utils.clickBtn(By.xpath(CONTACTTYPE_AGENT));
            utils.jumpToPopUpWindow(By.xpath(CONTACTTYPE_RESELLER));
            utils.clickBtn(By.xpath(VATPOPUP));


        } catch (Exception e) {
        }
    }

    public void addCompanyInfoForNewBusinessCustomerCreatedWithDefaultContactTypes() {
        utils.clickBtnWithWait(By.id(COMPANYNAME_FIELD));
        RanName = utils.randomName();
        utils.sendText(By.id(COMPANYNAME_FIELD), RanName);


    }

    public void addSiteInfoForNewBusinessCustomer() {
        try {
            utils.clickBtn(By.id(SITENAME_FIELD));
            utils.sendText(By.id(SITENAME_FIELD), utils.getProperty("siteName"));
            utils.sendText(By.id(SHORTNAME_FIELD), utils.getProperty("shortName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSiteContactInfoForNewBusinessCustomer() {
        try {
            utils.clickBtn(By.id(FIRSTNAME));
            utils.sendText(By.id(FIRSTNAME), utils.getProperty("firstName"));
            utils.sendText(By.id(EMAIL_FIELD), utils.getProperty("email"));
            utils.clickBtn(By.cssSelector(SAVE_BUTTON));
            utils.verifyStringMatch(By.id(SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
            utils.closeCurrentPage();
            utils.switchToParentWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}