package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetProductRating;

public class GetProductRatingSteps {
    @Steps
    GetProductRating getProductRating;

    @Given("I set API endpoint with valid Id for get product rating")
    public void setValidIdApiEndpoint(){getProductRating.setValidIdApiEndpoint();}

    @When("I send request to get valid Id product rating")
    public void sendGetValidProductRatingRequest(){getProductRating.sendGetValidProductRatingRequest();}

    @Given("I set API endpoint with invalid Id for get product rating")
    public void setInvalidIdApiEndpoint(){getProductRating.setInvalidIdApiEndpoint();}

    @When("I send request to get invalid Id product rating")
    public void sendGetInvalidProductRatingRequest(){getProductRating.sendGetInvalidProductRatingRequest();}

    @And("I receive data for product rating")
    public void receiveValidProductRating(){getProductRating.receiveValidProductRating();}
}
