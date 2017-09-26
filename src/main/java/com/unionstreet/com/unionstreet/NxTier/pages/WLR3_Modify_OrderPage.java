package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 27/01/2017.
 */
public class WLR3_Modify_OrderPage {


    private final String ERROR_MESSAGE_ON_WLR3_ORDER_MODIFY_PAGE="//h5[text()='Sorry, this number cannot be processed for the following reason']";


    ElementUtils utils=new ElementUtils();
    CompanyMenuPage companyMenuPage=new CompanyMenuPage();
    WLR3_OrderDetails_Page wlr3_orderDetails_page=new WLR3_OrderDetails_Page();

    public void assertTextOnModifyOrderPage(){
        utils.waitForElementVisible(By.id(wlr3_orderDetails_page.MANUAL_ENTRY_TAB));

    }
    public void initiatingModifyOrderWithWrongCLI(){
        initiatingModifyOrder("01202300908","LU1 1DQ");
        utils.waitForElementVisible(By.xpath(ERROR_MESSAGE_ON_WLR3_ORDER_MODIFY_PAGE));
    }

    public void initiatingModifyOrder(String CLI, String postCode){
        utils.clickBtn(By.id(wlr3_orderDetails_page.MANUAL_ENTRY_TAB));
       // utils.waitForElementVisible(By.id(companyMenuPage.CLI_NUMBER_FIELD));
        utils.sendText(By.id(companyMenuPage.CLI_NUMBER_FIELD),CLI);
        utils.sendText(By.id(wlr3_orderDetails_page.POSTCODE_SEARCH_POSTCODE_FIELD),postCode);
       // utils.waitForElementVisible(By.id(wlr3_orderDetails_page.SAVE));
        utils.returnElement(By.id(wlr3_orderDetails_page.SAVE)).click();
    }
}
