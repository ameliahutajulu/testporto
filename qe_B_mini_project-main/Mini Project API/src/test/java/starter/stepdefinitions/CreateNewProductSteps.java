package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateNewProduct;

public class CreateNewProductSteps {
    @Steps
    CreateNewProduct createNewProduct;

    @Given("I set API endpoint for create new product")
    public void setApiEndpoint() {
        createNewProduct.setApiEndpoint();
    }

    @When("I send request to create new product with valid inputs")
    public void sendCreatenewProductRequest() {
        createNewProduct.sendCreatenewProductRequest();
    }

    @And("I receive valid data for create new product")
    public void receiveValidCreatenewProduct() {
        createNewProduct.receiveValidCreatenewProduct();
    }
}