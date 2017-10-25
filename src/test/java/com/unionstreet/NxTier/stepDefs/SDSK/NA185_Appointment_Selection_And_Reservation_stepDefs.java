package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by RajeshG on 23/10/2017.
 */
public class NA185_Appointment_Selection_And_Reservation_stepDefs {
    WebModel webModel = new WebModel();
    NA160_SDSK_Login_Incident__Triage_stepDefs na160 = new NA160_SDSK_Login_Incident__Triage_stepDefs();

    @When("^I am on ServiceDesk Ticket Details Page to Select  \"([^\"]*)\" and Reserve an Appointment$")
    public void iAmOnServiceDeskTicketDetailsPageToSelectAndReserveAnAppointment(String slotTime) throws Exception {
       webModel.getDashBoardPage().switchGateway("89.234.55.115");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"01142733952", "WLR3 ISDN 2e Standard", "1", "2", true,"SW14 8JP");
        webModel.getServiceDesk_ticketDetailsPage().BookAnAppointment(slotTime);
    }

    @Then("^I should be able to Reserve the Selected  \"([^\"]*)\"$")
    public void iShouldBeAbleToReserveTheSelected(String slotTime) throws Exception {
        webModel.getServiceDesk_ticketDetailsPage().AssertAppointmentIsReserved(slotTime);
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
    }

    @When("^I am on ServiceDesk Ticket Details Page to Cancel an Appointment$")
    public void iAmOnServiceDeskTicketDetailsPageToCancelAnAppointment() throws Exception {
        webModel.getDashBoardPage().switchGateway("89.234.55.115");
        na160.iNavigateToTheTriagePageOfTheIncidentWizard();
        webModel.getServiceDesk_callerDetailsTriagePage().openReachIncident_Triage(false);
        webModel.getServiceDesk_ticketDetailsPage().selectCLIToObtainInstallationDetails(false,"01142733952", "WLR3 ISDN 2e Standard", "1", "2", true,"SW14 8JP");
    }

    @Then("^I should not be able to Reserve the \"([^\"]*)\" Appointment$")
    public void iShouldNotBeAbleToReserveTheAppointment(String slotTime) throws Exception {
        webModel.getServiceDesk_ticketDetailsPage().CancelAnAppointment(slotTime);
        webModel.getDashBoardPage().switchGateway("10.1.9.112");
    }
}
