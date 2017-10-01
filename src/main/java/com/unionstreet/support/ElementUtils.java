package com.unionstreet.support;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static com.unionstreet.support.BaseClass.driver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

public class ElementUtils {

    public static ResultSet result;
    public String parentWindow;
    private Properties prop;
    private FileInputStream fileInputStream;
    public static ArrayList allValues;
    public static String[] split;

public Wait waitForSomeTime(){
    Wait wait = new FluentWait(BaseClass.driver)
            .withTimeout(20, SECONDS)
            .pollingEvery(3, SECONDS)
            .ignoring(WebDriverException.class);
    return wait;
}

    public void findFieldAndSendKeys(By by, String filePath) {
        driver.findElement(by).sendKeys(filePath);
    }

    //method to find the element, clear the box if needed and send text
    public void sendText(By by, String txt) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(txt);
   }
   // method to click button with fluent wait
    public void clickBtnWithWait(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //method to click button
    public void clickBtn(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //method to assert element text
    public void verifyStringMatch(By by, String expectedString) {
        waitForSomeTime().until(ExpectedConditions.textToBePresentInElementLocated(by, expectedString));
        String actualString = driver.findElement(by).getText();
      assertEquals(expectedString, actualString);
    }

    public void assertURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        assertEquals(expectedURL, actualURL);
    }
    //explicit wait element to be present
    public void waitForElementVisible(By by)  {

        waitForSomeTime().until(ExpectedConditions.presenceOfElementLocated(by));}

    public void waitForElementToBeClickable(By by) {
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementVisibleForWLR3Page(By by) {
        waitForSomeTime().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementVisibleForOpenReach(By by) {
       waitForSomeTime().until(ExpectedConditions.presenceOfElementLocated(by));

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

    public void switchToNewWindowByJavaExeClick(By by) throws InterruptedException {
        parentWindow = driver.getWindowHandle();
        Thread.sleep(2000);
        javaScriptExecutorClick(by);
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                driver.manage().window().maximize();
            }
        }
    }
    public void closeCurrentWindowAndJump(By by) throws InterruptedException {
        String currentWindowHandle = driver.getWindowHandle();
        driver.findElement(by).click();
        Thread.sleep(2000);
        ArrayList<String> windowHandles = new ArrayList(driver.getWindowHandles());
        for (String window : windowHandles) {
            if (!window.equals(currentWindowHandle)) {
                driver.close();
                driver.switchTo().window(window);
                driver.manage().window().maximize();
            }
        }
    }

    //get properties method
    public String getProperty(String key) {

        try {
            prop = new Properties();
            fileInputStream = new FileInputStream("src/test/Resources/config.properties");
            prop.load(fileInputStream);

        } catch (IOException e) {
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
        waitForSomeTime().until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(number);
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
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                System.setProperty("webdriver.ie.driver", "DriverFiles\\IEDriverServer.exe");
                driver = new InternetExplorerDriver(capabilities);
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver","DriverFiles\\geckodriver.exe");
                driver = new FirefoxDriver();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public void jumpToPopUpWindow(By by)   {
        Set parentWindow = driver.getWindowHandles();
        clickBtnWithWait(by);
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
            driver.findElement(by).isDisplayed();
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

       public void javaScriptExecutorClick(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void switchToParentWindow() {
        driver.switchTo().window(parentWindow);
    }

    public void closeCurrentPage() {
        try {
            driver.close();
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
        String actualText = driver.findElement(by).getText();
        assertFalse(actualText.contains(searchText));
    }

    public void searchAndAssertTextPresent(By by, String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String actualText = driver.findElement(by).getText();
        assertTrue(actualText.contains(searchText));
    }

    public void makeSureBoxIsChecked(By by1, By by2) {
        WebElement element = driver.findElement(by1);
        if (element.isSelected()) {
        } else {
            javaScriptExecutorClick(by2);

        }
    }

    public void makeSureBoxIsUnChecked(By by1, By by2) {
        WebElement element = driver.findElement(by1);
        if (element.isSelected()) {
            javaScriptExecutorClick(by2);
        } else {
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void getOrdersPage() {
        try {
            driver.get("http://test01-web01/nxtiere2e/orders/ordersmanager");
        } catch (Exception e) {
            checkAlert();
        }
    }

    public void getLoginPage() {
        driver.get("http://test01-web01/nxtiere2e");
    }

    public void getDashBoardPage(String database) {
        try {
            driver.get("http://test01-web01" + database + "/Dashboard/index");
        } catch (Exception e) {
            checkAlert();
        }

    }

    public void getCpAddUserPage() {
        driver.get("http://test01-web01/nxtiere2e/CPUsers/CPUsersList");
    }

    public void assertElementNotPresent(By by) {
        List<WebElement> element = driver.findElements(by);
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
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
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
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(number));
    }

    public void getCreateCustomerPage() {
        driver.get("http://test01-web01/nxtiere2e/company/endcustomer?type=1");
    }

    public void checkPoint(String text) {
        System.out.println(text);
    }

    public void zoomOut() {
        try{for (int i = 0; i < 2; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_MINUS);

    }}catch (Exception e){}}

    public void setStdZoom(){
       try{ for (int i = 0; i < 2; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_EQUALS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_EQUALS);
        }
    }catch (Exception e){}}

    public void multipleCLick(By clickEle, By waitEle, int num) throws InterruptedException {
        for (int i = 0; i < num; i++) {

            try {
                waitForElementVisible(waitEle);
                WebDriverWait wait = new WebDriverWait(driver,15);
                wait.until(ExpectedConditions.visibilityOfElementLocated(clickEle));
                Thread.sleep(1000);
                javaScriptExecutorClick(clickEle);
            } catch (Exception e) {
                waitForElementVisible(waitEle);
                Thread.sleep(1000);
                javaScriptExecutorClick(clickEle);
            }
        }
    }

    public void captureScreenShot(String screenShotName) throws IOException {
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
        driver.navigate().back();

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
        driver.get("http://test01-web01/nxtiere2e/ServiceDesk/LogIncident/?SiteID=" + siteID + "");
        clickEnter();
    }

    public void loadBranchURLForServiceDesk(String port) {
        driver.get("http://test01-web01"+port+"/RajeshNB");
    }

    public void loadSipTrunkURL() {
        driver.get("https://159.8.174.54/portal/");
    }

    public void assertUnchecked(By by) {
        WebElement element = driver.findElement(by);
      assertFalse(element.isSelected());
    }

    public void assertChecked(By by) {
        WebElement element = driver.findElement(by);
        assertTrue(element.isSelected());
    }

    public void waitTillBoxChecked(By by) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void twoValueArrayList(String valueOne, String valueTwo) {
        allValues = new ArrayList();
        allValues.add("" + valueOne + "");
        allValues.add("" + valueTwo + "");
    }
    public void performClickActionTillElementIsDetected(By elementWanted, By clickElement) throws InterruptedException {
        driver.findElement(clickElement).click();
        if (driver.findElement(elementWanted).isDisplayed()) {
        } else {
            driver.findElement(clickElement).click();
        }
        waitForElementVisible(elementWanted);

    }
    public void splitString(By by){
        String currentSlot= driver.findElement(by).getText();
        split = currentSlot.split(" ");
    }

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

    public void rightCLick(By by){
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(by)).perform();

    }


}







