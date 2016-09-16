package com.unionstreet.NxTier.support;

import com.unionstreet.NxTier.pages.*;

public class WebModel {

    private ElementUtils Utils;
    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private NewBusinessCustomerPage newBusinessCustomerPage;
    private CompanyMenuPage companyMenuPage;
    private ContactManagerPage contactManagerPage;
    private SettingsPage settingsPage;

    public WebModel() {
        Utils = new ElementUtils();
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        newBusinessCustomerPage = new NewBusinessCustomerPage();
        companyMenuPage = new CompanyMenuPage();
        contactManagerPage = new ContactManagerPage();
        settingsPage = new SettingsPage();
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

}