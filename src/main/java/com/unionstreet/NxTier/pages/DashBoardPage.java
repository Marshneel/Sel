package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;


public class DashBoardPage {


    public final String DASHBOARD_TITLE = "menutitle";
    //TODO
    public final String LOGOUT_BUTTON = ".logout";
    public final String QUOTE = "bodyContent";
    private final String ORDERSMANAGER_BUTTON = "HrefOrdersManager";
    private final String CONTACT_MANAGER_BUTTON = "HrefContactManager";

    ElementUtils utils = new ElementUtils();

    public void assertLogin() {
        utils.verifyStringMatch(By.id(DASHBOARD_TITLE), "DASHBOARD");
    }

    public void logOut() throws InterruptedException {
        try {
            Thread.sleep(1000);
            utils.clickBtnWithWait(By.cssSelector(LOGOUT_BUTTON));
        } catch (Exception e) {
            try {
                Thread.sleep(1000);
                utils.clickBtnWithWait(By.cssSelector(LOGOUT_BUTTON));
            } catch (Exception e1) {
                utils.checkAlert();
            }
        }
    }

    public void clickOrderManagerButton() throws InterruptedException {
        utils.waitForElementVisible(By.id(ORDERSMANAGER_BUTTON));
        utils.scrollUp(By.id(ORDERSMANAGER_BUTTON));
        utils.clickBtn(By.id(ORDERSMANAGER_BUTTON));
    }

    public void clickContactManagerTab(){

            utils.waitForElementVisible(By.id(CONTACT_MANAGER_BUTTON));
            utils.clickBtn(By.id(CONTACT_MANAGER_BUTTON));



    }

    public void loadServiceDesk() {
        try {
            utils.getDashBoardPage();
            utils.waitForElementVisible(By.id("HrefServiceDesk"));
            utils.clickBtn(By.id("HrefServiceDesk"));
        } catch (Exception e) {
            utils.getDashBoardPage();
            utils.waitForElementVisible(By.id("HrefServiceDesk"));
            utils.clickBtn(By.id("HrefServiceDesk"));
        }
    }
}
