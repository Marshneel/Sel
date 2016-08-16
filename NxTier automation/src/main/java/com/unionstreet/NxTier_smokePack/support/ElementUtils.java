package com.unionstreet.NxTier_smokePack.support;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.unionstreet.NxTier_smokePack.support.BaseClass.driver;

public class ElementUtils {

    public String parentWindow;
    private Properties prop;
    private FileInputStream fileInputStream;


    //method to find the element, clear the box if needed and send text
    public void sendText(By by, String txt) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(txt);
    }

    //method to click button
    public void clickBtn(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    //method to assert element text
    public void verifyStringMatch(By by, String expectedString) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedString));
        String actualString = driver.findElement(by).getText();
        Assert.assertEquals(expectedString, actualString);
    }

    public void assertURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    //implicit wait
    public void timeOut() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    //explicit wait element to be present
    public void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //explicit wait element to be clickable
    public void waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //switching to new window
    public void switchToNewWindow() {
        parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
            }
        }
    }

    //get properties method
    public String getProperty(String key) {

        try {
            prop = new Properties();
            fileInputStream = new FileInputStream("src\\test\\Resources\\com.unionstreet.NxTier_smokePack\\config.properties");
            prop.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    //simulate keyboard enter press
    public void keyBoardEnter(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    //select data by visible text
    public void selectByVisibleText(By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select selectByVisibleText = new Select(driver.findElement(by));
        selectByVisibleText.selectByVisibleText(text);
    }

    //select date from drop down
    public void selectDay(By by, String number) {
        driver.findElement(by).sendKeys(number);
        driver.findElement(by).click();
    }

    //    //browser selector
    public WebDriver browser() {
        try {

            if (getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "DriverFiles\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                driver = new ChromeDriver(options);
            } else if (getProperty("browser").equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "DriverFiles\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    //browser popup
    public void browserPopUps() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {

        }
    }

    public void verifyElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeSelected(by));
        WebElement element = driver.findElement(by);
        Assert.assertEquals(true, element.isDisplayed());

    }

    public void jumpToPopUpWindow(By by) {
        Set parentWindow = driver.getWindowHandles();
        driver.findElement(by).click();
        Set afterPopup = driver.getWindowHandles();
        afterPopup.removeAll(parentWindow);
        if (afterPopup.size() == 1) {
            driver.switchTo().window((String) afterPopup.toArray()[0]);
        }
    }
}

