package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Login;
public class LoginSteps {
    @Steps
    Login login;

    @Given("I set API endpoint for login")
    public void setApiEndpoint(){login.setApiEndpoint();}

    @When("I send request to login with valid input")
    public void sendValidLoginRequest(){login.sendValidLoginRequest();}

    @And("I receive logged in account data")
    public void receiveLoginAccountData(){login.receiveLoginAccountData();}

    @When("I send request to login with non exist input")
    public void sendNonExistLoginRequest(){login.sendNonExistLoginRequest();}

    @When("I send request to login with invalid email")
    public void sendInvalidEmailLoginRequest(){login.sendInvalidEmailLoginRequest();}

    @When("I send request to login with invalid password")
    public void sendInvalidPasswordLoginRequest(){login.sendInvalidPasswordLoginRequest();}

    @And("I receive login account error")
    public void receiveInvalidLoginError(){login.receiveInvalidLoginError();}
}
