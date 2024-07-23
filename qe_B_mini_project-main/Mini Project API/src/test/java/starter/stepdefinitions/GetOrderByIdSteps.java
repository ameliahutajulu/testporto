package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetOrderById;
public class GetOrderByIdSteps {
    @Steps
    GetOrderById getOrderById;

    @Given("I set API endpoint with valid Id for get order")
    public void setValidIdApiEndpoint(){getOrderById.setValidIdApiEndpoint();}

    @When("I send request to get valid Id order")
    public void sendGetValidOrderRequest(){getOrderById.sendGetValidOrderRequest();}

    @And("I receive valid data for order")
    public void receiveValidOrderData(){getOrderById.receiveValidOrderData();}

    @Given("I set API endpoint with invalid Id for get order")
    public void setInvalidIdApiEndpoint(){getOrderById.setInvalidIdApiEndpoint();}

    @When("I send request to get invalid Id order")
    public void sendGetInvalidOrderRequest(){getOrderById.sendGetInvalidOrderRequest();}

    @And("I receive error for order")
    public void receiveInvalidOrderError(){getOrderById.receiveInvalidOrderError();}

}
