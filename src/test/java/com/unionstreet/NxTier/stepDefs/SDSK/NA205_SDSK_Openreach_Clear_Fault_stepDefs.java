package com.unionstreet.NxTier.stepDefs.SDSK;

import com.unionstreet.support.WebModel;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class NA205_SDSK_Openreach_Clear_Fault_stepDefs
{
    WebModel webModel=new WebModel();
    NA166_SDSK_OpenReach_LineTest_stepDefs na166 = new NA166_SDSK_OpenReach_LineTest_stepDefs();
    @When("^clicking on clear option from Options dropdown$")
    public void clickingOnClearOptionFromOptionsDropdown()
    {
        webModel.getUtils().clickBtn(By.xpath("//a[contains(text(),'OPTIONS')]"));
        webModel.getUtils().clickBtn(By.id("modal_ServiceDesk_EditIncident_OpenreachClearIncident"));
    }

    @Then("^I should be able to see a Modal with clear reasons in the dropdown and Notes Section$")
    public void iShouldBeAbleToSeeAModalWithClearReasonsInTheDropdownAndNotesSection()
    {

        webModel.getServiceDesk_actionsPage().ClearFaultOptionPopup();

    }

    @And("^should be able to create an action and update the Status Description in the OpenReach fault details panel$")
    public void shouldBeAbleToCreateAnActionAndUpdateTheStatusDescriptionInTheOpenReachFaultDetailsPanel()
    {
        webModel.getUtils().waitForElementVisible(By.xpath("//h4[contains(text(),'Openreach fault details')]"));
        webModel.getUtils().searchAndAssertTextPresent(By.xpath("//div[contains(text(),'Fault Cleared sent to openreach')]"),"Fault Cleared sent to openreach");
        // write code for default action created
    }
}
