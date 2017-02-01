package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 31/01/2017.
 */
public class WLR3_Cease_OrderPage {

    private final String TEXT_ON_CEASE_PAGE = "//h3[contains(text(),'Cease - Premium Analogue')]";
    private final String MOVE_TO_NEXT = "//a[contains(@onclick,'ceaseWizard.moveNext()')]";
    private final String REVERT_TO_PREVIOUS = "//a[contains(@onclick,'ceaseWizard.movePrevious()')]";
    private final String RECOVER_LINE_PLANT_CHECKBOX = "WLR3Order_recover_line_plant";
    private final String DATE_ELEMENT = "StartFromDate";
    private final String LABEL_ON_APPOINTMENTS_TAB = "noVisitRequiredLabel";
    private final String ONE_MONTH_CALLER_REDIRECT_FEATURE = "Features_0__value";
    private final String QUARTERLY_CALLER_REDIRECT_FEATURE = "Features_1__value";
    private final String REMOTE_CALL_FORWARDING_FEATURE = "Features_2__value";
    private final String ONE_MONTH_CALLER_REDIRECT_FEATURE_CLI_TEXTBOX = "Features_0__cli";
    private final String QUARTERLY_CALLER_REDIRECT_FEATURE_CLI_TEXTBOX = "Features_1__cli";
    private final String REMOTE_CALL_FORWARDING_FEATURE_CLI_TEXTBOX = "Features_2__cli";
    private final String ONE_MONTH_CALLER_REDIRECT_TEXT = "//div[@id='divchargescontainer']//td[contains(text(),'1 Month Caller Redirect')]";
    private final String QUARTERLY_CALLER_REDIRECT_TEXT = "//div[@id='divchargescontainer']//td[contains(text(),'Quarterly Caller Redirect')]";
    private final String REMOTE_CALL_FORWARD_TEXT = "//div[@id='divchargescontainer']//td[contains(text(),'Remote Call Forward')]";

    ElementUtils utils = new ElementUtils();

    public void textOnCeaseOrderPage() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_CEASE_PAGE));
    }

    public void navigateToNextScreen() {
        utils.waitForElementVisible(By.xpath(MOVE_TO_NEXT));
        utils.clickBtn(By.xpath(MOVE_TO_NEXT));
    }

    public void populateRecoveryLinePlantAndVerifyAssertion() {
        utils.makeSureBoxIsChecked(By.id(RECOVER_LINE_PLANT_CHECKBOX), By.id(RECOVER_LINE_PLANT_CHECKBOX));
        navigateToNextScreen();
        utils.waitForElementVisible(By.id(DATE_ELEMENT));

    }

    public void navigateToPreviousScreen() throws InterruptedException {
        utils.waitForElementVisible(By.xpath(REVERT_TO_PREVIOUS));
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(REVERT_TO_PREVIOUS));
    }

    public void dePopulateRecoveryLinePlantAndVerifyAssertion() {
        utils.waitForElementVisible(By.id(RECOVER_LINE_PLANT_CHECKBOX));
        utils.makeSureBoxIsUnChecked(By.id(RECOVER_LINE_PLANT_CHECKBOX), By.id(RECOVER_LINE_PLANT_CHECKBOX));
        navigateToNextScreen();
        utils.waitForElementVisible(By.id(LABEL_ON_APPOINTMENTS_TAB));
    }

    public void verifyCallFeatures() throws InterruptedException {
        utils.waitForElementVisible(By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE));
        utils.makeSureBoxIsChecked(By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE), By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE));
        utils.sendText(By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE_CLI_TEXTBOX), "02076454545");
        navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(ONE_MONTH_CALLER_REDIRECT_TEXT));
        Thread.sleep(1000);
        navigateToPreviousScreen();
        utils.waitForElementVisible(By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE));
        utils.makeSureBoxIsUnChecked(By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE), By.id(ONE_MONTH_CALLER_REDIRECT_FEATURE));
        utils.makeSureBoxIsChecked(By.id(QUARTERLY_CALLER_REDIRECT_FEATURE), By.id(QUARTERLY_CALLER_REDIRECT_FEATURE));
        utils.sendText(By.id(QUARTERLY_CALLER_REDIRECT_FEATURE_CLI_TEXTBOX), "02076454545");
        Thread.sleep(1000);
        navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(QUARTERLY_CALLER_REDIRECT_TEXT));
        navigateToPreviousScreen();
        utils.waitForElementVisible(By.id(QUARTERLY_CALLER_REDIRECT_FEATURE));
        utils.makeSureBoxIsUnChecked(By.id(QUARTERLY_CALLER_REDIRECT_FEATURE), By.id(QUARTERLY_CALLER_REDIRECT_FEATURE));
        utils.makeSureBoxIsChecked(By.id(REMOTE_CALL_FORWARDING_FEATURE), By.id(REMOTE_CALL_FORWARDING_FEATURE));
        utils.sendText(By.id(REMOTE_CALL_FORWARDING_FEATURE_CLI_TEXTBOX), "02076454545");
        Thread.sleep(1000);
        navigateToNextScreen();
        utils.waitForElementVisible(By.xpath(REMOTE_CALL_FORWARD_TEXT));


    }


}
