package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 24/02/2017.
 */
public class WLR3_ChangeOfLineTypeOrderPage {

    private final String TEXT_ON_CHANGE_OF_LINE_TYPE_PAGE = "//div[@id='wlr3OrderDetailPopupDiv']//h3[contains(text(),'WLR3 Change Order')]";
private final String CONFIRM_OWNERSHIP_MESSAGE="//legend[text()='Confirm Change of Ownership']";
    private final String CONFIRM_MEMBERSHIP_CHECKBOX="ConfirmChangeOfOwnership";
    ElementUtils utils = new ElementUtils();
    WLR3_OrderDetails_Page wlr3_orderDetails_page = new WLR3_OrderDetails_Page();
    CompanyMenuPage companyMenuPage = new CompanyMenuPage();
    EditOrderPage editOrderPage=new EditOrderPage();

    public void addCLIsToTheOrder(String CLI, String postCode) {
        utils.waitForElementVisible(By.xpath(TEXT_ON_CHANGE_OF_LINE_TYPE_PAGE));
        //click add button with empty fields
        utils.clickBtn(By.id(wlr3_orderDetails_page.MANUAL_ENTRY_TAB));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD), CLI);
        utils.sendText(By.id(wlr3_orderDetails_page.POSTCODE_SEARCH_POSTCODE_FIELD), postCode);
        utils.clickBtn(By.id(wlr3_orderDetails_page.SAVE));

    }

    public void chooseLineType(String currentLine, String chooseLine) {
        utils.waitForElementVisible(By.xpath("//li[@class='LineTypeSelectionExistingProduct']//label[contains(text(),'" + currentLine + "')]"));
        utils.clickBtn(By.xpath("//li[contains(@onclick,'SelectLineType')]//label[contains(text(),'" + chooseLine + "')]"));
        utils.clickBtn(By.xpath(editOrderPage.VALIDATE_LINE_TYPE_BUTTON));
    }

    public void confirmationOfOwnerShipMessage() {
        utils.waitForElementVisible(By.xpath(CONFIRM_OWNERSHIP_MESSAGE));
        utils.waitForElementVisible(By.id(CONFIRM_MEMBERSHIP_CHECKBOX));
    }

}
