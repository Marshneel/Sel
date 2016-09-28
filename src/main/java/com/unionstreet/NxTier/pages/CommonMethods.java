package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by alexr on 20/09/2016.
 */
public class CommonMethods {
    public String LOCATED_COMPANY_NAME = "//a[contains(@href,'CustomerDashboard')]";
    public final String SEARCH_BUTTON = "txtsearch";
    public final String ADD_BUTTON = ".add";
    public final String SAVE_BUTTON = ".save";
    public final String SAVE_AND_CLOSE_BUTTON = ".save_close";
    public String companyText;

    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();

    public void search(String text) {
        utils.sendText(By.id(SEARCH_BUTTON), text);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
    }

    public void saveAndClosePage() {
        utils.clickBtn(By.cssSelector(SAVE_AND_CLOSE_BUTTON));
    }


    //Pass a company name, or a randomstring
    public void accessCompanyMenuNew(String companyText) {

        try {
            newBusinessCustomerPage.clickContactManagerButton();
            search(companyText);
            utils.clickBtn(By.xpath(LOCATED_COMPANY_NAME));
            utils.switchToNewWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}