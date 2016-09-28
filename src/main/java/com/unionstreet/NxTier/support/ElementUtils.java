package com.unionstreet.NxTier.support;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static com.unionstreet.NxTier.support.BaseClass.driver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

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

    //method to click button with fluent wait
    public void clickBtnWithWait(By by) {
        Wait wait = new FluentWait(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }


    //method to click button
    public void clickBtn(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    //method to assert element text
    public void verifyStringMatch(By by, String expectedString) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
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
        driver.manage().timeouts().implicitlyWait(100, SECONDS);
    }

    //explicit wait element to be present
    public void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
            fileInputStream = new FileInputStream("src\\test\\Resources\\com\\unionstreet\\NxTier\\config.properties");
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
    public void selectByVisibleText(By by, String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By by, int number) {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
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


    public void jumpToPopUpWindow(By by) {
        Set parentWindow = driver.getWindowHandles();
        driver.findElement(by).click();
        Set afterPopup = driver.getWindowHandles();
        afterPopup.removeAll(parentWindow);
        if (afterPopup.size() == 1) {
            driver.switchTo().window((String) afterPopup.toArray()[0]);
        }
    }

    //exception handling
    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {

        }
    }

    public void javaScriptExecutorClick(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


    public void switchToParentWindow() {
        driver.switchTo().window(parentWindow);
    }

    public void closeCurrentPage() {
        driver.close();
    }

    public String randomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public void assertTheElementAndTextPresent(By by, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.textToBe(by, expectedText));
        String actualText = driver.findElement(by).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void searchAndAssertTextNotPresent(By by, String searchText) {
        String actualText = driver.findElement(by).getText();
        Assert.assertFalse(actualText.contains(searchText));
    }

    public void searchAndAssertTextPresent(By by, String searchText) throws InterruptedException {
        String actualText = driver.findElement(by).getText();
        Assert.assertTrue(actualText.contains(searchText));
    }

    public void makeSureBoxIsChecked(By by1, By by2) {
        WebElement element = driver.findElement(by1);
        if (element.isSelected() == true) {
        } else {
            javaScriptExecutorClick(by2);
        }
    }

    public void makeSureBoxIsUnChecked(By by1, By by2) {
        WebElement element = driver.findElement(by1);
        if (element.isSelected() == true) {
            javaScriptExecutorClick(by2);
        } else {
        }

    }
    public void refreshCurrentURL(){
        String pageURL = driver.getCurrentUrl();
        driver.get(pageURL);

    }
    public void assertElementNotPresent(By by){
        List<WebElement> element = driver.findElements(by);
        assertTrue(element.isEmpty());
    }

}


