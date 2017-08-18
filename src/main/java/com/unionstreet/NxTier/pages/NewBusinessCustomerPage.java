package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class NewBusinessCustomerPage {
    public static String RanName;
    public static String Reseller_RanName;
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
    private final String CONTACTTYPE_AGENT = "//label[@for='DCompany_is_agent']";
    private final String CONTACTTYPE_RESELLER = "//label[@for='DCompany_is_reseller']";
    private final String VATPOPUP = "//span[@class='ui-button-text'][contains(text(),'Yes')]";
    public final String CHANNELDETAILS_AGENT = "DAgentCommission_agent_id";
    private final String TELEPHONY_CUSTOMER_CHECKBOX="DCompany_is_customer";

    ElementUtils utils = new ElementUtils();

    public void clickContactManagerButton() {
        utils.waitForElementVisible(By.id(CONTACTMANAGER_BUTTON));
        utils.clickBtn(By.id(CONTACTMANAGER_BUTTON));
    }

    public void clickAddNewCustomerButton() throws InterruptedException {
        try {
            utils.waitForElementVisible(By.linkText(ADD_BUTTON));
        } catch (Exception e) {
            utils.getCreateCustomerPage();
        }
        utils.waitForElementToBeClickable(By.linkText(ADD_BUTTON));
        utils.clickBtn(By.linkText(ADD_BUTTON));
        utils.switchToNewWindow();
    }

    public void companyInfoForNewBusinessCustomer() {
        RanName = utils.randomName();
        try {
            utils.clickBtn(By.id(COMPANYNAME_FIELD));
            utils.sendText(By.id(COMPANYNAME_FIELD),RanName);
        } catch (Exception e) {
            utils.getCreateCustomerPage();
            utils.waitForElementVisible(By.linkText(ADD_BUTTON));
            utils.clickBtn(By.linkText(ADD_BUTTON));
            utils.switchToNewWindow();
            utils.sendText(By.id(COMPANYNAME_FIELD),RanName);
        }}
    public void createContactType(){
    utils.waitForElementVisible(By.id(TELEPHONY_CUSTOMER_CHECKBOX));
        utils.makeSureBoxIsUnChecked(By.id(TELEPHONY_CUSTOMER_CHECKBOX),By.id(TELEPHONY_CUSTOMER_CHECKBOX));
        utils.clickBtn(By.xpath(CONTACTTYPE_AGENT));

    }
    public void validationMessage_whenAgentAndResellerCheckedIn(){
         utils.jumpToPopUpWindow(By.xpath(CONTACTTYPE_RESELLER));
        utils.clickBtn(By.xpath(VATPOPUP));
        utils.waitForElementVisible(By.xpath(CONTACTTYPE_AGENT));
        utils.clickBtn(By.xpath(CONTACTTYPE_AGENT));
      try{  utils.waitForElementVisible(By.xpath("//span[contains(text(),'Cannot Be Agent And Reseller')]"));

    }catch (Exception e){
          System.out.println("Business customer cannot be agent and reseller at once");
      }}

    public void addCompanyInfoForNewBusinessCustomerCreatedWithDefaultContactTypes() {
        RanName = utils.randomName();
        utils.clickBtn(By.id(COMPANYNAME_FIELD));
        try {
            utils.sendText(By.id(COMPANYNAME_FIELD),RanName);
        } catch (Exception e) {
            utils.sendText(By.id(COMPANYNAME_FIELD),RanName);
        }
    }

    public void addSiteInfoForNewBusinessCustomer() {
        utils.clickBtn(By.id(SITENAME_FIELD));
        utils.sendText(By.id(SITENAME_FIELD),RanName);
        utils.sendText(By.id(SHORTNAME_FIELD),utils.getProperty("shortName"));
    }

    public void addSiteContactInfoForNewBusinessCustomer() throws InterruptedException {
        utils.clickBtn(By.id(FIRSTNAME));
        utils.sendText(By.id(FIRSTNAME),utils.getProperty("firstName"));
        utils.sendText(By.id(EMAIL_FIELD),utils.getProperty("email"));
        utils.clickBtn(By.cssSelector(SAVE_BUTTON));
       Thread.sleep(1000);
        utils.scrollUp(By.xpath("//a[text()[contains(.,'Contact Manager')]]"));
       // utils.verifyStringMatch(By.id(SAVEDMESSAGE_INFO), utils.getProperty("savedMessage"));
        utils.waitForElementVisible(By.xpath("//span[text()[contains(.,'Saved Successfully')]]"));
        utils.closeCurrentPage();
        utils.switchToPreviousWindow(0);
    }
}
