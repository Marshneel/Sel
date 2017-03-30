package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by alexr on 20/09/2016.
 */
public class CommonMethods {
    public final String SEARCH_BUTTON = "txtsearch";
    public final String ADD_BUTTON = ".add";
    public final String SAVE_BUTTON = ".save";
    public final String SAVE_AND_CLOSE_BUTTON = ".save_close";
    public final String CLOSE_POPUP = "//div[@id='popupDiv']//button[@id='closeBtn']";

    ElementUtils utils = new ElementUtils();

    public void search(String text) {
        utils.waitForElementVisible(By.id(SEARCH_BUTTON));
        utils.sendText(By.id(SEARCH_BUTTON),text);
        utils.keyBoardEnter(By.id(SEARCH_BUTTON));
    }

    public void saveAndClosePage() {
        utils.clickBtn(By.cssSelector(SAVE_AND_CLOSE_BUTTON));
        try {
            utils.checkAlert();
        } catch (Exception e) {
        }
    }
}