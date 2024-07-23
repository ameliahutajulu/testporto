package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetProductById;

public class GetProductByIdSteps {
    @Steps
    GetProductById getProductById;

    @Given("I set API endpoint with valid Id for get product")
    public void setValidIdApiEndpoint(){getProductById.setValidIdApiEndpoint();}

    @When("I send request to get valid Id product")
    public void sendGetValidProductRequest(){getProductById.sendGetValidProductRequest();}

    @And("I receive valid data for product")
    public void receiveValidProductData(){getProductById.receiveValidProductData();}

    @Given("I set API endpoint with invalid Id for get product")
    public void setInvalidIdApiEndpoint(){getProductById.setInvalidIdApiEndpoint();}

    @When("I send request to get invalid Id product")
    public void sendGetInvalidProductRequest(){getProductById.sendGetInvalidProductRequest();}

    @Then("I receive status code 404")
    public void receiveStatusCode404(){getProductById.receiveStatusCode404();}

    @And("I receive error for product")
    public void receiveInvalidProductError(){getProductById.receiveInvalidProductError();}

}
