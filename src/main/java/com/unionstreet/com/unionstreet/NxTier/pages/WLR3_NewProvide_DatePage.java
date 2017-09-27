package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 23/01/2017.
 */
public class WLR3_NewProvide_DatePage {

    public final String HAZARD_NOTES_TEXTBOX = "HazardNotesId";
    public final String WARNING_NOTES_TEXTBOX = "WarningNotesId";

    ElementUtils utils = new ElementUtils();


    public void populateHazardAndWarningNotesUnderDATE(String hazardNotes, String warningNotes) {
        try {
           utils.waitForElementVisible(By.id(HAZARD_NOTES_TEXTBOX));
            utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            utils.sendText(By.id(WARNING_NOTES_TEXTBOX), warningNotes);
        } catch (Exception e) {
            utils.waitForElementVisible(By.id(HAZARD_NOTES_TEXTBOX));
            try {
                utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            } catch (Exception e1) {
                utils.checkAlert();
                utils.sendText(By.id(HAZARD_NOTES_TEXTBOX), hazardNotes);
            }
            utils.sendText(By.id(WARNING_NOTES_TEXTBOX), warningNotes);
        }
    }
}
