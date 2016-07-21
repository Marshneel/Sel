package Utils;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by rajeshg on 19/07/2016.
 */
public class ElementUtils {
    WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;}

    //method to find the element and click
    public void clickElement(By by) {
        driver.findElement(by).click();}

    //method to find the element, clear the box if needed and send text
    public void sendText(By by, String txt) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(txt);}

    //method to click button
    public void clickBtn(By by) {
        driver.findElement(by).click();
    }

    //method to assert element text
    public void check(By by, String expectedstring) {
        String actualstring = driver.findElement(by).getText();
        Assert.assertEquals(expectedstring, actualstring);}

    //implicit wait
    public void timeOut() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);}

    //explicit wait
    public void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));}


    }
