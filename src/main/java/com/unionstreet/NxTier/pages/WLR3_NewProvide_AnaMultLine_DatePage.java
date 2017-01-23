package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_AnaMultLine_DatePage {

    private final String HAZARD_NOTES_TEXTBOX = "HazardNotesId";
    private final String WARNING_NOTES_TEXTBOX = "WarningNotesId";

    ElementUtils utils = new ElementUtils();


    public void populateHazardAndWarningNotesUnderDATE(String hazardNotes, String warningNotes) {
        try {
            utils.waitForElementVisible(By.id(HAZARD_NOTES_TEXTBOX));
            utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            utils.sendText(By.id(WARNING_NOTES_TEXTBOX), warningNotes);
        } catch (Exception e) {
            utils.waitForElementVisible(By.id(HAZARD_NOTES_TEXTBOX));
            utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            utils.sendText(By.id(WARNING_NOTES_TEXTBOX), warningNotes);
        }
    }
}
