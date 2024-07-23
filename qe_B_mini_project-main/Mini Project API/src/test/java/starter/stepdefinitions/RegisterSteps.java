package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Register;

public class RegisterSteps {
    @Steps
    Register register;

    @Given("I set API endpoint for register")
    public void setApiEndpoint(){register.setApiEndpoint();}

    @When("I send request to register with valid input")
    public void sendValidRegisterRequest(){register.sendValidRegisterRequest();}

    @And("I receive registered account data")
    public void receiveRegisterAccountData(){register.receiveRegisterAccountData();}

    @When("I send request to register with existed input")
    public void sendExistedRegisterRequest(){register.sendExistedRegisterRequest();}

    @And("I receive register account error")
    public void receiveInvalidRegisterError(){register.receiveInvalidRegisterError();}

    @When("I send request to register with invalid email")
    public void sendInvalidEmailRegisterRequest(){register.sendInvalidEmailRegisterRequest();}

    @When("I send request to register with invalid password")
    public void sendInvalidPasswordRegisterRequest(){register.sendInvalidPasswordRegisterRequest();}

    @When("I send request to register with invalid full name")
    public void sendInvalidFullnameRegisterRequest(){register.sendInvalidFullnameRegisterRequest();}

}
