package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetAllCategories;

public class GetAllCategoriesSteps {
    @Steps
    GetAllCategories getAllCategories;

    @Given("I set API endpoint for get all categories")
    public void setApiEndpoint() {
        getAllCategories.setApiEndpoint();
    }

    @When("I send request to get all categories")
    public void sendGetAllCategoriesRequest() {
        getAllCategories.sendGetAllCategoriesRequest();
    }

    @And("I receive valid data for all categories")
    public void receiveValidCategoriesData() {
        getAllCategories.receiveValidCategoriesData();
    }

}
