package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateACommentForProduct;
public class CreateACommentForProductSteps {
    @Steps
    CreateACommentForProduct createACommentForProduct;

    @Given("I set API endpoint with valid Id for create product comment")
    public void setValidIdApiEndpoint(){createACommentForProduct.setValidIdApiEndpoint();}

    @When("I send request to create valid Id product comment")
    public void sendCreateValidProductCommentRequest(){createACommentForProduct.sendCreateValidProductCommentRequest();}

    @Given("I set API endpoint with invalid Id for create product comment")
    public void setInvalidIdApiEndpoint(){createACommentForProduct.setInvalidIdApiEndpoint();}

    @When("I send request to create invalid Id product comment")
    public void sendCreateInvalidProductCommentRequest(){createACommentForProduct.sendCreateInvalidProductCommentRequest();}

    @And("I receive data for product comment")
    public void receiveValidProductRating(){createACommentForProduct.receiveValidProductComment();}
}
