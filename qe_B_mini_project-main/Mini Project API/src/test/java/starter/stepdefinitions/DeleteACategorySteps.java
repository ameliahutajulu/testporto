package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DeleteACategory;
public class DeleteACategorySteps {
    @Steps
    DeleteACategory deleteACategory;

    @Given("I set API endpoint with valid Id for delete category")
    public void setValidIdApiEndpoint(){deleteACategory.setValidIdApiEndpoint();}

    @When("I send request to delete category with valid ID")
    public void sendDeleteValidCategoryRequest(){deleteACategory.sendDeleteValidCategoryRequest();}

    @And("I receive deleted category data")
    public void receiveValidDeleteCategory(){deleteACategory.receiveValidDeleteCategory();}

    @Given("I set API endpoint with invalid Id for delete category")
    public void setInvalidIdApiEndpoint(){deleteACategory.setInvalidIdApiEndpoint();}

    @When("I send request to delete category with invalid ID")
    public void sendDeleteInvalidCategoryRequest(){deleteACategory.sendDeleteInvalidCategoryRequest();}

    @Given("I set API endpoint with Undefined Id for delete category")
    public void setUndefinedIdApiEndpoint(){deleteACategory.setUndefinedIdApiEndpoint();}

    @When("I send request to delete category with Undefined ID")
    public void sendDeleteUndefinedCategoryRequest(){deleteACategory.sendDeleteUndefinedCategoryRequest();}

}
