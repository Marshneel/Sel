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
    private WLR3_New_Provide_OrderPage wlr3_new_provide__orderPage;
    private AddSiteDetailsPage addSiteDetailsPage;
    private WLR3_NewProvide_SitePage wlr3_newProvide__sitePage;
    private WLR3_NewProvide_ProvisionPage wlr3_newProvide__provisionPage;
    private WLR3_NewProvide_EngineeringPage wlr3_newProvide__engineeringPage;
    private WLR3_NewProvide_FeaturesPage wlr3_newProvide__featuresPage;
    private WLR3_NewProvide_NumberingPage wlr3_newProvide__numberingPage;
    private WLR3_NewProvide_DatePage wlr3_newProvide__datePage;
    private WLR3_Modify_OrderPage wlr3_modify_orderPage;
    private WLR3_Cease_OrderPage wlr3_cease_orderPage;
    private WLR3_AddRemoveAuxLinePage wlr3_addRemoveAuxLinePage;
    private WLR3_BatchTransferPage wlr3_batchTransferPage;
    private WLR3_ChangeOfLineTypeOrderPage wlr3_changeOfLineTypeOrderPage;
    private WLR3_Line_Information_Page wlr3_line_information_page;
    private WLR3_BusinessContinuityPage wlr3_businessContinuityPage;
    private WLR3_Summary_Charges_Page wlr3_summary_charges_page;
    private ServiceDeskPage serviceDeskPage;
    private ConfigManagerPage configManagerPage;
    private CreateTariffPage createTariffPage;
    private ServiceDesk_LoginIncidentPage serviceDesk_loginIncidentPage;
    private SipTrunkPlus_DashBoardPage sipTrunkPlus_dashBoardPage;
    private SipTrunkPlus_AddResellerPage sipTrunkPlus_addResellerPage;

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
        wlr3_new_provide__orderPage = new WLR3_New_Provide_OrderPage();
        addSiteDetailsPage = new AddSiteDetailsPage();
        wlr3_newProvide__sitePage = new WLR3_NewProvide_SitePage();
        wlr3_newProvide__provisionPage = new WLR3_NewProvide_ProvisionPage();
        wlr3_newProvide__engineeringPage = new WLR3_NewProvide_EngineeringPage();
        wlr3_newProvide__featuresPage = new WLR3_NewProvide_FeaturesPage();
        wlr3_newProvide__numberingPage = new WLR3_NewProvide_NumberingPage();
        wlr3_newProvide__datePage = new WLR3_NewProvide_DatePage();
        wlr3_modify_orderPage = new WLR3_Modify_OrderPage();
        wlr3_cease_orderPage = new WLR3_Cease_OrderPage();
        wlr3_addRemoveAuxLinePage = new WLR3_AddRemoveAuxLinePage();
        wlr3_batchTransferPage = new WLR3_BatchTransferPage();
        wlr3_changeOfLineTypeOrderPage = new WLR3_ChangeOfLineTypeOrderPage();
        wlr3_line_information_page = new WLR3_Line_Information_Page();
        wlr3_businessContinuityPage = new WLR3_BusinessContinuityPage();
        wlr3_summary_charges_page = new WLR3_Summary_Charges_Page();
        serviceDeskPage = new ServiceDeskPage();
        configManagerPage = new ConfigManagerPage();
        createTariffPage = new CreateTariffPage();
        serviceDesk_loginIncidentPage = new ServiceDesk_LoginIncidentPage();
        sipTrunkPlus_dashBoardPage = new SipTrunkPlus_DashBoardPage();
        sipTrunkPlus_addResellerPage = new SipTrunkPlus_AddResellerPage();


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

    public WLR3_New_Provide_OrderPage getWlr3_new_provide__orderPage() {
        return wlr3_new_provide__orderPage;
    }

    public AddSiteDetailsPage getAddSiteDetailsPage() {
        return addSiteDetailsPage;
    }

    public WLR3_NewProvide_SitePage getwlr3_newProvide_anaMultLine_sitePage() {
        return wlr3_newProvide__sitePage;
    }

    public WLR3_NewProvide_ProvisionPage getWlr3_newProvide__provisionPage() {
        return wlr3_newProvide__provisionPage;
    }

    public WLR3_NewProvide_EngineeringPage getWlr3_newProvide__engineeringPage() {
        return wlr3_newProvide__engineeringPage;
    }

    public WLR3_NewProvide_FeaturesPage getWlr3_newProvide__featuresPage() {
        return wlr3_newProvide__featuresPage;
    }

    public WLR3_NewProvide_NumberingPage getWlr3_newProvide__numberingPage() {
        return wlr3_newProvide__numberingPage;
    }

    public WLR3_NewProvide_DatePage getWlr3_newProvide__datePage() {
        return wlr3_newProvide__datePage;
    }

    public WLR3_Modify_OrderPage getWlr3_modify_orderPage() {
        return wlr3_modify_orderPage;
    }

    public WLR3_Cease_OrderPage getWlr3_cease_orderPage() {
        return wlr3_cease_orderPage;
    }

    public WLR3_AddRemoveAuxLinePage getWlr3_addRemoveAuxLinePage() {
        return wlr3_addRemoveAuxLinePage;
    }

    public WLR3_BatchTransferPage getWlr3_batchTransferPage() {
        return wlr3_batchTransferPage;
    }

    public WLR3_ChangeOfLineTypeOrderPage getWlr3_changeOfLineTypeOrderPage() {
        return wlr3_changeOfLineTypeOrderPage;
    }

    public WLR3_Line_Information_Page getWlr3_line_information_page() {
        return wlr3_line_information_page;
    }

    public WLR3_BusinessContinuityPage getWlr3_businessContinuityPage() {
        return wlr3_businessContinuityPage;
    }

    public WLR3_Summary_Charges_Page getWlr3_summary_charges_page() {
        return wlr3_summary_charges_page;
    }

    public ServiceDeskPage getServiceDeskPage() {
        return serviceDeskPage;
    }

    public ConfigManagerPage getConfigManagerPage() {
        return configManagerPage;
    }

    public CreateTariffPage getCreateTariffPage() {
        return createTariffPage;
    }

    public ServiceDesk_LoginIncidentPage getServiceDesk_loginIncidentPage() {
        return serviceDesk_loginIncidentPage;
    }

    public SipTrunkPlus_DashBoardPage getSipTrunkPlus_dashBoardPage() {
        return sipTrunkPlus_dashBoardPage;
    }

    public SipTrunkPlus_AddResellerPage getSipTrunkPlus_addResellerPage() {
        return sipTrunkPlus_addResellerPage;
    }
}



