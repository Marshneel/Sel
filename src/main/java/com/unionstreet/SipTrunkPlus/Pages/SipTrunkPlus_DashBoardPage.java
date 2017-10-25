package com.unionstreet.SipTrunkPlus.Pages;

import com.unionstreet.support.ElementUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;

import static com.unionstreet.SipTrunkPlus.Pages.SipTrunkPlus_ProviderPage.providerName;

/**
 * Created by rajeshg on 03/08/2017.
 */
public class SipTrunkPlus_DashBoardPage {
    ElementUtils utils = new ElementUtils();
    SipTrunkPlus_AddResellerPage sipTrunkPlus_addResellerPage = new SipTrunkPlus_AddResellerPage();
    SipTrunkPlus_ProviderPage sipTrunkPlus_providerPage = new SipTrunkPlus_ProviderPage();

    private String ADD_NEW_RESELLER_BUTTON = "//span[contains(text(),'Add reseller')]";
    private String NAVIGATE_TO_ROOT = "//span[contains(text(),'ROOT')]";
    private String DELETE_ACCOUNT_BUTTON = "//span[contains(text(),'Delete Account')]";
    private String SEARCH_BOX = "gwt-uid-4";
    private String ADD_NEW_CLIENT_BUTTON = "//span[contains(text(),'Add client')]";
    private String SLIDER_BUTTON = "v-sliderpanel-caption";
    private String YES_BUTTON = "//span[contains(text(),'Yes')]";
    String randomCredentials;


