package com.unionstreet.NxTier_smokePack.pages;

import com.unionstreet.NxTier_smokePack.support.ElementUtils;
import org.openqa.selenium.By;
import static com.unionstreet.NxTier_smokePack.pages.NewBusinessCustomerPage.RanName;

public class ContactManagerPage {
    private final String SEARCH_BUTTON = "txtsearch";
    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();

    public void assertNewBusinessCustomer() {
        newBusinessCustomerPage.clickContactManagerButton();
        utils.sendText(By.id(SEARCH_BUTTON), RanName);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
        utils.verifyStringMatch(By.linkText(RanName), RanName);
    }
}