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

//    public WLR3_OrderDetails_Page wlr3_orderDetails_page;
//    private WLR3_OrderDetails_Installation_address wlr3_orderDetails_installation_address;
//    private WLR3_OrderDetails_lineNumbering wlr3_orderDetails_lineNumbering;
//    private WLR3_OrderDetails_Page_Appointment wlr3OrderDetailsPageAppointment;


    public WebModel() {
        utils = new ElementUtils();
        baseClass=new BaseClass();
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        newBusinessCustomerPage = new NewBusinessCustomerPage();
        companyMenuPage = new CompanyMenuPage();
        contactManagerPage = new ContactManagerPage();
        settingsPage = new SettingsPage();
        commonMethods = new CommonMethods();
        ordersManagerPage = new OrdersManagerPage();
        addServicePage = new AddServicePage();
//        wlr3_orderDetails_page=new WLR3_OrderDetails_Page();
//        wlr3_orderDetails_installation_address=new WLR3_OrderDetails_Installation_address();
//        wlr3_orderDetails_lineNumbering=new WLR3_OrderDetails_lineNumbering();
//        wlr3OrderDetailsPageAppointment=new WLR3_OrderDetails_Page_Appointment();


    }
public BaseClass getBaseClass(){
    return baseClass;
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

//    public WLR3_OrderDetails_Page getWlr3_orderDetails_page(){
//        return wlr3_orderDetails_page;
//    }
//    public WLR3_OrderDetails_Installation_address getWlr3_orderDetails_installation_address(){
//        return wlr3_orderDetails_installation_address;
//    }
//    public WLR3_OrderDetails_lineNumbering getWlr3_orderDetails_lineNumbering(){
//        return wlr3_orderDetails_lineNumbering;
//    }
//    public WLR3_OrderDetails_Page_Appointment getWlr3OrderDetailsPageAppointment(){
//        return wlr3OrderDetailsPageAppointment;
//    }


}