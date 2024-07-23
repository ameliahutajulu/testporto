package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.AssignAProductRating;
public class AssignAProductRatingSteps {
    @Steps
    AssignAProductRating assignAProductRating;

    @Given("I set API endpoint with valid Id for rate product")
    public void setValidIdApiEndpoint(){assignAProductRating.setValidIdApiEndpoint();}

    @When("I send request to rate product with valid ID")
    public void sendDeleteValidProductRequest(){assignAProductRating.sendRateValidProductRequest();}

    @And("I receive rated product data")
    public void receiveValidRateProduct(){assignAProductRating.receiveValidRateProduct();}

    @Given("I set API endpoint with invalid Id for rate product")
    public void setInvalidIdApiEndpoint(){assignAProductRating.setInvalidIdApiEndpoint();}

    @Then("I send request to rate product with invalid ID")
    public void sendRateInvalidProductRequest(){assignAProductRating.sendRateInvalidProductRequest();}

    @Then("I receive status code 500")
    public void receiveStatusCode500(){assignAProductRating.receiveStatusCode500();}
}
