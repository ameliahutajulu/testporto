package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetAllOrders;
public class GetAllOrdersSteps {
    @Steps
    GetAllOrders getAllOrders;

    @Given("I set API endpoint for get all orders")
    public void setApiEndpoint() {
        getAllOrders.setApiEndpoint();
    }

    @When("I send request to get all orders")
    public void sendGetAllOrdersRequest() {
        getAllOrders.sendGetAllOrdersRequest();
    }

    @And("I receive valid data for all orders")
    public void receiveValidOrdersData() {
        getAllOrders.receiveValidOrdersData();
    }

}
