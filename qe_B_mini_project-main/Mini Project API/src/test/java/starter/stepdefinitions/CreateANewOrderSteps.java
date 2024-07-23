package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateANewOrder;
public class CreateANewOrderSteps {
    @Steps
    CreateANewOrder createANewOrder;

    @Given("I set API endpoint for create a new order")
    public void setApiEndpoint(){createANewOrder.setApiEndpoint();}

    @When("I send request to create a new order with valid inputs")
    public void sendCreateAValidOrderRequest(){createANewOrder.sendCreateAValidOrderRequest();}

    @And("I receive data for created order")
    public void receiveValidOrder(){createANewOrder.receiveValidOrder();}

    @When("I send request to create a new order with invalid Product Id")
    public void sendCreateAInvalidProductIdOrderRequest(){createANewOrder.sendCreateAInvalidProductIdOrderRequest();}

    @When("I send request to create a new order with invalid quantity")
    public void sendCreateAInvalidQuantityOrderRequest(){createANewOrder.sendCreateAInvalidQuantityOrderRequest();}

    @And("I receive error create order")
    public void receiveErrorCreateOrder(){createANewOrder.receiveErrorCreateOrder();}
}
