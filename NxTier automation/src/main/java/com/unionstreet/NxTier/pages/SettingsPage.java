package com.unionstreet.NxTier.pages;

import com.unionstreet.NxTier.support.ElementUtils;
import org.openqa.selenium.By;



/**
 * Created by rajeshg on 01/09/2016.
 */
public class SettingsPage  {
    private final String SETTINGS_BUTTON = "HrefSettings";
    private final String ADDPERMISSION_GROUPNAME = "GroupName";
    private final String AGENTPERMISSION_GROUPTYPE = "//input[@id='rdoGroupType'][@value='Agent']";
    private final String CPPERMISSION_GROUPTYPE =    "//input[@id='rdoGroupType'][@value='CP']";
    private final String ADDPERMISSION_CONFIGURATION = "//a[@href='#'][contains(text(),'Configuration')]";
    private final String CONFIGURATION_SELECTALL = "SelectAll_Configuration";
    private final String CONFIGURATION_AUTOEXPORTER = "//a[@href='#'][contains(text(),'Auto Exporter')]";
    private final String CONFIGURATION_AUTOEXPORTER_SELECTALL = "SelectAll_Configuration_AutoExporter";
    private final String CONFIGURATION_FREEMINUTES = "//a[@href='#'][contains(text(),'Free Minutes')]";
    private final String CONFIGURATION_FREEMINUTES_SELECTALL = "SelectAll_Configuration_FreeMinutes";
    private final String CONFIGURATION_PACKAGES = "//a[@href='#'][contains(text(),'Packages')]";
    private final String CONFIGURATION_PACKAGES_SELECTALL = "SelectAll_Configuration_Packages";
    private final String CONFIGURATION_SERVICEINVENTORY = "//a[@href='#'][contains(text(),'Service Inventory')]";
    private final String CONFIGURATION_SERVICEINVENTORY_SELECTALL = "SelectAll_Configuration_ServiceInventory";
    private final String CONFIGURATION_TARIFFMANAGER = "//a[@href='#'][contains(text(),'Tariff Manager')]";
    private final String CONFIGURATION_TARIFFMANAGER_SELECTALL = "SelectAll_Configuration_TariffManager";
    private final String ADDPERMISSIONS_CONTACTMANAGER = "//a[@href='#'][contains(text(),'Contact Manager')]";
    private final String CONTACTMANAGER_SELECTALL = "SelectAll_ContactManager";
    private final String CONTACTMANAGER_AGENT = "//a[@href='#'][contains(text(),'Agent')]";
    private final String CONTACTMANAGER_AGENT_SELECTALL = "SelectAll_ContactManager_Agent";
    private final String CONTACTMANAGER_AUTOEXPORTER = "//a[@href='#'][contains(text(),'Auto Exporter')]";
    private final String CONTACTMANAGER_AUTOEXPORTER_SELECTALL = "SelectAll_ContactManager_AutoExporter";
    private final String CONTACTMANAGER_CARRIERS = "//a[@href='#'][contains(text(),'Carriers')]";
    private final String CONTACTMANAGER_CARRIERS_SELECTALL = "SelectAll_ContactManager_Carriers";
    private final String CONTACTMANAGER_CUSTOMERS = "//a[@href='#'][contains(text(),'Customers')]";
    private final String CONTACTMANAGER_CUSTOMERS_SELECTALL = "SelectAll_ContactManager_Customers";
    private final String CONTACTMANAGER_OPERATORS = "//a[@href='#'][contains(text(),'Operators')]";
    private final String CONTACTMANAGER_OPERATORS_SELECTALL = "SelectAll_ContactManager_Operators";
    private final String CONTACTMANAGER_RESELLERS = "//a[@href='#'][contains(text(),'Resellers')]";
    private final String CONTACTMANAGER_RESELLERS_SELECTALL = "SelectAll_ContactManager_Resellers";
    private final String CONTACTMANAGER_SUPPLIERS = "//a[@href='#'][contains(text(),'Suppliers')]";
    private final String CONTACTMANAGER_SUPPLIERS_SELECTALL = "SelectAll_ContactManager_Suppliers";
    private final String ADDPERMISSIONS_IMPORTMANAGER = "//a[@href='#'][contains(text(),'Import Manager')]";
    private final String IMPORTMANAGER_SELECTALL = "SelectAll_ImportManager";
    private final String IMPORTMANAGER_AUTOEXPORTER = "//a[@href='#'][contains(text(),'Auto Exporter')]";
    private final String IMPORTMANAGER_AUTOEXPORTER_SELECTALL = "SelectAll_ImportManager_AutoExporter";
    private final String IMPORTMANAGER_DATAIMPORT = "//a[@href='#'][contains(text(),'Data Import')]";
    private final String DATAIMPORT_SELECTALL = "SelectAll_ImportManager_DataImport";
    private final String ADDPERMISSIONS_INVOICEMANAGER = "//a[@href='#'][contains(text(),'Invoice Manager')]";
    private final String INVOICEMANAGER_SELECTALL = "SelectAll_InvoiceManager";
    private final String ADDPERMISSIONS_ORDERSMANAGER = "//a[@href='#'][contains(text(),'Orders Manager')]";
    private final String ORDERSMANAGER_ORDERDETAILS = "//a[@href='#'][contains(text(),'Order Details')]";
    private final String ORDERDETAILS_SELECTALL = "SelectAll_OrdersManager_OrderDetails";
    private final String ORDERSMANAGER_ORDERS = "//a[@href='#'][contains(text(),'Orders')]";
    private final String ORDERS_SELECTALL = "SelectAll_OrdersManager_Orders";
    private final String ORDERS_UNCHECK_QUICKQUOTE = "OrdersManager_Orders_QuickQuoteOnly_view";
    private final String ADDPERMISSION_REPORTS = "//a[@href='#'][contains(text(),'Reports')]";
    private final String REPORTS_SELECTALL = "SelectAll_Reports";
    private final String ADDPERMISSION_REVENUEASSURANCE = "//a[@href='#'][contains(text(),'Revenue Assurance')]";
    private final String REVENUEASSURANCE_SELECTALL = "SelectAll_RevenueAssurance";
    private final String ADDPERMISSION_SETTINGS = "//a[@href='#'][contains(text(),'Settings')]";
    private final String SETTINGS_SELECTALL = "SelectAll_Settings";
    private final String SETTINGS_PERMISSIONGROUP = "//a[@href='#'][contains(text(),'Permission Group')]";
    private final String PERMISSIONGROUP_SELECTALL = "SelectAll_Settings_PermissionGroup";
    private final String ADDPERMISSIONS_WORKPLACE = "//a[@href='#'][contains(text(),'Workplace')]";
    private final String WORKPLACE_DASHBOARD = "//a[@href='#'][contains(text(),'Dashboard')]";
    private final String DASHBOARD_SELECTALL = "SelectAll_Workplace_Dashboard";
    private final String SAVEANDCLOSE = "//input[@value='Save & Close']";
    private final String LOGINUSERS_BUTTON = "//a[@href='/team3/cpusers/agentuserslist']";
    private final String ADDUSER_COMPANY = "CompanyList";
    private final String USERADD_LOGIN = "Add Login";
    private final String ADDUSERLOGIN_SITE = "siteContact_christian";
    private final String ADDUSERLOGIN_EMAIL = "siteContact_EMail";
    private final String ADDUSERLOGIN_LOGINTAB = "login_tab";
    private final String ADDUSERLOGIN_SELECTPERMISSION = "drpgid";
    private final String ADDUSERLOGIN_ISLOGINALLOWED = "IsLoginAllowed";
    private final String ADDUSERLOGIN_USENAME = "username";
    private final String ADDUSERLOGIN_PASSWORD = "password";
    private final String ADDLOGINUSERS = "Add";
    private final String COMPANYCONTACTS_BUTTON = "HrefCompanyContacts";
    private static String CP_RanName;

