package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;


public class DashBoardPage {


    public final String DASHBOARD_TITLE = "menutitle";
    //TODO
    public final String LOGOUT_BUTTON = ".logout";
    public final String QUOTE = "bodyContent";
    private final String ORDERSMANAGER_BUTTON = "HrefOrdersManager";
    private final String CREATEQUOTE_BUTTON = ".add";
    ElementUtils utils = new ElementUtils();

    public void assertLogin() {
        utils.verifyStringMatch(By.id(DASHBOARD_TITLE), "DASHBOARD");
    }

    public void logOut() {
        utils.clickBtn(By.xpath("//div[@class='divlogout']"));

    }

    public void clickOrderManagerButton() {
        utils.clickBtn(By.id(ORDERSMANAGER_BUTTON));
        utils.waitForElementVisible(By.cssSelector(CREATEQUOTE_BUTTON));
    }

}
