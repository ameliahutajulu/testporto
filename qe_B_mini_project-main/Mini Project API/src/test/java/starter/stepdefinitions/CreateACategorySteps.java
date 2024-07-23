package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateACategory;

public class CreateACategorySteps {
    @Steps
    CreateACategory createACategory;

    @Given("I set API endpoint for create category")
    public void setApiEndpoint(){createACategory.setApiEndpoint();}

    @When("I send request to create category with valid input")
    public void sendCreateValidCategoryRequest(){createACategory.sendCreateValidCategoryRequest();}

    @And("I receive created category data")
    public void receiveValidCreatenewCategory(){createACategory.receiveValidCreatenewCategory();}

    @When("I send request to create category with invalid name")
    public void sendCreateInvalidCategoryNameRequest(){createACategory.sendCreateInvalidCategoryNameRequest();}

    @Then("I receive status code 400")
    public void receiveStatusCode400(){createACategory.receiveStatusCode400();}

    @And("I receive create category error")
    public void receiveInvalidCreatenewCategory(){createACategory.receiveInvalidCreatenewCategory();}

    @When("I send request to create category with invalid description")
    public void sendCreateInvalidCategoryDescriptionRequest(){createACategory.sendCreateInvalidCategoryDescriptionRequest();}
}
