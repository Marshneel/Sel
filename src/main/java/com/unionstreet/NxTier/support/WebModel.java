package com.unionstreet.NxTier.support;

import com.unionstreet.NxTier.pages.*;

public class WebModel {

    private ElementUtils utils;
    private BaseClass baseClass;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private NewBusinessCustomerPage newBusinessCustomerPage;
    private CompanyMenuPage companyMenuPage;
    private ContactManagerPage contactManagerPage;
    private SettingsPage settingsPage;
    private CommonMethods commonMethods;
    private OrdersManagerPage ordersManagerPage;
    private AddServicePage addServicePage;
    private WLR3_OrderDetails_Page wlr3_orderDetails_page;


    public WebModel() {
        utils = new ElementUtils();
        baseClass = new BaseClass();
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        newBusinessCustomerPage = new NewBusinessCustomerPage();
        companyMenuPage = new CompanyMenuPage();
        contactManagerPage = new ContactManagerPage();
        settingsPage = new SettingsPage();
        commonMethods = new CommonMethods();
        ordersManagerPage = new OrdersManagerPage();
        addServicePage = new AddServicePage();
        wlr3_orderDetails_page = new WLR3_OrderDetails_Page();


    }

    public ElementUtils getUtils() {
        return utils;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public DashBoardPage getDashBoardPage() {
        return dashBoardPage;
    }

    public NewBusinessCustomerPage getNewBusinessCustomerPage() {
        return newBusinessCustomerPage;
    }

    public CompanyMenuPage getCompanyMenuPage() {
        return companyMenuPage;
    }

    public ContactManagerPage getContactManagerPage() {
        return contactManagerPage;
    }

    public SettingsPage getSettingsPage() {
        return settingsPage;
    }

    public CommonMethods getCommonMethods() {
        return commonMethods;
    }

    public OrdersManagerPage getOrdersManagerPage() {
        return ordersManagerPage;
    }

    public AddServicePage getAddServicePage() {
        return addServicePage;
    }

    public WLR3_OrderDetails_Page getWlr3_orderDetails_page() {
        return wlr3_orderDetails_page;
    }

}