    public void clickSlider() throws InterruptedException {
        utils.waitForElementVisible(By.className(SLIDER_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.className(SLIDER_BUTTON));
    }


    public void clickNewResellerButton() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADD_NEW_RESELLER_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(ADD_NEW_RESELLER_BUTTON));
    }

    public void assertCreatedReseller() {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'New reseller" + sipTrunkPlus_addResellerPage.ranResellerName + "')]"));
    }

    public void assertResellerCannotBeDeleted(String reseller) {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'" + reseller + "')]"));

    }

    public void searchAndLoadReseller(String reseller) throws InterruptedException {
        utils.waitForElementVisible(By.id(SEARCH_BOX));
        utils.sendText(By.id(SEARCH_BOX), reseller);
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'" + reseller + "')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//div[contains(text(),'" + reseller + "')]"));
    }

    public void clickOnReseller(String reseller) throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//div[contains(text(),'" + reseller + "')]"));

    }

    public void loadProvidersFromResellerDashBoard() throws InterruptedException {
        utils.clickBtn(By.xpath("//span[contains(text(),'Providers')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Add provider')]"));
    }

    public void deleteAccount() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(DELETE_ACCOUNT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(DELETE_ACCOUNT_BUTTON));
        utils.waitForElementVisible(By.xpath(YES_BUTTON));
        Thread.sleep(2000);
        utils.javaScriptExecutorClick(By.xpath(YES_BUTTON));
    }

    public void loadRoot() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'ROOT')]"));
        Thread.sleep(3000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'ROOT')]"));
    }

    public void loadOptions() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Options')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Options')]"));
    }

    public void loadAdditional() {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Additional')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'Additional')]"));
    }

    public void assign_unAssignProvider(String provider, boolean unAssign, boolean assign) throws InterruptedException {
        if (unAssign) {
            utils.waitForElementVisible(By.xpath("//div[@class='v-select-twincol v-widget v-readonly v-has-width']/select[2]/option[contains(text(),'ProviderForAutoTest')]"));
        }
        if (assign) {
            utils.waitForElementVisible(By.xpath("//div[@class='v-select-twincol v-widget v-readonly v-has-width']/select[1]/option[contains(text(),'ProviderForAutoTest')]"));
        }
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Edit')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Edit')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//option[contains(text(),'" + provider + "')]"));
        if (unAssign) {
            utils.waitForElementVisible(By.xpath("//div[@class='v-select-twincol v-widget v-has-width']/div[2]/div[3]"));
            utils.clickBtn(By.xpath("//div[@class='v-select-twincol v-widget v-has-width']/div[2]/div[3]"));
            Thread.sleep(1000);
        }
        if (assign) {
            utils.waitForElementVisible(By.xpath("//div[@class='v-select-twincol v-widget v-has-width']/div[2]/div[1]"));
            utils.clickBtn(By.xpath("//div[@class='v-select-twincol v-widget v-has-width']/div[2]/div[1]"));

        }
    }

    public void saveChanges() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Save')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Save')]"));

    }

    public void assertUsedProvidersCannotBeAssigned(String provider) {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Next providers cant be unassigned because they are already used: " + provider + "')]"));
    }

    public void deleteResellerAccount(boolean client) throws InterruptedException, AWTException {
        deleteAccount();
        if (client) {
            deleteAccount();
        }
        loadRoot();
        utils.waitForElementVisible(By.id(SEARCH_BOX));
        Thread.sleep(1000);
        utils.sendText(By.id(SEARCH_BOX), "New reseller" + sipTrunkPlus_addResellerPage.ranResellerName);
        utils.assertElementNotPresent(By.xpath("//div[contains(text(),'New reseller" + sipTrunkPlus_addResellerPage.ranResellerName + "')]"));
    }

    public void clickNewClientButton() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(ADD_NEW_CLIENT_BUTTON));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath(ADD_NEW_CLIENT_BUTTON));
    }

    public void assertNewlyCreatedClient() {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'New client" + sipTrunkPlus_addResellerPage.ranResellerName + "')]"));
        utils.clickBtn(By.xpath("//div[contains(text(),'New client" + sipTrunkPlus_addResellerPage.ranResellerName + "')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'New client" + sipTrunkPlus_addResellerPage.ranResellerName + "')]"));
    }

    public void loadSettings() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Settings')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Settings')]"));

    }

    public void assignProviderToResellerAndPopulateMandatoryFields(String provider) throws InterruptedException {
        loadOptions();
        loadProvidersFromResellerDashBoard();
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Add provider')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Select Template')]/../../following-sibling::td[2]/div"));
        utils.clickBtn(By.xpath("//span[contains(text(),'Select Template')]/../../following-sibling::td[2]/div"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'" + provider + "')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'" + provider + "')]"));
        populateResellerSideProviderCredentials();
    }

    public void populateResellerSideProviderCredentials() throws InterruptedException {
        randomCredentials=utils.randomName();
        utils.sendText(By.xpath(sipTrunkPlus_providerPage.generateXpathForAddProviderPart1("Password")), "" + randomCredentials + "");
        utils.sendText(By.xpath(sipTrunkPlus_providerPage.generateXpathForAddProviderPart1("Realm")), "" + randomCredentials + "");
        utils.sendText(By.xpath(sipTrunkPlus_providerPage.generateXpathForAddProviderPart1("Username")), "" + randomCredentials + "");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Save')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Save')]"));
    }
    public void assertChangesToEditProviderPage() throws InterruptedException {
        Thread.sleep(1000);
        String value= utils.getAttributeOfElement(By.xpath("//span[contains(text(),'Realm')]/../../following-sibling::td[2]/input"),"value");
        Assert.assertEquals(value,""+randomCredentials+"");
    }

    public void yesOrOk(String choice) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'" + choice + "')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'" + choice + "')]"));

    }

    public void deletingProviderFromResellerConfiguration(String provider) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'" + provider + "')]"));
        utils.rightCLick(By.xpath("//td[contains(text(),'" + provider + "')]"));
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Delete')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'Delete')]"));
        Thread.sleep(1000);
    }

    public void loadEditProviderScreen(String provider) throws InterruptedException {
       Thread.sleep(1000);
        utils.rightCLick(By.xpath("//td[contains(text(),'" + provider + "')]"));
        utils.clickBtn(By.xpath("//span[contains(text(),'Edit')]"));



    }

    public void successfulDeletion() throws InterruptedException {
        yesOrOk("Yes");
    }

    public void popMessageDenyingProviderDeletion() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'it is already used by resellers')]"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'" + providerName + "')]"));
        yesOrOk("OK");


    }


}

