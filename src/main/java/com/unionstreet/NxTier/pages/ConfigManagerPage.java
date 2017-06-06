package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 06/06/2017.
 */
public class ConfigManagerPage {

    ElementUtils utils=new ElementUtils();
    CommonMethods commonMethods=new CommonMethods();

    public void assignTariffPlansToAgent() throws InterruptedException {
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'Config Manager')]"));
        commonMethods.search("Sell 2p NGCS AC (+60 sec)");
        utils.waitForElementVisible(By.xpath("//a[contains(text(),'Sell 2p NGCS AC (+60 sec)')]"));
        utils.clickBtn(By.xpath("//a[contains(text(),'Sell 2p NGCS AC (+60 sec)')]"));
        utils.switchToNewWindow();
        utils.waitForElementVisible(By.id("HrefAssignTarrifs"));
        utils.clickBtn(By.id("HrefAssignTarrifs"));
        utils.waitForElementVisible(By.id("checkbox1"));
        utils.clickBtn(By.id("checkbox1"));
        utils.waitForElementVisible(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.clickBtn(By.cssSelector(commonMethods.SAVE_AND_CLOSE_BUTTON));
        utils.switchToPreviousWindow(1);



    }
}
