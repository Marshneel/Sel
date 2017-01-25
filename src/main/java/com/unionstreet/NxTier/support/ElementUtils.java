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
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static com.unionstreet.NxTier.support.BaseClass.driver;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class ElementUtils {

    public static ResultSet result;
    public String parentWindow;
    private Properties prop;
    private FileInputStream fileInputStream;

    public Wait waitForSomeTime() {
        Wait wait = new FluentWait(driver)
                .withTimeout(20, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        return wait;
    }

    public Wait waitForSomeTimeForWLR3() {
        Wait wait = new FluentWait(driver)
                .withTimeout(50, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        return wait;
    }

    //method to find the element, clear the box if needed and send text
    public void sendText(By by, String txt) {
        waitForSomeTime().until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(txt);
    }

    //method to click button with fluent wait
    public void clickBtnWithWait(By by) {
        Wait wait = new FluentWait(driver)
                .withTimeout(20, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    //method to click button
    public void clickBtn(By by) {
        waitForSomeTime().until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

    //method to assert element text
    public void verifyStringMatch(By by, String expectedString) {
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, expectedString));
        String actualString = driver.findElement(by).getText();
        Assert.assertEquals(expectedString, actualString);
    }

    public void assertURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    //implicit wait
    public void timeOut() {
        driver.manage().timeouts().implicitlyWait(2000, MILLISECONDS);
    }

    //explicit wait element to be present
    public void waitForElementVisible(By by) {
        waitForSomeTime().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementVisibleForWLR3Page(By by) {
        waitForSomeTimeForWLR3().until(ExpectedConditions.presenceOfElementLocated(by));
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
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    //select data by visible text
    public void selectByVisibleText(By by, String text) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By by, int number) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    //select date from drop down
    public void selectDay(By by, String number) {
        driver.findElement(by).sendKeys(number);
        driver.findElement(by).click();
    }

    //browser selector
    public WebDriver browser() {
        try {
                String browser=System.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "DriverFiles\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--dns-prefetch-disable");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "DriverFiles\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public void jumpToPopUpWindow(By by) {
        Set parentWindow = driver.getWindowHandles();
        clickBtnWithWait(by);
        Set afterPopup = driver.getWindowHandles();
        afterPopup.removeAll(parentWindow);
        if (afterPopup.size() == 1) {
            driver.switchTo().window((String) afterPopup.toArray()[0]);
        }
    }

    public void jumpToPopUpWindowByJavaExeClick(By by) {
        Set parentWindow = driver.getWindowHandles();
        javaScriptExecutorClick(by);
        Set afterPopup = driver.getWindowHandles();
        afterPopup.removeAll(parentWindow);
        if (afterPopup.size() == 1) {
            driver.switchTo().window((String) afterPopup.toArray()[0]);
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }   // catch
    }

    //exception handling
    public void checkAlert() {
        try {
            if (isAlertPresent()) {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        } catch (Exception e) {

        }
    }

    public void closePopup(By by) throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(by).click();
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        for (String window : windowHandles) {

            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindowHandle);
    }

    public void closeCurrentWindowAndJump(By by) throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(by).click();
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        for (String window : windowHandles) {
            if (!window.equals(currentWindowHandle)) {
                driver.close();
                driver.switchTo().window(window);
                driver.manage().window().maximize();
            }
        }
    }

    public void pageJumpWithoutClose(By by) throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(by).click();
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        for (String window : windowHandles) {

            if (!window.equals(currentWindowHandle)) {
                driver.switchTo().window(window);
            }
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
        try {
            checkAlert();
        } catch (Exception e) {
        }
    }

    public String randomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }


    public void searchAndAssertTextNotPresent(By by, String searchText) {
        String actualText = driver.findElement(by).getText();
        Assert.assertFalse(actualText.contains(searchText));
    }

    public void searchAndAssertTextPresent(By by, String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void getOrdersPage() {
        driver.get("http://test01-web01/nxtiere2e/orders/ordersmanager");
    }

    public void getLoginPage() {
        driver.get("http://test01-web01/nxtiere2e");
    }

    public void getDashBoardPage() {
        driver.get("http://test01-web01/nxtiere2e/Dashboard/index");
    }

    public void getCpAddUserPage() {
        driver.get("http://test01-web01/nxtiere2e/CPUsers/CPUsersList");
    }

    public void assertElementNotPresent(By by) {
        List<WebElement> element = driver.findElements(by);
        assertTrue(element.isEmpty());
    }

    public void sqlQuery(String userN, String server, String database, String query) {
        try {

            String userName = "" + userN + "";
            String password = "Password1";
            String url = "jdbc:sqlserver://" + server + "" + ";databaseName=" + database + "";
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement statement;
            statement = con.createStatement();
            result = statement.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqlExeQuery(String userN, String server, String database, String query) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        try {
            String userName = "" + userN + "";
            String password = "Password1";
            String url = "jdbc:sqlserver://" + server + "" + ";databaseName=" + database + "";
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement statement;
            statement = con.createStatement();
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAttributeOfElement(By by, String attribute) {
        return driver.findElement(by).getAttribute(attribute);
    }

    public void jumpToParentPopUp() {
        driver.switchTo().parentFrame();
    }

    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    public void scrollUp(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
    }

    public void waitForElementToVanish(By by) {
        waitForSomeTime().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void restoreDB() {
        try {
            String str = "/*KILL CONNS*/  " +
                    "USE master;   " +
                    "  " +
                    ";SET NOCOUNT ON;   " +
                    "DECLARE @DBName varchar(50);   " +
                    "DECLARE @spidstr varchar(8000);   " +
                    "DECLARE @ConnKilled smallint;   " +
                    "SET @ConnKilled=0;   " +
                    "SET @spidstr = '';   " +
                    "  " +
                    "Set @DBName = 'Rajesh';   " +
                    "IF db_id(@DBName) < 4  " +
                    "BEGIN  " +
                    "PRINT 'Connections to system databases cannot be killed';   " +
                    "RETURN " +
                    "END  " +
                    ";SELECT @spidstr=coalesce(@spidstr,',' )+'kill '+convert(varchar, spid)+ '; '  " +
                    "FROM master..sysprocesses WHERE dbid=db_id(@DBName);   " +
                    "  " +
                    "IF LEN(@spidstr) > 0  " +
                    "BEGIN  " +
                    "EXEC(@spidstr);   " +
                    "\tSELECT @ConnKilled = COUNT(1)  " +
                    "\tFROM master..sysprocesses WHERE dbid=db_id(@DBName);   " +
                    "END  " +
                    "  " +
                    "/*RESTORE DB*/   " +
                    "RESTORE DATABASE [Raj] FROM  DISK = N'F:\\Backups\\Raj\\Raj.bak' " +
                    " WITH  FILE = 1,  NOUNLOAD,  REPLACE,  STATS = 10;  " +
                    " Select 1 As restored";
            this.sqlQuery("Nxtiere2e", "test01-sql01", "nxtiere2e", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToPreviousWindow() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void getCreateCustomerPage() {
        driver.get("http://test01-web01/nxtiere2e/company/endcustomer?type=1");
    }

    public void checkPoint(String text) {
        System.out.println(text);
    }

    public void zoomOut(By by) {
        for (int i = 0; i < 3; i++) {
            driver.findElement(by).sendKeys(Keys.CONTROL, Keys.SUBTRACT);
        }
    }

    public void zoomIn(By by) {
        for (int i = 0; i < 3; i++) {
            driver.findElement(by).sendKeys(Keys.CONTROL, Keys.ADD);
        }
    }

}