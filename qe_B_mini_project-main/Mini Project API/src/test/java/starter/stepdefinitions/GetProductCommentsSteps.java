package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetProductComments;
public class GetProductCommentsSteps {
    @Steps
    GetProductComments getProductComments;

    @Given("I set API endpoint with valid Id for get product comments")
    public void setValidIdApiEndpoint(){getProductComments.setValidIdApiEndpoint();}

    @When("I send request to get valid Id product comments")
    public void sendGetValidProductCommentsRequest(){getProductComments.sendGetValidProductCommentsRequest();}

    @Given("I set API endpoint with invalid Id for get product comments")
    public void setInvalidIdApiEndpoint(){getProductComments.setInvalidIdApiEndpoint();}

    @When("I send request to get invalid Id product comments")
    public void sendGetInvalidProductCommentsRequest(){getProductComments.sendGetInvalidProductCommentsRequest();}

    @And("I receive data for product comments")
    public void receiveValidProductComments(){getProductComments.receiveValidProductComments();}
}
