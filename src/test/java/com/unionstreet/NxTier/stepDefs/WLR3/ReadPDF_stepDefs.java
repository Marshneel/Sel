package com.unionstreet.NxTier.stepDefs.WLR3;

import com.unionstreet.support.WebModel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by RajeshG on 25/10/2017.
 */
public class ReadPDF_stepDefs {

    WebModel webModel=new WebModel();
    @Given("^I execute the method that reads particular PDF$")
    public void iExecuteTheMethodThatReadsParticularPDF() throws IOException {
     try{   webModel.getUtils().readPDFfile("C:\\Users\\rajeshg\\Downloads\\ReadFile.pdf");}catch (Exception e){
         System.out.println("file not found");
     }
    }

    @Then("^I should be able to do get text out of it$")
    public void iShouldBeAbleToDoGetTextOutOfIt() {
        Assert.assertTrue(webModel.getUtils().file.contains("gurrala"));
    }
}
