package Classes;


import Utils.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by rajeshg on 19/07/2016.
 */
public class LoginPage  {
    ElementUtils utils;
    public LoginPage(ElementUtils utils){
        this.utils=utils;
    }


    public void doLogin() {


        utils.clickElement(By.id("UserName"));
        utils.sendText(By.id("UserName"), "admin");
        utils.clickElement(By.id("Password"));
        utils.sendText(By.id("Password"), "abcdef");
        utils.clickBtn(By.className("DivButton"));
    }

}
