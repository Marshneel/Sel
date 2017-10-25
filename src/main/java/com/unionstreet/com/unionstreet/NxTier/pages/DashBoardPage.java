package com.unionstreet.com.unionstreet.NxTier.pages;

import com.unionstreet.support.ElementUtils;
import org.openqa.selenium.By;


public class DashBoardPage {


    public final String DASHBOARD_TITLE = "sub-page-heading";
    public final String TEXT_ON_DASHBOARD_PAGE="//small[contains(text(),'Dashboard')]";
    //TODO
    public final String LOGOUT_BUTTON = "//a[contains(@href,'Logout')]";
    public final String QUOTE = "bodyContent";
    private final String ORDERSMANAGER_BUTTON = "//span[contains(text(),'Orders Manager')]";
    private final String CONTACT_MANAGER_BUTTON = "//span[contains(text(),'Contact Manager')]";
    private final String CONFIGMANAGER_BUTTON = "//span[contains(text(),'Config Manager')]";
    private final String SERVICEDESK_TAB="//span[contains(text(),'Service Desk')]";
    public final String LOAD_ENDCUSTOMERS="//a[contains(text(),'End Customers')]";
    public final String ALL_ORDERS_UNDER_ORDERS_MANAGER="//a[contains(text(),'All Orders')]";


    ElementUtils utils = new ElementUtils();
    CommonMethods commonMethods=new CommonMethods();
    public void assertLogin() {
        utils.waitForElementVisible(By.xpath(TEXT_ON_DASHBOARD_PAGE));
    }

    public void logOut() throws InterruptedException {
     try{   utils.clickBtn(By.xpath(LOGOUT_BUTTON));
    }catch (Exception e){ utils.clickBtn(By.cssSelector(commonMethods.LOGOUT_BUTTON));}}

    public void clickOrderManagerButton() throws InterruptedException {
        utils.clickBtn(By.xpath(ORDERSMANAGER_BUTTON));
    }
    public void loadAllOrders(boolean agent_reseller, boolean CP) throws InterruptedException {
       if(agent_reseller) {utils.clickBtn(By.xpath(ALL_ORDERS_UNDER_ORDERS_MANAGER));}
      if (CP){ utils.clickBtn(By.xpath(ALL_ORDERS_UNDER_ORDERS_MANAGER));
          utils.clickBtn(By.xpath("//a[@href='/nxtiere2e/orders/ordersmanager?Type=AllOrders&Ownership=All']"));}
    }

    public void clickContactManagerTab(){
            utils.clickBtn(By.xpath(CONTACT_MANAGER_BUTTON));
    }
    public void load_endCustomers() throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.xpath(LOAD_ENDCUSTOMERS));
    }

    public void loadServiceDesk()
    {
       try{ Thread.sleep(1000);}catch (Exception e){}
        utils.clickBtn(By.xpath(SERVICEDESK_TAB));
    }
    public void clickConfigManager() {
        utils.clickBtn(By.xpath(CONFIGMANAGER_BUTTON));
    }
    public void loadTariffManager() throws InterruptedException {
        Thread.sleep(1000);
        utils.clickBtn(By.xpath("//a[contains(text(),'Tariff Manager')]"));
    }
    public void loadFreeMinutes() {
        utils.clickBtn(By.xpath("//a[contains(text(),'Free Minutes')]"));
    }

  public void loadsalesCheckUnderRevenueAssurance(){
      utils.clickBtn(By.xpath("//a[contains(text(),'Sales Check')]"));
  }
  public void loadAgentsUnderContactManager(){
      utils.clickBtn(By.xpath("//a[contains(text(),'Agents')]"));
  }
public void switchGateway(String IPaddress) throws Exception {
   utils.sqlExeQuery("portal", "test01-sql01", "NxtierE2E", "update Defaultvalues set ValueString='"+IPaddress+"' where ID='760'");
    utils.sqlExeQuery("portal", "MOE\\DEVSQL2008", "Raj_BackUp_Of_Sn_DB_10_11_17", "update Defaultvalues set ValueString='"+IPaddress+"' where ID='760'");
   utils.accessCMDAndPowerShell("src\\test\\Resources\\WLR3Tools\\powershell.exe","Get-Service -Name Abillity_Server_PortalTest -ComputerName test01-ds01 | Restart-Service");
}

}
