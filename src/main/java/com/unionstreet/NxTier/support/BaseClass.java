package com.unionstreet.NxTier.support;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;
    public static ElementUtils utils = new ElementUtils();

//    @BeforeClass
//    public static void databaseRollBack() {
//        try {
//            utils.restoreDB();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Before
    public void startUp() {

        try {
            driver = utils.browser();
            driver.get(utils.getProperty("url"));
            driver.manage().window().maximize();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            utils.captureScreenShot(driver, scenario.getName());
        }
        driver.close();
        driver.quit();
    }
}