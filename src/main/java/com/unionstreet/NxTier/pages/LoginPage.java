package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class LoginPage {
    public final String USENAME_FIELD = "UserName";
    public final String PASSWORD_FIELD = "Password";
    //TODO
    public final String LOGINBUTTON = ".DivButton";
    ElementUtils utils = new ElementUtils();

    public void doLogin() {
        utils.sendText(By.id(USENAME_FIELD), utils.getProperty("userName"));
        utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("passWord"));
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
    }

    public void failedLogin(String username, String password) {
        utils.sendText(By.id(USENAME_FIELD), username);
        utils.sendText(By.id(PASSWORD_FIELD), password);
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
    }

    //TODO
    public void assertFailedLogin() {
        utils.assertURL("http://test01-web01/nxtiere2e");
    }

    public void OnLoginPage() {
        utils.assertURL("http://test01-web01/nxtiere2e");
    }


    public void loginAsAgent() {
        utils.waitForElementVisible(By.id(USENAME_FIELD));
        utils.clickBtn(By.id(USENAME_FIELD));
        utils.sendText(By.id(USENAME_FIELD), "agentlogin");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("userPassword"));
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }


    public void loginAsReseller() {
        utils.waitForElementVisible(By.id(USENAME_FIELD));
        utils.clickBtn(By.id(USENAME_FIELD));
        utils.sendText(By.id(USENAME_FIELD), "resellerlogin");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("userPassword"));
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }


    public void loginAsCP() {
        utils.waitForElementVisible(By.id(USENAME_FIELD));
        utils.clickBtn(By.id(USENAME_FIELD));
        utils.sendText(By.id(USENAME_FIELD), "cp");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), "password");
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }

    public void login(String userName, String passWord) {
        utils.clickBtn(By.id(USENAME_FIELD));
        utils.sendText(By.id(USENAME_FIELD), userName);
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), passWord);
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
    }
}


