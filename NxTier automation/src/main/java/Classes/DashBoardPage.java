package Classes;

import Utils.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by rajeshg on 20/07/2016.
 */
public class DashBoardPage {
    ElementUtils utils;
    public DashBoardPage(ElementUtils utils) {
        this.utils = utils;

    }
    public void assertLogin(){

        utils.check(By.id("menutitle"),"DASHBOARD");
    }

}
