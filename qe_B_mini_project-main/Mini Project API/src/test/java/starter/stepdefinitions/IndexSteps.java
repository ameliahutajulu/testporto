package starter.stepdefinitions;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Index;
public class IndexSteps {
    @Steps
    Index index;

    @Given("I set API endpoint for get hello Index")
    public void setApiEndpoint(){index.setApiEndpoint();}

    @When("I send request to get hello Index")
    public void sendGetIndexRequest(){index.sendGetIndexRequest();}

    @And("I receive valid data for hello Index")
    public void receiveIndexHello(){index.receiveIndexHello();}
}
