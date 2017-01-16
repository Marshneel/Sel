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
    private WLR_and_NxTierServicesPage wlr_and_nxTierServicesPage;
    private NxTierServicesPage nxTierServicesPage;
    private EditOrderPage editOrderPage;
    private WLR3_LineNumberingPage wlr3_lineNumberingPage;
    private WLR3_InstallationAddressPage wlr3_installationAddressPage;
    private WLR3_AppointmentPage wlr3_appointmentPage;
    private WLR3_SiteInformationPage wlr3_siteInformationPage;
    private WLR3_DirectoryInformationPage wlr3_directoryInformationPage;
    private WLR3_NetworkCallingFeaturesPage wlr3_networkCallingFeaturesPage;
    private WLR3_New_Provide_Analogue_Multiline_OrderPage wlr3_new_provide_analogue_multiline_orderPage;
    private AddSiteDetailsPage addSiteDetailsPage;


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
        wlr_and_nxTierServicesPage = new WLR_and_NxTierServicesPage();
        nxTierServicesPage = new NxTierServicesPage();
        editOrderPage = new EditOrderPage();
        wlr3_lineNumberingPage = new WLR3_LineNumberingPage();
        wlr3_installationAddressPage = new WLR3_InstallationAddressPage();
        wlr3_appointmentPage = new WLR3_AppointmentPage();
        wlr3_siteInformationPage = new WLR3_SiteInformationPage();
        wlr3_directoryInformationPage = new WLR3_DirectoryInformationPage();
        wlr3_networkCallingFeaturesPage = new WLR3_NetworkCallingFeaturesPage();
        wlr3_new_provide_analogue_multiline_orderPage = new WLR3_New_Provide_Analogue_Multiline_OrderPage();
        addSiteDetailsPage = new AddSiteDetailsPage();
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

    public WLR_and_NxTierServicesPage getWlr_and_nxTierServicesPage() {
        return wlr_and_nxTierServicesPage;
    }

    public NxTierServicesPage getNxTierServicesPage() {
        return nxTierServicesPage;
    }

    public EditOrderPage getEditOrderPage() {
        return editOrderPage;
    }

    public WLR3_LineNumberingPage getWlr3_lineNumberingPage() {
        return wlr3_lineNumberingPage;
    }

    public WLR3_InstallationAddressPage getWlr3_installationAddressPage() {
        return wlr3_installationAddressPage;
    }

    public WLR3_AppointmentPage getWlr3_appointmentPage() {
        return wlr3_appointmentPage;
    }

    public WLR3_SiteInformationPage getWlr3_siteInformationPage() {
        return wlr3_siteInformationPage;
    }

    public WLR3_DirectoryInformationPage getWlr3_directoryInformationPage() {
        return wlr3_directoryInformationPage;
    }

    public WLR3_NetworkCallingFeaturesPage getWlr3_networkCallingFeaturesPage() {
        return wlr3_networkCallingFeaturesPage;
    }

    public WLR3_New_Provide_Analogue_Multiline_OrderPage getWlr3_new_provide_analogue_multiline_orderPage() {
        return wlr3_new_provide_analogue_multiline_orderPage;
    }

    public AddSiteDetailsPage addSiteDetailsPage() {
        return addSiteDetailsPage;
    }
}
