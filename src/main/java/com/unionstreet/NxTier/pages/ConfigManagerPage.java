package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.UnsupportedEncodingException;

/**
 * Created by RajeshG on 06/06/2017.
 */
public class ConfigManagerPage {

    private final String CONFIG_MANAGER_BLUE_LABEL = "//div[contains(text(),'Config Manager')]";
    private final String FREE_MINUTES_TAB = "//a[contains(@href,'freeminuteslistview')]";
    private final String PACKAGE_MANAGER_TAB = "//a[contains(@href,'configuration/packagemanager')]";
    private final String PEAK_TARIFF_RATES_LIST = "RatesList_0__r_peak";
    private final String OFFPEAK_TARIFF_RATES_LIST = "RatesList_0__r_offpeak";
    private final String ASSIGN_TARIFF_TAB = "HrefAssignTarrifs";
    private final String ASSIGN_FREE_MINUTES_TAB = "HrefAssignFreeMinutes";
    private final String ASSIGN_PACKAGE_TAB = "HrefAssignPackage";
    private final String EDIT_FREE_MINUTES_ICON = "//img[@title='Edit Free Minutes Details']";
    private final String EDIT_FREEMINS_DISABLED_DESCRIPTION = "//textarea[@id='Dfreeminutedetails_description'][@disabled='disabled']";
    private final String EDIT_FREEMINS_DISABLED_WHAT = "//select[@id='Dfreeminutedetails_what_id']";
    private final String TARIFF_MANAGER_TAB = "//div[@id='subMenu']//a[contains(@href,'tariff')]";
    private final String DISABLED_TARIFF_NAME = "//input[@id='TariffName1'][@disabled='disabled']";
    private final String DISABLED_MIN_CHARGE_UNDER_TARIFF_RATES_LIST = "//input[@id='RatesList_0__r_mincharge'][@disabled='disabled']";
    private final String EDIT_FREE_MINUTES_NAME_FIELD = "Plan_name";
    private final String EDIT_FREE_MINUTES_AMOUNT_FIELD = "Dfreeminutedetails_amount";
    private final String EDIT_FREE_MINUTES_WHAT_DROPDOWN = "Dfreeminutedetails_what_id";
    private final String EDIT_FREE_MINUTES_APPLY_TO_DROPDOWN = "Dfreeminutedetails_apply_to_id";
    private final String EDIT_FREE_MINUTES_FREQUENCY_DROPDOWN = "Dfreeminutedetails_frequency_id";
    private final String EDIT_PACKAGE_NAME_FIELD = "mpackage_name";
    private final String EDIT_PACKAGE_VOICE_TARIFF_DROPDOWN = "mpackage_lcr_tariff";
    private final String EDIT_PACKAGE_DATA_TARIFF_DROPDOWN = "mpackage_data_tariff";
    private final String SELECT_FREE_MINUTES_PLAN_CHECKBOX_FROM_LIST_UNDER_EDIT_PACKAGE = "_selectedFreemins_0__isSelected";
    private final String DISABLED_PACKAGE_NAME = "//input[@id='mpackage_name'][@readonly='readonly']";
    private final String DISABLED_VOICE_TARIFF_UNDER_EDIT_PACKAGE = "//select[@id='mpackage_lcr_tariff'][@readonly='readonly']";
    private final String ONLY_CONSUMER_TARIFFS_CAN_BE_APPLIED_TO_CONSUMER_PACKAGES = "//label[contains(text(),'Only consumer tariffs can be applied to consumer packages')]";




    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods = new CommonMethods();
    public static String RanFreeMinutePlanName;
    public static String RanPackageName;
    CreateTariffPage createTariffPage = new CreateTariffPage();
    DashBoardPage dashBoardPage=new DashBoardPage();


