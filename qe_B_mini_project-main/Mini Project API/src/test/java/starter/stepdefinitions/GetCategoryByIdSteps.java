package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetCategoryById;

public class GetCategoryByIdSteps {
    @Steps
    GetCategoryById getCategoryById;

    @Given("I set API endpoint with valid Id for get category")
    public void setValidIdApiEndpoint(){getCategoryById.setValidIdApiEndpoint();}

    @When("I send request to get valid Id category")
    public void sendGetValidCategoryRequest(){getCategoryById.sendGetValidCategoryRequest();}

    @And("I receive valid data for category")
    public void receiveValidCategoryData(){getCategoryById.receiveValidCategoryData();}

    @Given("I set API endpoint with invalid Id for get category")
    public void setInvalidIdApiEndpoint(){getCategoryById.setInvalidIdApiEndpoint();}

    @When("I send request to get invalid Id category")
    public void sendGetInvalidCategoryRequest(){getCategoryById.sendGetInvalidCategoryRequest();}

    @And("I receive error for category")
    public void receiveInvalidCategoryError(){getCategoryById.receiveInvalidCategoryError();}
}
