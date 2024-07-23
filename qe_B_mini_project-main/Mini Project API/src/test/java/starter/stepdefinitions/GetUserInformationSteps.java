package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetUserInformation;
public class GetUserInformationSteps {
    @Steps
    GetUserInformation getUserInformation;

    @Given("I set API endpoint for get user information")
    public void setApiEndpoint(){getUserInformation.setApiEndpoint();}

    @When("I send request to user information")
    public void sendGetUserInformationRequest(){getUserInformation.sendGetUserInformationRequest();}

    @And("I receive valid data for user information")
    public void receiveUserInformation(){getUserInformation.receiveUserInformation();}
}
