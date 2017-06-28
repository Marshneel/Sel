package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.awt.*;

/**
 * Created by RajeshG on 06/06/2017.
 */
public class ConfigManagerPage {

    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    public static String RanFreeMinutePlanName;
    public static String RanPackageName;
    CreateTariffPage createTariffPage = new CreateTariffPage();


    public void assignToAnAgent(String assignee) throws InterruptedException {
        commonMethods.search("Agent");
        utils.waitForElementVisible(By.id(assignee));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.id(assignee), By.id(assignee));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);

    }

    public void assignTariffPlanToAgent(String tariffplan, String rates, String assignee) throws InterruptedException, AWTException {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Config Manager')]"));
        commonMethods.search("" + tariffplan + "");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + tariffplan + "')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'" + tariffplan + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefTariffRates"));
        utils.clickBtn(By.id("HrefTariffRates"));
        utils.checkAlert();
        utils.waitForElementVisible(By.id("RatesList_0__r_peak"));
        utils.sendText(By.id("RatesList_0__r_peak"), "" + rates + "");
        utils.clickBtn(By.id("RatesList_0__r_offpeak"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.id("HrefAssignTarrifs"));
        utils.clickBtn(By.id("HrefAssignTarrifs"));
        assignToAnAgent(assignee);
    }

    public void assignFreeMinutesPlanToAgent(String freeMinutePlan, String assignee) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        commonMethods.search("" + freeMinutePlan + "");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefAssignFreeMinutes"));
        utils.clickBtn(By.id("HrefAssignFreeMinutes"));
        assignToAnAgent(assignee);
    }

    public void assignPackageToAgent(String Package, String assignee) throws InterruptedException {
        commonMethods.search("" + Package + "");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + Package + "')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'" + Package + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefAssignPackage"));
        utils.clickBtn(By.id("HrefAssignPackage"));
        utils.waitForElementVisible(By.id(assignee));
        utils.makeSureBoxIsChecked(By.id(assignee), By.id(assignee));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }

    public void assertTariff(String tariffName) {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + tariffName + "')]"));
    }

    public void assertFreeMinutes(String freeMinutePlan) {
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
    }

    public void assertFreeMinutesAreNotEditable(String freeMinutePlan) {
        utils.clickBtn(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//img[@title='Edit Free Minutes Details']"));
        utils.clickBtn(By.xpath("//img[@title='Edit Free Minutes Details']"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//textarea[@id='Dfreeminutedetails_description'][@disabled='disabled']"));
        utils.waitForElementVisible(By.xpath("//select[@id='Dfreeminutedetails_what_id'][@disabled='disabled']"));
    }

    public void assertTariffAreNotEditable(String tariffPlan) throws InterruptedException {
        utils.switchToPreviousWindow(0);
        utils.waitForElementVisible(By.xpath("//div[@id='subMenu']//a[contains(@href,'tariff')]"));
        utils.clickBtn(By.xpath("//div[@id='subMenu']//a[contains(@href,'tariff')]"));
        commonMethods.search(tariffPlan);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + tariffPlan + "')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'" + tariffPlan + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//input[@id='TariffName1'][@disabled='disabled']"));
        utils.waitForElementVisible(By.id("HrefTariffRates"));
        utils.clickBtn(By.id("HrefTariffRates"));
        utils.waitForElementVisible(By.xpath("//input[@id='RatesList_0__r_mincharge'][@disabled='disabled']"));
    }

    public void navigateToAddTariffPlan() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("TariffName1"));
    }

    public void addFreeMinutesPlan() {
        utils.waitForElementVisible(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("Plan_name"));
        RanFreeMinutePlanName = utils.randomName();
        utils.sendText(By.id("Plan_name"), RanFreeMinutePlanName);
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("Dfreeminutedetails_amount"));
        utils.sendText(By.id("Dfreeminutedetails_amount"), "100");
        utils.selectByVisibleText(By.id("Dfreeminutedetails_what_id"), "Calls");
        utils.waitForElementVisible(By.xpath("//div[@id='divProgress'][contains(@style,'display: none;')]"));
        utils.selectByVisibleText(By.id("Dfreeminutedetails_apply_to_id"), "Per Company");
        utils.selectByVisibleText(By.id("Dfreeminutedetails_frequency_id"), "Daily");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
    }

    public void editFreeMinutePlan() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'freeminuteslistview')]"));
        commonMethods.search(RanFreeMinutePlanName);
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'" + RanFreeMinutePlanName + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("Plan_name"));
        utils.sendText(By.id("Plan_name"), RanFreeMinutePlanName + "changed name");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanFreeMinutePlanName + "changed name");
        try {
            utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanFreeMinutePlanName + "changed name')]"));
        } catch (Exception e) {
            System.out.println("agent is not able to edit a free minute plan");
        }
    }

    public void loadPackageManager() {
        utils.waitForElementVisible(By.xpath("//a[contains(@href,'configuration/packagemanager')]"));
        utils.clickBtn(By.xpath("//a[contains(@href,'configuration/packagemanager')]"));
    }

    public void clickAdd() {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'Add')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'Add')]"));

    }

    public void createPackage(String packageType, String TariffPlan, boolean consumerPackage, boolean verifyCreatedTariffAndFreeMinutes) throws InterruptedException {
        utils.switchToNewWindow();
        RanPackageName = utils.randomName();
        utils.waitForElementVisible(By.id("mpackage_name"));
        utils.sendText(By.id("mpackage_name"), RanPackageName);
        utils.waitForElementVisible(By.xpath("//div[@id='consumerdiv']//input[" + packageType + "]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='consumerdiv']//input[" + packageType + "]"));
        if (consumerPackage == false) {
            utils.waitForElementVisible(By.xpath("//label[contains(text(),'Only consumer tariffs can be applied to consumer packages')]"));
        } else {
        }
        if (verifyCreatedTariffAndFreeMinutes) {
            utils.waitForElementVisible(By.xpath("//option[contains(text(),'" + createTariffPage.RanTariffPlanName + "')]"));
            utils.waitForElementVisible(By.xpath("//td[contains(text(),'" + RanFreeMinutePlanName + "')]"));
        }
        utils.waitForElementVisible(By.id("mpackage_lcr_tariff"));
        utils.selectByVisibleText(By.id("mpackage_lcr_tariff"), "" + TariffPlan + "");
        utils.waitForElementVisible(By.id("mpackage_data_tariff"));
        utils.selectByVisibleText(By.id("mpackage_data_tariff"), "" + TariffPlan + "");
        utils.waitForElementVisible(By.id("_selectedFreemins_0__isSelected"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.id("_selectedFreemins_0__isSelected"));}


public void saveAndAssertThePackage(String consumerCheck) throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.clickBtn(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanPackageName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanPackageName + "')]"));
        utils.waitForElementVisible(By.xpath("//input[@id='Consumer']" + consumerCheck + ""));
    }


    public void assertCPAssignedPackagesAreNotEditable(String packageName) throws InterruptedException {
        commonMethods.search(packageName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+packageName+"')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'"+packageName+"')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//input[@id='mpackage_name'][@readonly='readonly']"));
        utils.waitForElementVisible(By.xpath("//select[@id='mpackage_lcr_tariff'][@readonly='readonly']"));
        utils.waitForElementVisible(By.xpath("//input[@id='_selectedFreemins_0__isSelected'][@readonly='readonly']"));
    }
    public void editCreatedPackage() throws InterruptedException {
       utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+RanPackageName+"')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'"+RanPackageName+"')]"));
       utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("mpackage_name"));
        utils.sendText(By.id("mpackage_name"),RanPackageName+"editedName");
        utils.waitForElementVisible(By.xpath("//table[@id='GroupTable']//td[contains(text(),'"+RanFreeMinutePlanName+"')]/following-sibling::td//label"));
       Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//table[@id='GroupTable']//td[contains(text(),'"+RanFreeMinutePlanName+"')]/following-sibling::td//label"));
        utils.checkAlert();
        utils.waitForElementVisible(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.clickBtn(By.xpath("//input[contains(@onclick,'SaveAndClose')]"));
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanPackageName+"editedName");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanPackageName+"editedName" + "')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'" + RanPackageName+"editedName" + "')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.xpath("//select[@id='mpackage_lcr_tariff']//option[@selected='selected'][contains(text(),'"+createTariffPage.RanTariffPlanName+"')]"));
        utils.waitForElementVisible(By.xpath("//table[@id='GroupTable']//tr/following-sibling::tr/td[contains(text(),'"+RanFreeMinutePlanName+"')]/following-sibling::td/label"));

    }


}