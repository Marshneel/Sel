package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

public class ContactManagerPage {
    public final String SEARCH_BUTTON = "txtsearch";
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();

    public void assertNewBusinessCustomer() throws InterruptedException {
        try {
            newBusinessCustomerPage.clickContactManagerButton();
            utils.sendText(By.id(SEARCH_BUTTON), newBusinessCustomerPage.RanName);
            utils.keyBoardEnter(By.id(SEARCH_BUTTON));
            utils.verifyStringMatch(By.linkText(newBusinessCustomerPage.RanName), newBusinessCustomerPage.RanName);
        } catch (Exception e) {
        }
    }
}