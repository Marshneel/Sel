package Classes;


import Utils.ElementUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


/**
 * Created by rajeshg on 19/07/2016.
 */
public class BaseClass {
    public static  WebDriver driver;


    @Before
    public static void setUp()  {

        System.setProperty("webdriver.chrome.driver", "DriverFiles\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("http://webtester:82/team3");
        driver.manage().window().maximize();



    }

    @After
    public  static void tearDown() throws Exception {
        driver.quit();





    }
}
