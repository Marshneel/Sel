package com.unionstreet.NxTier.support;

import com.unionstreet.NxTier.pages.*;

public class WebModel {

    private ElementUtils utils;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private NewBusinessCustomerPage newBusinessCustomerPage;
    private CompanyMenuPage companyMenuPage;
    private ContactManagerPage contactManagerPage;
    private SettingsPage settingsPage;
    private CommonMethods commonMethods;

    public WebModel() {
        utils = new ElementUtils();
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        newBusinessCustomerPage = new NewBusinessCustomerPage();
        companyMenuPage = new CompanyMenuPage();
        contactManagerPage = new ContactManagerPage();
        settingsPage = new SettingsPage();
        commonMethods = new CommonMethods();
    }

    public ElementUtils getUtils(){
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

    public CommonMethods getCommonMethods() { return commonMethods; }

}