package Classes;

import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;



/**
 * Created by rajeshg on 19/07/2016.
 */
public class WebModel {
    public WebDriver driver;
    public ElementUtils utils;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;


    public WebModel(WebDriver driver) {
        this.driver = driver;
        utils = new ElementUtils(driver);
        loginPage = new LoginPage(utils);
        dashBoardPage = new DashBoardPage(utils);
    }

    public LoginPage loginScreen() {
        return loginPage;
    }

    public DashBoardPage dashBoardPage(){
        return dashBoardPage;
    }


    }
