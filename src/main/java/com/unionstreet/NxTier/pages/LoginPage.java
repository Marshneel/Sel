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
        utils.assertURL("http://webtester:81/team3");
    }

    public void OnLoginPage() {
        utils.assertURL("http://webtester:81/team3");
    }


    public void loginAsAgent() {
        try {
            utils.clickBtn(By.id(USENAME_FIELD));
            utils.sendText(By.id(USENAME_FIELD), "agentlogin");
            utils.clickBtn(By.id(PASSWORD_FIELD));
            utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("userPassword"));
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
        }
    }

    public void loginAsReseller() {
        try {
            utils.clickBtn(By.id(USENAME_FIELD));
            utils.sendText(By.id(USENAME_FIELD), "resellerlogin");
            utils.clickBtn(By.id(PASSWORD_FIELD));
            utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("userPassword"));
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
        }
    }

    public void loginAsCP() {
        try {
            utils.clickBtn(By.id(USENAME_FIELD));
            utils.sendText(By.id(USENAME_FIELD), "admin");
            utils.clickBtn(By.id(PASSWORD_FIELD));
            utils.sendText(By.id(PASSWORD_FIELD), "abcdef");
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
        }
    }

    }


