package com.unionstreet.NxTier.support;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class BaseClass {

    public static WebDriver driver;
    static ElementUtils utils = new ElementUtils();

    @Before
    public void startUp() {

        try {
            driver = utils.browser();
            driver.manage().deleteAllCookies();
            driver.get(utils.getProperty("url"));
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
       driver.quit();
    }
}
