package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_EngineeringPage {

    private final String ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO = "WLR3Order_engineering_notes";
    private final String ENGINEERING_INFO_TEXT_UNDER_SITEINFO = "//legend[text()='Engineering Information']";

    ElementUtils utils = new ElementUtils();

    public void populatingEngineeringNotesUnderENGINEERING(String notes) {
        utils.waitForElementVisible(By.xpath(ENGINEERING_INFO_TEXT_UNDER_SITEINFO));
        utils.sendText(By.id(ENGINEERING_NOTES_TEXTBOX_UNDER_SITEINFO), notes);
    }

}
