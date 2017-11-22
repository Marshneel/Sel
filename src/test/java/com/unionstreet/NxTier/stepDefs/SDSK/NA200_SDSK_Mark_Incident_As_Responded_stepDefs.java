package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.sql.SQLException;

public class NA200_SDSK_Mark_Incident_As_Responded_stepDefs
{
    WebModel webModel=new WebModel();
    @When("^marked as responded and saved$")
    public void markedAsRespondedAndSaved() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnStatusChange("Queued","Waiting");
        webModel.getServiceDesk_actionsPage().clickdefaultActionCreatedOnStatusChange("Queued","Waiting");
        webModel.getServiceDesk_actionsPage().selectMarkAsRespondedCheckbox();
        webModel.getServiceDesk_actionsPage().saveActionPopUp();
    }




    @Then("^should be able to see the Marked as Responded checkbox ticked automatically and should be disabled$")
    public void shouldBeAbleToSeeTheMarkedAsRespondedCheckboxTickedAutomaticallyAndShouldBeDisabled()
    {
        webModel.getServiceDesk_actionsPage().assertDefaultActionCreatedOnStatusChange("Waiting","Complete");
        webModel.getServiceDesk_actionsPage().assertMarkAsRespondedIsCheckedAndIsNotEnabled();
    }

    @Then("^should be able to validate that mark as responded checkbox is unchecked$")
    public void shouldBeAbleToValidateThatMarkAsRespondedCheckboxIsUnchecked() throws java.lang.InterruptedException
    {
       //webModel.getServiceDesk_actionsPage().clickdefaultActionCreatedOnStatusChange("Queued","Waiting");
        webModel.getServiceDesk_actionsPage().ClickOnLoggedWithOpenReachAction();
        webModel.getServiceDesk_actionsPage().assertMarkAsRespondedIsUnchecked();
        webModel.getServiceDesk_actionsPage().saveActionPopUp();
    }

    @Then("^I should be able to assert default action is created$")
    public void iShouldBeAbleToAssertDefaultActionIsCreated() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().assertRespondedActionEntry();
    }

    @And("^should be able to see Mark as Responded checkbox in all the actions modal$")
    public void shouldBeAbleToSeeMarkAsRespondedCheckboxInAllTheActionsModal() throws InterruptedException,SQLException
    {
         webModel.getServiceDesk_actionsPage().clickdefaultActionCreatedOnStatusChange("Queued","Waiting");
         webModel.getServiceDesk_actionsPage().assertMarkAsRespondedIsCheckedAndIsNotEnabled();
         webModel.getServiceDesk_actionsPage().saveActionPopUp();
    }

    @And("^should be able to assert Mark as Responded checkbox is absent in all the actions modal once responded$")
    public void shouldBeAbleToAssertMarkAsRespondedCheckboxIsAbsentInAllTheActionsModalOnceResponded() throws InterruptedException
    {
       webModel.getServiceDesk_actionsPage().navigateToNewActionsPopup("Made call");
       webModel.getServiceDesk_actionsPage().assertAbsenceOfMarkAsRespondedCheckbox();

    }

    @Then("^should be able to validate the Marked as Responded checkbox is not present once status is changed to final status$")
    public void shouldBeAbleToValidateTheMarkedAsRespondedCheckboxIsNotPresentOnceStatusIsChangedToFinalStatus()
    {
        webModel.getServiceDesk_actionsPage().clickdefaultActionCreatedOnStatusChange("Waiting","Complete");
        webModel.getServiceDesk_actionsPage().assertAbsenceOfMarkAsRespondedCheckbox();
    }

    @When("^marked as responded checkbox is ticked$")
    public void markedAsRespondedCheckboxIsTicked() throws InterruptedException
    {

        webModel.getServiceDesk_actionsPage().ClickOnLoggedWithOpenReachAction();
        webModel.getServiceDesk_actionsPage().selectMarkAsRespondedCheckbox();
        webModel.getServiceDesk_actionsPage().saveActionPopUp();
    }

    @Then("^should be able to assert that a default action Responded has been created$")
    public void shouldBeAbleToAssertThatADefaultActionRespondedHasBeenCreated() throws InterruptedException
    {
        webModel.getServiceDesk_actionsPage().assertRespondedActionEntry();
    }

    @And("^should be able to validate the Marked as Responded checkbox is not present once responded$")
    public void shouldBeAbleToValidateTheMarkedAsRespondedCheckboxIsNotPresentOnceResponded()
    {
        webModel.getServiceDesk_actionsPage().assertAbsenceOfMarkAsRespondedCheckbox();
    }
}
