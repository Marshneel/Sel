package com.unionstreet.NxTier.support;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class ElementUtils {

    public static ResultSet result;
    public String parentWindow;
    private Properties prop;
    private FileInputStream fileInputStream;
    public static ArrayList<String> allValues;
    public static String[] split;




    public Wait waitForSomeTime() {
        Wait wait = new FluentWait(BaseClass.driver)
                .withTimeout(20, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(WebDriverException.class);
        return wait;
    }

    public Wait waitForSomeTimeForWLR3() {
        Wait wait = new FluentWait(BaseClass.driver)
                .withTimeout(50, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(WebDriverException.class);
        return wait;
    }

    public Wait waitForSomeTimeForOpenReach() {
        Wait wait = new FluentWait(BaseClass.driver)
                .withTimeout(3000, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(WebDriverException.class);
        return wait;
    }

    public void findFieldAndSendKeys(By by, String filePath) {
        BaseClass.driver.findElement(by).sendKeys(filePath);
    }

    //method to find the element, clear the box if needed and send text
    public void sendText(By by, String txt) {
        waitForSomeTime().until(ExpectedConditions.visibilityOfElementLocated(by));
        BaseClass.driver.findElement(by).click();
        BaseClass.driver.findElement(by).clear();
        BaseClass.driver.findElement(by).sendKeys(txt);
    }

   // method to click button with fluent wait
    public void clickBtnWithWait(By by) {
//        Wait wait = new FluentWait(driver)
//                .withTimeout(20, SECONDS)
//                .pollingEvery(5, SECONDS)
//                .ignoring(WebDriverException.class);
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        BaseClass.driver.findElement(by).click();
    }

    //method to click button
    public void clickBtn(By by) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        BaseClass.driver.findElement(by).click();
        checkAlert();
    }


    //method to assert element text
    public void verifyStringMatch(By by, String expectedString) {
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, expectedString));
        String actualString = BaseClass.driver.findElement(by).getText();
        Assert.assertEquals(expectedString, actualString);
    }

    public void assertURL(String expectedURL) {
        String actualURL = BaseClass.driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    //explicit wait element to be present
    public void waitForElementVisible(By by) {
        waitForSomeTime().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementToBeClickable(By by) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementVisibleForWLR3Page(By by) {
        waitForSomeTimeForWLR3().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementVisibleForOpenReach(By by) {
        waitForSomeTimeForOpenReach().until(ExpectedConditions.presenceOfElementLocated(by));

    }

    //switching to new window
    public void switchToNewWindow() {
        parentWindow = BaseClass.driver.getWindowHandle();
        Set<String> handles = BaseClass.driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                BaseClass.driver.switchTo().window(windowHandle);
                BaseClass.driver.manage().window().maximize();

            }
        }
    }

    public void switchToNewWindowByJavaExeClick(By by) throws InterruptedException {
        parentWindow = BaseClass.driver.getWindowHandle();
        Thread.sleep(2000);
        javaScriptExecutorClick(by);
        Set<String> handles = BaseClass.driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                BaseClass.driver.switchTo().window(windowHandle);
                BaseClass.driver.manage().window().maximize();
            }
        }
    }
    public void closeCurrentWindowAndJump(By by) throws InterruptedException {
        String currentWindowHandle = BaseClass.driver.getWindowHandle();
        BaseClass.driver.findElement(by).click();
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList<String>(BaseClass.driver.getWindowHandles());
        for (String window : windowHandles) {
            if (!window.equals(currentWindowHandle)) {
                BaseClass.driver.close();
                BaseClass.driver.switchTo().window(window);
                BaseClass.driver.manage().window().maximize();
            }
        }
    }

    //get properties method
    public String getProperty(String key) {

        try {
            prop = new Properties();
            fileInputStream = new FileInputStream("src/test/Resources/config.properties");
            prop.load(fileInputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    //simulate keyboard enter press
    public void keyBoardEnter(By by) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        BaseClass.driver.findElement(by).sendKeys(Keys.ENTER);
    }

    //select data by visible text
    public void selectByVisibleText(By by, String text) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        Select select = new Select(BaseClass.driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By by, int number) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        Select select = new Select(BaseClass.driver.findElement(by));
        select.selectByIndex(number);
    }

    //select date from drop down
    public void selectDay(By by, String number) {
        BaseClass.driver.findElement(by).sendKeys(number);
        BaseClass.driver.findElement(by).click();
    }

    public String getCurrentDate(String format) {
        String date = new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
        return date;
    }
    //browser selector
    public WebDriver browser() {
         String browser=System.getProperty("browser");
        try {

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "DriverFiles\\chromedriver.exe");
                BaseClass.driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                System.setProperty("webdriver.ie.driver", "DriverFiles\\IEDriverServer.exe");
                BaseClass.driver = new InternetExplorerDriver(capabilities);
            } else if (browser.equalsIgnoreCase("firefox")) {
                BaseClass.driver = new FirefoxDriver();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseClass.driver;
    }

    public void jumpToPopUpWindow(By by) {
        Set parentWindow = BaseClass.driver.getWindowHandles();
        clickBtnWithWait(by);
        Set afterPopup = BaseClass.driver.getWindowHandles();
        afterPopup.removeAll(parentWindow);
        if (afterPopup.size() == 1) {
            BaseClass.driver.switchTo().window((String) afterPopup.toArray()[0]);
        }
    }

    public boolean isAlertPresent() {
        try {
            BaseClass.driver.switchTo().alert();
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
                Alert alert = BaseClass.driver.switchTo().alert();
                alert.accept();
            }
        } catch (Exception e) {

        }
    }

    public void checkAlertAndCLickEnter() {
        try {
            if (isAlertPresent() == true) {
                clickEnter();
            }
        } catch (Exception e) {

        }
    }

    public boolean isElementPresent(By by) {
        try {
            BaseClass.driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isElementAbsent(By by){
        try{
            BaseClass.utils.assertElementNotPresent(by);
            return true;
        }catch (AssertionError error){
            return false;
        }
    }

    public void navigateToEditOrderPopupAndClose(By by) throws InterruptedException {
        String currentWindowHandle = BaseClass.driver.getWindowHandle();
        BaseClass.driver.findElement(by).click();
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList<String>(BaseClass.driver.getWindowHandles());
        for (String window : windowHandles) {

            if (!window.equals(currentWindowHandle)) {
                BaseClass.driver.switchTo().window(window);
                BaseClass.driver.close();
            }
        }
        BaseClass.driver.switchTo().window(currentWindowHandle);
    }

       public void javaScriptExecutorClick(By by) {
        WebElement element = BaseClass.driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void switchToParentWindow() {
        BaseClass.driver.switchTo().window(parentWindow);
    }

    public void closeCurrentPage() {
        try {
            BaseClass.driver.close();
        } catch (Exception e) {
            checkAlert();
        }
    }

    public String randomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(6);
    }


    public void searchAndAssertTextNotPresent(By by, String searchText) {
        String actualText = BaseClass.driver.findElement(by).getText();
        Assert.assertFalse(actualText.contains(searchText));
    }

    public void searchAndAssertTextPresent(By by, String searchText) {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String actualText = BaseClass.driver.findElement(by).getText();
        Assert.assertTrue(actualText.contains(searchText));
    }

    public void makeSureBoxIsChecked(By by1, By by2) {
        WebElement element = BaseClass.driver.findElement(by1);
        if (element.isSelected() == true) {
        } else {
            javaScriptExecutorClick(by2);

        }
    }

    public void makeSureBoxIsUnChecked(By by1, By by2) {
        WebElement element = BaseClass.driver.findElement(by1);
        if (element.isSelected() == true) {
            javaScriptExecutorClick(by2);
        } else {
        }
    }

    public void refreshPage() {
        BaseClass.driver.navigate().refresh();
    }

    public void getOrdersPage() {
        try {
            BaseClass.driver.get("http://test01-web01/nxtiere2e/orders/ordersmanager");
        } catch (Exception e) {
            checkAlert();
        }
    }

    public void getLoginPage() {
        BaseClass.driver.get("http://test01-web01/nxtiere2e");
    }

    public void getDashBoardPage(String database) {
        try {
            BaseClass.driver.get("http://test01-web01" + database + "/Dashboard/index");
        } catch (Exception e) {
            checkAlert();
        }

    }

    public void getCpAddUserPage() {
        BaseClass.driver.get("http://test01-web01/nxtiere2e/CPUsers/CPUsersList");
    }

    public void assertElementNotPresent(By by) {
        List<WebElement> element = BaseClass.driver.findElements(by);
        assertTrue(element.isEmpty());
    }

    public String sqlQuery(String userN, String server, String database, String query) {
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
        return userN;
    }

    public String sqlExeQuery(String userN, String server, String database, String query) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
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
        return userN;
    }

    public String getAttributeOfElement(By by, String attribute) {
        return BaseClass.driver.findElement(by).getAttribute(attribute);
    }

    public void jumpToParentPopUp() {
        BaseClass.driver.switchTo().parentFrame();
    }

    public void clearText(By by) {
        BaseClass.driver.findElement(by).clear();
    }

    public void scrollUp(By by) throws InterruptedException {
        WebElement element = BaseClass.driver.findElement(by);
        ((JavascriptExecutor) BaseClass.driver).executeScript("arguments[0].scrollIntoView(true);", element);
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


    public void switchToPreviousWindow(int number) {
        ArrayList<String> tabs = new ArrayList(BaseClass.driver.getWindowHandles());
        BaseClass.driver.switchTo().window(tabs.get(number));
    }

    public void getCreateCustomerPage() {
        BaseClass.driver.get("http://test01-web01/nxtiere2e/company/endcustomer?type=1");
    }

    public void checkPoint(String text) {
        System.out.println(text);
    }

    public void zoomOut() throws AWTException {
        for (int i = 0; i < 2; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_MINUS);

    }}

    public void setStdZoom() throws AWTException {
        for (int i = 0; i < 2; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_EQUALS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_EQUALS);
        }
    }

    public void multipleCLick(By clickEle, By waitEle, int num) throws InterruptedException {
        for (int i = 0; i < num; i++) {

            try {
                waitForElementVisible(waitEle);
                waitForSomeTime().until(ExpectedConditions.visibilityOfElementLocated(clickEle));
                Thread.sleep(1000);
                javaScriptExecutorClick(clickEle);
            } catch (Exception e) {
                waitForElementVisible(waitEle);
                Thread.sleep(1000);
                javaScriptExecutorClick(clickEle);
            }
        }
    }

    public void captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./ScreenShots/" + screenShotName + ".png"));
        System.out.println("screenShot taken");
    }

    public void accessCMD(String command) throws Exception {

        List<String> fullcmd = new ArrayList<String>();
        fullcmd.add("cmd.exe");
        fullcmd.add("/c");
        fullcmd.add(command);
        ProcessBuilder builder = new ProcessBuilder(fullcmd);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

    public void scrollBack() {
        BaseClass.driver.navigate().back();

    }

    public void clickEnter() throws AWTException {

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (Exception e) {
        }

    }

    public void enterServiceDeskURLandCLickEnter(String siteID) throws AWTException {
        BaseClass.driver.get("http://test01-web01/nxtiere2e/ServiceDesk/LogIncident/?SiteID=" + siteID + "");
        clickEnter();
    }

    public void loadBranchURLForServiceDesk(String port) {
        BaseClass.driver.get("http://test01-web01"+port+"/RajeshNB");
    }

    public void loadSipTrunkURL() {
        BaseClass.driver.get("http://159.8.174.50:8080/#!login");
    }

    public void assertUnchecked(By by) {
        WebElement element = BaseClass.driver.findElement(by);
        Assert.assertFalse(element.isSelected());
    }

    public void assertChecked(By by) {
        WebElement element = BaseClass.driver.findElement(by);
        Assert.assertTrue(element.isSelected());
    }

    public void waitTillBoxChecked(By by) {
        waitForSomeTime().until(ExpectedConditions.elementToBeSelected(by));
    }

    public void navigateBack() {
        BaseClass.driver.navigate().back();
    }

    public void twoValueArrayList(String valueOne, String valueTwo) {
        allValues = new ArrayList<String>();
        allValues.add("" + valueOne + "");
        allValues.add("" + valueTwo + "");
    }

    //    public void loopThroughWebPagesUntilElementIsFound(By by) {
//        Iterator<String> iterate = driver.getWindowHandles().iterator();
//        String switchWindow = null;
//
//        while (iterate.hasNext()) {
//            WebElement element = driver.findElement(by);
//
//            if (!element.isDisplayed()) {
//                switchWindow = iterate.next();
//
//            }
//            if (switchWindow!= null) driver.switchTo().window(switchWindow);
//            break;
//        }
//    }
    public void performClickActionTillElementIsDetected(By elementWanted, By clickElement) {

        BaseClass.driver.findElement(clickElement).click();
        if (BaseClass.driver.findElement(elementWanted).isDisplayed()) {
        } else {
            BaseClass.driver.findElement(clickElement).click();
        }
        waitForElementVisible(elementWanted);

    }
    public void splitString(By by){
        String currentSlot= BaseClass.driver.findElement(by).getText();
        split = currentSlot.split(" ");
    }
    public static class LoadPayloads {

        public JSONObject getPayload(String fileName) {
            JSONParser jsonParser = new JSONParser();
            Object object = null;
            try {
                try {
                    object = jsonParser.parse(new FileReader(System.getProperty("user.dir") + "/src/main/PayLoad/" + fileName + ".json"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
            JSONObject json = (JSONObject) object;
            return json;
        }
    }


}







