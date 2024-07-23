package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DeleteAProduct;

public class DeleteAProductSteps {
    @Steps
    DeleteAProduct deleteAProduct;

    @Given("I set API endpoint with valid Id for delete product")
    public void setValidIdApiEndpoint(){deleteAProduct.setValidIdApiEndpoint();}

    @When("I send request to delete product with valid ID")
    public void sendDeleteValidProductRequest(){deleteAProduct.sendDeleteValidProductRequest();}

    @And("I receive deleted product data")
    public void receiveValidDeleteProduct(){deleteAProduct.receiveValidDeleteProduct();}

    @Given("I set API endpoint with invalid Id for delete product")
    public void setInvalidIdApiEndpoint(){deleteAProduct.setInvalidIdApiEndpoint();}

    @When("I send request to delete product with invalid ID")
    public void sendDeleteInvalidProductRequest(){deleteAProduct.sendDeleteInvalidProductRequest();}

    @Given("I set API endpoint with Undefined Id for delete product")
    public void setUndefinedIdApiEndpoint(){deleteAProduct.setUndefinedIdApiEndpoint();}

    @When("I send request to delete product with Undefined ID")
    public void sendDeleteUndefinedProductRequest(){deleteAProduct.sendDeleteUndefinedProductRequest();}

    @Then("I receive status code 405")
    public void receiveStatusCode405(){deleteAProduct.receiveStatusCode405();}
}
