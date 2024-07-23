package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.RegisterPage;
import starter.pages.LoginPage;

public class RegisterSteps {
    @Steps
    RegisterPage registerPage;
    @Steps
    LoginPage loginPage;

    @Given("I am on the register page Altashop")
    public void onRegisterPage(){
        registerPage.openUrl("https://alta-shop.vercel.app/auth/register");
        Assertions.assertTrue(registerPage.validateOnRegisterPage());
    }

    @When("I enter valid email")
    public void inputValidEmail(){registerPage.inputEmail("usethis@gmail.com");}

    @And("I enter valid password")
    public void inputValidPassword(){registerPage.inputPassword("usethis");}

    @And("I enter valid full name")
    public void inputValidFullName(){registerPage.inputFullName("full name");}

    @And("I click Register button")
    public void clickRegisterButton(){registerPage.clickRegisterButton();}

    @Then("I redirected to login page Altashop")
    public void toLoginPage(){
        Assertions.assertTrue(loginPage.validateOnLoginPage());
    }

    @When("I enter used email")
    public void inputUsedEmail(){registerPage.inputEmail("thisemail@gmail.com");}

    @Then("I redirected back to register page Altashop")
    public void backToRegisterPage(){
        Assertions.assertTrue(registerPage.validateOnRegisterPage());
    }

    @And("I receive error message")
    public void receiveErrorMessage(){
        Assertions.assertTrue(registerPage.validateAlertErrorIsDisplayed());
    }

    @And("I let full name empty")
    public void letFullNameEmpty(){registerPage.inputFullName("");}

    @When("I enter invalid email")
    public void inputInvalidEmail(){registerPage.inputEmail("isemail");}

    @And("I let password empty")
    public void letPasswordEmpty(){registerPage.inputPassword("");}
}
