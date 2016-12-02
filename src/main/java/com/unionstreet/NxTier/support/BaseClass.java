package com.unionstreet.NxTier.support;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;
    static ElementUtils utils = new ElementUtils();


//    @BeforeClass
//    public static void databaseRollBack() {
//        try {
//            //utils.restoreDB();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
    public  void tearDown() {
        driver.quit();

    }
    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\rajeshg\\IdeaProjects\\Sub-Master\\screenShot\\error.jpg"));
        }

    }}