    ElementUtils utils = new ElementUtils();
    NewBusinessCustomerPage newBusinessCustomerPage = new NewBusinessCustomerPage();

    DashBoardPage dashBoardPage = new DashBoardPage();
    LoginPage loginPage = new LoginPage();

    public void clickSettingsButton() {
        utils.clickBtnWithWait(By.id(SETTINGS_BUTTON));
    }

    public void clickAddPermissionsButton() {
        utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
        utils.switchToNewWindow();
    }

    public void addAgentPermissionGroups_General() throws InterruptedException {
        try {
            utils.clickBtn(By.id(ADDPERMISSION_GROUPNAME));
            utils.sendText(By.id(ADDPERMISSION_GROUPNAME), newBusinessCustomerPage.RanName);
            utils.clickBtn(By.xpath(AGENTPERMISSION_GROUPTYPE));
        } catch (Exception e) {
        }
    }

    public void addPermissionGroups_Configuration() throws InterruptedException {
        try {
            utils.clickBtn(By.xpath(ADDPERMISSION_CONFIGURATION));
            utils.javaScriptExecutorClick(By.id(CONFIGURATION_SELECTALL));
            utils.clickBtn(By.xpath(CONFIGURATION_AUTOEXPORTER));
            utils.javaScriptExecutorClick(By.id(CONFIGURATION_AUTOEXPORTER_SELECTALL));
            utils.clickBtn(By.xpath(CONFIGURATION_FREEMINUTES));
            utils.javaScriptExecutorClick(By.id(CONFIGURATION_FREEMINUTES_SELECTALL));
            utils.clickBtn(By.xpath(CONFIGURATION_PACKAGES));
            utils.javaScriptExecutorClick(By.id(CONFIGURATION_PACKAGES_SELECTALL));
            utils.clickBtn(By.xpath(CONFIGURATION_SERVICEINVENTORY));
            utils.javaScriptExecutorClick(By.id(CONFIGURATION_SERVICEINVENTORY_SELECTALL));
            utils.clickBtn(By.xpath(CONFIGURATION_TARIFFMANAGER));
            utils.javaScriptExecutorClick(By.id(CONFIGURATION_TARIFFMANAGER_SELECTALL));
        } catch (Exception e) {
        }
    }

