package com.unionstreet.NxTier_smokePack.pages;

import com.unionstreet.NxTier_smokePack.support.ElementUtils;
import org.openqa.selenium.By;

public class LoginPage {
    private final String USENAME_FIELD = "UserName";
    private final String PASSWORD_FIELD = "Password";
    //TODO
    private final String LOGINBUTTON = ".DivButton";
    ElementUtils utils = new ElementUtils();

    public void doLogin() {
        try {
            utils.sendText(By.id(USENAME_FIELD), utils.getProperty("userName"));
            utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("passWord"));
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failedLogin(String username, String password) {
        utils.sendText(By.id(USENAME_FIELD), username);
        utils.sendText(By.id(PASSWORD_FIELD), password);
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
    }

    //TODO
    public void assertFailedLogin() {
        utils.assertURL("http://webtester:82/team3");
    }

    public void OnLoginPage() {
        utils.assertURL("http://webtester:82/team3");
    }
}
