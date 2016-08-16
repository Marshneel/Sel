package com.unionstreet.NxTier_smokePack.pages;

import com.unionstreet.NxTier_smokePack.support.ElementUtils;
import org.openqa.selenium.By;

public class DashBoardPage {
    private final String DASHBOARD_TITLE = "menutitle";
    //TODO
    private final String LOGOUT_BUTTON = ".logout";
    ElementUtils utils = new ElementUtils();

    public void assertLogin() {
        utils.verifyStringMatch(By.id(DASHBOARD_TITLE), "DASHBOARD");
    }

    public void logOut() {
        utils.clickBtn(By.cssSelector(LOGOUT_BUTTON));
    }
}