    public void addPermissionGroups_ContactManager() {

        utils.clickBtn(By.xpath(ADDPERMISSIONS_CONTACTMANAGER));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_AGENT));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_AGENT_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_AUTOEXPORTER));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_AUTOEXPORTER_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_CARRIERS));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_CARRIERS_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_CUSTOMERS));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_CUSTOMERS_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_OPERATORS));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_OPERATORS_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_RESELLERS));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_RESELLERS_SELECTALL));
        utils.clickBtn(By.xpath(CONTACTMANAGER_SUPPLIERS));
        utils.javaScriptExecutorClick(By.id(CONTACTMANAGER_SUPPLIERS_SELECTALL));
    }

    public void addPermissionGroups_ImportManager() {

        utils.clickBtn(By.xpath(ADDPERMISSIONS_IMPORTMANAGER));
        utils.javaScriptExecutorClick(By.id(IMPORTMANAGER_SELECTALL));
        utils.clickBtn(By.xpath(IMPORTMANAGER_AUTOEXPORTER));
        utils.javaScriptExecutorClick(By.id(IMPORTMANAGER_AUTOEXPORTER_SELECTALL));
        utils.clickBtn(By.xpath(IMPORTMANAGER_DATAIMPORT));
        utils.javaScriptExecutorClick(By.id(DATAIMPORT_SELECTALL));
    }

    public void addPermissionGroups_InvoiceManager() {

        utils.clickBtn(By.xpath(ADDPERMISSIONS_INVOICEMANAGER));
        utils.javaScriptExecutorClick(By.id(INVOICEMANAGER_SELECTALL));
    }

    public void addPermissionGroups_OrdersManager() {
        utils.javaScriptExecutorClick(By.xpath(ADDPERMISSIONS_ORDERSMANAGER));
        utils.clickBtn(By.xpath(ORDERSMANAGER_ORDERDETAILS));
        utils.javaScriptExecutorClick(By.id(ORDERDETAILS_SELECTALL));
        utils.clickBtn(By.xpath(ORDERSMANAGER_ORDERS));
        utils.javaScriptExecutorClick(By.id(ORDERS_SELECTALL));
        utils.javaScriptExecutorClick(By.id(ORDERS_UNCHECK_QUICKQUOTE));

    }

    public void addPermissionGroups_Reports() {
        utils.clickBtn(By.xpath(ADDPERMISSION_REPORTS));
        utils.javaScriptExecutorClick(By.id(REPORTS_SELECTALL));
    }

    public void addPermissionGroups_RevenueAssurance() {

        utils.clickBtn(By.xpath(ADDPERMISSION_REVENUEASSURANCE));
        utils.javaScriptExecutorClick(By.id(REVENUEASSURANCE_SELECTALL));
    }

    public void addPermissionGroups_Settings() {
        utils.clickBtn(By.xpath(ADDPERMISSION_SETTINGS));
        utils.javaScriptExecutorClick(By.id(SETTINGS_SELECTALL));
        utils.clickBtn(By.xpath(SETTINGS_PERMISSIONGROUP));
        utils.javaScriptExecutorClick(By.id(PERMISSIONGROUP_SELECTALL));
    }

    public void addPermissionGroups_WorkPlace() {
        utils.javaScriptExecutorClick(By.xpath(ADDPERMISSIONS_WORKPLACE));
        utils.clickBtn(By.xpath(WORKPLACE_DASHBOARD));
        utils.javaScriptExecutorClick(By.id(DASHBOARD_SELECTALL));
    }

    public void saveAndCloseAddPermissions() {
        utils.clickBtn(By.xpath(SAVEANDCLOSE));
        utils.switchToParentWindow();
    }

    public void clickLoginUsers() {
        utils.clickBtnWithWait(By.xpath(LOGINUSERS_BUTTON));
    }

    public void clickAddLoginUsersButton() {
        utils.waitForElementVisible(By.linkText(ADDLOGINUSERS));
        utils.jumpToPopUpWindow(By.linkText(ADDLOGINUSERS));
    }

    public void agentUserSelectCompany() throws InterruptedException {
        try {
            utils.selectByVisibleText(By.id(ADDUSER_COMPANY), newBusinessCustomerPage.RanName);
            utils.clickBtn(By.linkText(USERADD_LOGIN));
            utils.switchToNewWindow();
        } catch (Exception e) {
        }
    }

    public void agentUserAddContactDetails() throws InterruptedException {
        try {
            utils.clickBtn(By.id(ADDUSERLOGIN_SITE));
            utils.sendText(By.id(ADDUSERLOGIN_SITE), newBusinessCustomerPage.RanName);
            utils.clickBtn(By.id(ADDUSERLOGIN_EMAIL));
            utils.sendText(By.id(ADDUSERLOGIN_EMAIL), utils.getProperty("agentEmailAddress"));
        } catch (Exception e) {
        }
    }

    public void agentUserAddLoginDetails() throws InterruptedException {
        try {
            utils.clickBtn(By.id(ADDUSERLOGIN_LOGINTAB));
            utils.clickBtn(By.id(ADDUSERLOGIN_USENAME));
            utils.sendText(By.id(ADDUSERLOGIN_USENAME), newBusinessCustomerPage.RanName);
            utils.clickBtn(By.id(ADDUSERLOGIN_PASSWORD));
            utils.sendText(By.id(ADDUSERLOGIN_PASSWORD), utils.getProperty("userPassword"));
            utils.selectByVisibleText(By.id(ADDUSERLOGIN_SELECTPERMISSION), newBusinessCustomerPage.RanName);
            utils.javaScriptExecutorClick(By.id(ADDUSERLOGIN_ISLOGINALLOWED));
            utils.clickBtn(By.xpath(SAVEANDCLOSE));
            try {
                utils.checkAlert();
            } catch (Exception e) {
            }

          utils.switchToParentWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginAsAgent() throws InterruptedException {
        try {
            dashBoardPage.logOut();
            utils.sendText(By.id(loginPage.USENAME_FIELD), newBusinessCustomerPage.RanName);
            utils.sendText(By.id(loginPage.PASSWORD_FIELD), utils.getProperty("userPassword"));
            utils.clickBtn(By.cssSelector(loginPage.LOGINBUTTON));
            utils.verifyStringMatch(By.id(dashBoardPage.DASHBOARD_TITLE), "DASHBOARD");
        } catch (Exception e) {
        }
    }

/////////////////////////////////////Reseller//////////////////////////////////////////////////////////////////////

    public void clickCompanyContacts() {
        utils.clickBtn(By.id(COMPANYCONTACTS_BUTTON));
    }

    public void addNewCompanyContactButton() {
        try {
            utils.clickBtn(By.linkText(newBusinessCustomerPage.ADD_BUTTON));
            utils.switchToNewWindow();
        } catch (Exception e) {
        }
    }

    public void loginAsReseller() throws InterruptedException {
        try {
            dashBoardPage.logOut();
            utils.sendText(By.id(loginPage.USENAME_FIELD), newBusinessCustomerPage.RanName);
            utils.sendText(By.id(loginPage.PASSWORD_FIELD), utils.getProperty("userPassword"));
            utils.clickBtn(By.cssSelector(loginPage.LOGINBUTTON));
            utils.verifyStringMatch(By.id(dashBoardPage.DASHBOARD_TITLE), "DASHBOARD");
        } catch (Exception e) {
        }
    }

    ///////////////////////////////////////////////////////CP///////////////////////////////////////////////////////////////
    public void addCPPermissionGroups_General() {
        try {

            utils.clickBtn(By.id(ADDPERMISSION_GROUPNAME));
            CP_RanName = utils.randomName();
            utils.sendText(By.id(ADDPERMISSION_GROUPNAME), CP_RanName);
            utils.clickBtn(By.xpath(CPPERMISSION_GROUPTYPE));
        } catch (Exception e) {
        }
    }

    public void addCPloginUserSelectCompanyandSite() throws InterruptedException {
        try {
            utils.selectByIndex(By.id(ADDUSER_COMPANY), 1);
            utils.searchAndAssertTextPresent(By.id("light"), "TEAM3");
            utils.clickBtn(By.linkText(USERADD_LOGIN));
            utils.switchToNewWindow();
        } catch (Exception e) {
        }
    }

    public void createCPUserAddContactDetails() {
        try {
            utils.clickBtn(By.id(ADDUSERLOGIN_SITE));
            utils.sendText(By.id(ADDUSERLOGIN_SITE), CP_RanName);
            utils.clickBtn(By.id(ADDUSERLOGIN_EMAIL));
            utils.sendText(By.id(ADDUSERLOGIN_EMAIL), utils.getProperty("cpEmail"));

        } catch (Exception e) {
        }
    }

    public void createCPUserAddLoginDetails() throws InterruptedException {
        try {
            utils.clickBtn(By.id(ADDUSERLOGIN_LOGINTAB));
            utils.clickBtn(By.id(ADDUSERLOGIN_USENAME));
            utils.sendText(By.id(ADDUSERLOGIN_USENAME), CP_RanName);
            utils.clickBtn(By.id(ADDUSERLOGIN_PASSWORD));
            utils.sendText(By.id(ADDUSERLOGIN_PASSWORD), utils.getProperty("userPassword"));
            utils.selectByVisibleText(By.id(ADDUSERLOGIN_SELECTPERMISSION), CP_RanName);
            utils.javaScriptExecutorClick(By.id(ADDUSERLOGIN_ISLOGINALLOWED));
            utils.clickBtn(By.xpath(SAVEANDCLOSE));

            try {
                utils.checkAlert();
            } catch (Exception e) {
            }
            utils.switchToParentWindow();
        } catch (Exception e) {
        }
    }

    public void loginAsCpUser() throws InterruptedException {
        try {
            dashBoardPage.logOut();
            utils.sendText(By.id(loginPage.USENAME_FIELD), CP_RanName);
            utils.sendText(By.id(loginPage.PASSWORD_FIELD), utils.getProperty("userPassword"));
            utils.clickBtn(By.cssSelector(loginPage.LOGINBUTTON));
            utils.verifyStringMatch(By.id(dashBoardPage.DASHBOARD_TITLE), "DASHBOARD");
        } catch (Exception e) {
        }

    }

}