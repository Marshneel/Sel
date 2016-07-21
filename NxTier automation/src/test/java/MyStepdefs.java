

import Classes.BaseClass;
import Classes.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



/**
 * Created by rajeshg on 19/07/2016.
 */
public class MyStepdefs {

    WebModel model = new WebModel(BaseClass.driver);


    @Given("^I am on login page$")
    public void iAmOnLoginPage() {
    model.loginScreen().doLogin();

    }
    @When("^I enter valid username and password$")
    public void iEnterValidUsernameAndPassword() {
    model.dashBoardPage().assertLogin();
    }
    @Then("^login is successful$")
    public void loginIsSuccessful() {

    }

}