package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class LoginPage {
    public final String USERNAME_FIELD = "UserName";
    public final String PASSWORD_FIELD = "Password";
    //TODO
    public final String LOGINBUTTON = ".DivButton";
    ElementUtils utils = new ElementUtils();


    public void doLogin() throws InterruptedException {
        try {
            utils.waitForElementVisible(By.id(USERNAME_FIELD));
            utils.sendText(By.id(USERNAME_FIELD), utils.getProperty("userName"));
        } catch (Exception e) {
            utils.getLoginPage();
            utils.waitForElementVisible(By.id(USERNAME_FIELD));
            utils.sendText(By.id(USERNAME_FIELD), utils.getProperty("userName"));
        }
        utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("passWord"));
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
    }


    public void failedLogin(String username, String password) {
        utils.sendText(By.id(USERNAME_FIELD), username);
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


    public void loginAsAgent() throws InterruptedException {
        utils.waitForElementVisible(By.id(USERNAME_FIELD));
        utils.clickBtn(By.id(USERNAME_FIELD));
        utils.sendText(By.id(USERNAME_FIELD), "agentlogin");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), "password");
        try {
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
            utils.checkAlert();
        }
    }

    public void loginAsReseller() throws InterruptedException {
        utils.waitForElementVisible(By.id(USERNAME_FIELD));
        utils.clickBtn(By.id(USERNAME_FIELD));
        utils.sendText(By.id(USERNAME_FIELD), "resellerlogin");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), utils.getProperty("userPassword"));
        try {
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
            utils.checkAlert();
        }
    }

    public void loginAsCP() throws InterruptedException {
        Thread.sleep(2000);
        utils.waitForElementVisible(By.id(USERNAME_FIELD));
        //utils.clickBtn(By.id(USERNAME_FIELD));
        utils.sendText(By.id(USERNAME_FIELD), "cplogin");
       // utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), "password");
        try {
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
            utils.checkAlert();
        }
    }

    public void login(String userName, String passWord) throws InterruptedException {
        utils.waitForElementVisible(By.id(USERNAME_FIELD));
        utils.clickBtn(By.id(USERNAME_FIELD));
        utils.sendText(By.id(USERNAME_FIELD), userName);
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), passWord);
        utils.clickBtn(By.cssSelector(LOGINBUTTON));
    }
    public void loginAsAdamR() throws InterruptedException {
        utils.waitForElementVisible(By.id(USERNAME_FIELD));
        utils.clickBtn(By.id(USERNAME_FIELD));
        utils.sendText(By.id(USERNAME_FIELD), "AdamR");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), "password");
        try {
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
            utils.checkAlert();
        }
    } public void loginAsAgentAdam() throws InterruptedException {
        utils.loadBranchURLForServiceDesk("");
        utils.waitForElementVisible(By.id(USERNAME_FIELD));
        utils.clickBtn(By.id(USERNAME_FIELD));
        utils.sendText(By.id(USERNAME_FIELD), "agentAdam");
        utils.clickBtn(By.id(PASSWORD_FIELD));
        utils.sendText(By.id(PASSWORD_FIELD), "abcdef");
        try {
            utils.clickBtn(By.cssSelector(LOGINBUTTON));
        } catch (Exception e) {
            utils.checkAlert();
        }
    }

    public void loginAsMasterUser() throws InterruptedException {
        utils.loadSipTrunkURL();
        utils.waitForElementVisible(By.id("gwt-uid-3"));
        utils.sendText(By.id("gwt-uid-3"),"autotest01");
        utils.waitForElementVisible(By.id("gwt-uid-5"));
        utils.sendText(By.id("gwt-uid-5"),"nOnzksled8");
        utils.waitForElementVisible(By.xpath("//span[contains(text(),'Sign In')]"));
        Thread.sleep(1000);
        utils.javaScriptExecutorClick(By.xpath("//span[contains(text(),'Sign In')]"));
        utils.waitForElementVisible(By.xpath("//div[contains(text(),'SIP Trunk Plus by 500 Limited')]"));


    }
}