    public void assignToAnAgent(String assignee) throws InterruptedException {
        commonMethods.search("Agent");
        utils.waitForElementVisible(By.id(assignee));
        Thread.sleep(1000);
        utils.makeSureBoxIsChecked(By.id(assignee), By.id(assignee));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
       utils.checkAlert();
        utils.switchToPreviousWindow(0);

    }

    public void assignTariffPlanToAgent(String tariffplan, String rates, String assignee) throws InterruptedException, AWTException {
        utils.waitForElementVisible(By.xpath(CONFIG_MANAGER_BLUE_LABEL));
        commonMethods.search("" + tariffplan + "");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + tariffplan + "')]"));
       // Thread.sleep(1000);
        utils.switchToNewWindowByJavaExeClick(By.xpath("//a[contains(text(),'" + tariffplan + "')]"));
        utils.waitForElementVisible(By.id(createTariffPage.TARIFF_RATES_BUTTON));
        utils.clickBtn(By.id(createTariffPage.TARIFF_RATES_BUTTON));
        utils.checkAlert();
        utils.waitForElementVisible(By.id(PEAK_TARIFF_RATES_LIST));
        utils.sendText(By.id(PEAK_TARIFF_RATES_LIST), "" + rates + "");
        utils.clickBtn(By.id(OFFPEAK_TARIFF_RATES_LIST));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.id(ASSIGN_TARIFF_TAB));
        utils.clickBtn(By.id(ASSIGN_TARIFF_TAB));
        assignToAnAgent(assignee);
    }

    public void assignFreeMinutesPlanToAgent(String freeMinutePlan, String assignee) throws InterruptedException {
        accessFreeMinutesTab();
        commonMethods.search("" + freeMinutePlan + "");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        Thread.sleep(1000);
        //utils.clickBtn(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        utils.waitForElementVisible(By.id(ASSIGN_FREE_MINUTES_TAB));
        utils.clickBtn(By.id(ASSIGN_FREE_MINUTES_TAB));
        assignToAnAgent(assignee);
    }

    public void assignPackageToAgent(String Package, String assignee) throws InterruptedException {
        commonMethods.search("" + Package + "");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + Package + "')]"));
       // utils.clickBtn(By.xpath("//a[contains(text(),'" + Package + "')]"));
        utils.switchToNewWindowByJavaExeClick(By.xpath("//a[contains(text(),'" + Package + "')]"));
        utils.waitForElementVisible(By.id(ASSIGN_PACKAGE_TAB));
        utils.clickBtn(By.id(ASSIGN_PACKAGE_TAB));
        utils.waitForElementVisible(By.id(assignee));
        utils.makeSureBoxIsChecked(By.id(assignee), By.id(assignee));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.switchToPreviousWindow(0);
    }

    public void assertTariff(String tariffName) {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + tariffName + "')]"));
    }

    public void assertFreeMinutes(String freeMinutePlan) throws InterruptedException {
        utils.clickBtn(By.xpath(FREE_MINUTES_TAB));
        commonMethods.search("Mobile 250 Free Mins (UK and Mob");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
    }

    public void assertFreeMinutesAreNotEditable(String freeMinutePlan) {
      //  utils.clickBtn(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'" + freeMinutePlan + "')]"));
        utils.waitForElementVisible(By.xpath(EDIT_FREE_MINUTES_ICON));
        //utils.clickBtn(By.xpath(EDIT_FREE_MINUTES_ICON));
        utils.switchToNewWindow(By.xpath(EDIT_FREE_MINUTES_ICON));
        utils.waitForElementVisible(By.xpath(EDIT_FREEMINS_DISABLED_DESCRIPTION));
        utils.waitForElementVisible(By.xpath(EDIT_FREEMINS_DISABLED_WHAT));
    }

    public void assertTariffAreNotEditable(String tariffPlan) throws InterruptedException {
        utils.switchToPreviousWindow(0);
        utils.waitForElementVisible(By.xpath(TARIFF_MANAGER_TAB));
        utils.clickBtn(By.xpath(TARIFF_MANAGER_TAB));
        commonMethods.search(tariffPlan);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + tariffPlan + "')]"));
       // utils.clickBtn(By.xpath("//a[contains(text(),'" + tariffPlan + "')]"));
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'" + tariffPlan + "')]"));
        utils.waitForElementVisible(By.xpath(DISABLED_TARIFF_NAME));
        utils.waitForElementVisible(By.id(createTariffPage.TARIFF_RATES_BUTTON));
        utils.clickBtn(By.id(createTariffPage.TARIFF_RATES_BUTTON));
        utils.waitForElementVisible(By.xpath(DISABLED_MIN_CHARGE_UNDER_TARIFF_RATES_LIST));
    }

    public void navigateToAddTariffPlan() {
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        //utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.waitForElementVisible(By.id(createTariffPage.TARIFF_NAME_TEXT_BOX));
    }

    public void addFreeMinutesPlan() throws InterruptedException {
        accessFreeMinutesTab();
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
        //utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.waitForElementVisible(By.id(EDIT_FREE_MINUTES_NAME_FIELD));
        RanFreeMinutePlanName = utils.randomName();
       Thread.sleep(1000);
        utils.sendText(By.id(EDIT_FREE_MINUTES_NAME_FIELD), RanFreeMinutePlanName);
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_BUTTON));
        utils.waitForElementVisible(By.cssSelector(commonMethods.ADD_BUTTON));
       //utils.clickBtn(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.switchToNewWindow(By.cssSelector(commonMethods.ADD_BUTTON));
        utils.waitForElementVisible(By.id(EDIT_FREE_MINUTES_AMOUNT_FIELD));
        utils.sendText(By.id(EDIT_FREE_MINUTES_AMOUNT_FIELD), "100");
        utils.selectByVisibleText(By.id(EDIT_FREE_MINUTES_WHAT_DROPDOWN), "Calls");
        utils.waitForElementVisible(By.xpath("//div[@id='divProgress'][contains(@style,'display: none;')]"));
        utils.selectByVisibleText(By.id(EDIT_FREE_MINUTES_APPLY_TO_DROPDOWN), "Per Company");
        utils.selectByVisibleText(By.id(EDIT_FREE_MINUTES_FREQUENCY_DROPDOWN), "Daily");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.switchToPreviousWindow(0);

    }

    public void accessFreeMinutesTab() {
       utils.waitForElementVisible(By.xpath(FREE_MINUTES_TAB));
        utils.clickBtn(By.xpath(FREE_MINUTES_TAB));
    }

    public void editFreeMinutePlan(String amount, String what) throws InterruptedException {
        accessFreeMinutesTab();
        commonMethods.search(RanFreeMinutePlanName);
        Thread.sleep(1000);
       // utils.clickBtn(By.xpath("//a[contains(text(),'" + RanFreeMinutePlanName + "')]"));
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'" + RanFreeMinutePlanName + "')]"));
        utils.waitForElementVisible(By.id(EDIT_FREE_MINUTES_NAME_FIELD));
        utils.sendText(By.id(EDIT_FREE_MINUTES_NAME_FIELD), RanFreeMinutePlanName + "changed name");
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.waitForElementVisible(By.xpath(EDIT_FREE_MINUTES_ICON));
      //  utils.clickBtn(By.xpath(EDIT_FREE_MINUTES_ICON));
        utils.switchToNewWindow(By.xpath(EDIT_FREE_MINUTES_ICON));
        utils.waitForElementVisible(By.id(EDIT_FREE_MINUTES_AMOUNT_FIELD));
        utils.sendText(By.id(EDIT_FREE_MINUTES_AMOUNT_FIELD),amount);
        utils.waitForElementVisible(By.xpath(EDIT_FREEMINS_DISABLED_WHAT));
        utils.selectByVisibleText(By.xpath(EDIT_FREEMINS_DISABLED_WHAT),what);
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.switchToPreviousWindow(0);
       commonMethods.navigateToHome();
        dashBoardPage.clickConfigManager();
        accessFreeMinutesTab();
        commonMethods.search(RanFreeMinutePlanName + "changed name");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanFreeMinutePlanName + "changed name')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+amount+"')]"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+what+"')]"));
        }


    public void loadPackageManager() {
        utils.waitForElementVisible(By.xpath(PACKAGE_MANAGER_TAB));
        utils.clickBtn(By.xpath(PACKAGE_MANAGER_TAB));
    }

    public void clickAdd() {
        utils.waitForElementVisible(By.xpath(commonMethods.ADD_XPATH));
        utils.switchToNewWindow(By.xpath(commonMethods.ADD_XPATH));

    }

    public void createPackage(String packageType, String TariffPlan, boolean consumerPackage, boolean verifyCreatedTariffAndFreeMinutes) throws InterruptedException, UnsupportedEncodingException, ClassNotFoundException {
        RanPackageName = utils.randomName();
        utils.waitForElementVisible(By.id(EDIT_PACKAGE_NAME_FIELD));
        utils.sendText(By.id(EDIT_PACKAGE_NAME_FIELD), RanPackageName);
        utils.waitForElementVisible(By.xpath("//div[@id='consumerdiv']//input[" + packageType + "]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//div[@id='consumerdiv']//input[" + packageType + "]"));
        if (consumerPackage == false) {
            utils.waitForElementVisible(By.xpath(ONLY_CONSUMER_TARIFFS_CAN_BE_APPLIED_TO_CONSUMER_PACKAGES));
        } else {
        }
        if (verifyCreatedTariffAndFreeMinutes) {
            utils.waitForElementVisible(By.xpath("//option[contains(text(),'" + createTariffPage.RanTariffPlanName + "')]"));
            utils.waitForElementVisible(By.xpath("//td[contains(text(),'" + RanFreeMinutePlanName + "')]"));
        }else{}
        utils.waitForElementVisible(By.id(EDIT_PACKAGE_VOICE_TARIFF_DROPDOWN));
        utils.selectByVisibleText(By.id(EDIT_PACKAGE_VOICE_TARIFF_DROPDOWN), "" + TariffPlan + "");
        utils.waitForElementVisible(By.id(EDIT_PACKAGE_DATA_TARIFF_DROPDOWN));
        utils.selectByVisibleText(By.id(EDIT_PACKAGE_DATA_TARIFF_DROPDOWN), "" + TariffPlan + "");
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'Mobile 250 Free Mins (UK and Mob')]/following-sibling::td/label"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'"+RanFreeMinutePlanName+"')]/following-sibling::td/label"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//td[contains(text(),'"+RanFreeMinutePlanName+"')]/following-sibling::td/label"));
    }


    public void saveAndAssertThePackage(String consumerCheck) throws InterruptedException {
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanPackageName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanPackageName + "')]"));
        utils.waitForElementVisible(By.xpath("//input[@id='Consumer']" + consumerCheck + ""));
    }


    public void assertCPAssignedPackagesAreNotEditable(String packageName) throws InterruptedException {
        commonMethods.search(packageName);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + packageName + "')]"));

        // utils.clickBtn(By.xpath("//a[contains(text(),'" + packageName + "')]"));
        utils.switchToNewWindowByJavaExeClick(By.xpath("//a[contains(text(),'" + packageName + "')]"));
        utils.waitForElementVisible(By.xpath(DISABLED_PACKAGE_NAME));
        utils.waitForElementVisible(By.xpath(DISABLED_VOICE_TARIFF_UNDER_EDIT_PACKAGE));
        utils.waitForElementVisible(By.xpath("//input[@id='_selectedFreemins_0__isSelected'][@readonly='readonly']"));
    }

    public void editCreatedPackage() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanPackageName + "')]"));
        //utils.clickBtn(By.xpath("//a[contains(text(),'" + RanPackageName + "')]"));
       Thread.sleep(1000);
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'" + RanPackageName + "')]"));
        utils.waitForElementVisible(By.id(EDIT_PACKAGE_NAME_FIELD));
        utils.sendText(By.id(EDIT_PACKAGE_NAME_FIELD), RanPackageName + "editedName");
        utils.waitForElementVisible(By.xpath("//table[@id='GroupTable']//td[contains(text(),'" + RanFreeMinutePlanName + "')]/following-sibling::td//label"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//table[@id='GroupTable']//td[contains(text(),'" + RanFreeMinutePlanName + "')]/following-sibling::td//label"));
        utils.checkAlert();
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.checkAlert();
        utils.switchToPreviousWindow(0);
        commonMethods.search(RanPackageName + "editedName");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'" + RanPackageName + "editedName" + "')]"));
       // utils.clickBtn(By.xpath("//a[contains(text(),'" + RanPackageName + "editedName" + "')]"));
        utils.switchToNewWindowByJavaExeClick(By.xpath("//a[contains(text(),'" + RanPackageName + "editedName" + "')]"));
        utils.waitForElementVisible(By.xpath("//select[@id='mpackage_lcr_tariff']//option[@selected='selected'][contains(text(),'" + createTariffPage.RanTariffPlanName + "')]"));
        utils.waitForElementVisible(By.xpath("//table[@id='GroupTable']//tr/following-sibling::tr/td[contains(text(),'" + RanFreeMinutePlanName + "')]/following-sibling::td/label"));

    }

    public void distinguishAgentCreatedFreeMinutes() throws InterruptedException {
        accessFreeMinutesTab();
        commonMethods.search(RanFreeMinutePlanName);
        utils.waitForElementVisible(By.xpath("//tr[@class='table_row  Bold']//a[contains(text(),'" + RanFreeMinutePlanName + "')]"));
    }

    public void distinguishCPCreatedFreeMinutes(String freeMinutesPackage) throws InterruptedException {
        accessFreeMinutesTab();
        commonMethods.search(freeMinutesPackage);
        utils.waitForElementVisible(By.xpath(createTariffPage.SEMI_TRANSPARENT_UNION_STREET_TEXT));
    }

    public void distinguishAgentCreatedPackages() throws InterruptedException {
        commonMethods.search(RanPackageName);
        utils.waitForElementVisible(By.xpath("//tr[@class='table_row  Bold']//a[contains(text(),'" + RanPackageName + "')]"));
    }

    public void distinguishCPCreatedPackage(String Package) throws InterruptedException {
        accessFreeMinutesTab();
        commonMethods.search(Package);
        utils.waitForElementVisible(By.xpath(createTariffPage.SEMI_TRANSPARENT_UNION_STREET_TEXT));
    }
    public void cpCannotAssignAgentsFreeMinutesAndPackagesToAnyOneElseNorCanHeRevokeIt(String plan, String tabButton, String name, String row) throws InterruptedException {
        commonMethods.search(plan);
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'"+plan+"')]"));
       // utils.clickBtn(By.xpath("//a[contains(text(),'"+plan+"')]"));
        utils.switchToNewWindow(By.xpath("//a[contains(text(),'"+plan+"')]"));
        utils.waitForElementVisible(By.id(""+tabButton+""));
        utils.clickBtn(By.id(""+tabButton+""));
        utils.waitForElementVisible(By.xpath("//tr[@class='SemiTransparent']//td[contains(text(),'"+name+"')]"));
        utils.assertElementNotPresent(By.xpath("//td[contains(text(),'Union Street Telecoms')]/../td["+row+"]/input[@checked='checked']"));
        utils.waitForElementVisible(By.xpath("//td[contains(text(),'agent')]/../td["+row+"]/input[@checked='checked']"));
}}