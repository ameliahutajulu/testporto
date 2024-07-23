package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.RegisterPage;
import starter.pages.LoginPage;
import starter.pages.DashboardPage;
public class LoginSteps {
    @Steps
    RegisterPage registerPage;
    @Steps
    LoginPage loginPage;

    @Steps
    DashboardPage dashboardPage;

    @Given("I am on the login page Altashop")
    public void onLoginPage(){
        loginPage.openUrl("https://alta-shop.vercel.app/auth/login");
        Assertions.assertTrue(loginPage.validateOnLoginPage());
    }

    @When("I enter valid email Login")
    public void inputValidEmailLogin(){registerPage.inputEmail("thisemail@gmail.com");}

    @And("I enter valid password Login")
    public void inputValidPasswordLogin(){registerPage.inputPassword("password");}

    @And("I click Login button")
    public void clickLoginButton(){loginPage.clickLoginButton();}

    @Then("I redirected to dashboard page Altashop")
    public void toDashboardPage(){
        Assertions.assertTrue(dashboardPage.validateOnDashboardPage());
        }

    @When("I enter invalid email Login")
    public void inputInvalidEmailLogin(){registerPage.inputEmail("notmail");}

    @Then("I redirected back to login page Altashop")
    public void backToLoginPage(){
        Assertions.assertTrue(loginPage.validateOnLoginPage());
    }

    @And("I enter invalid password Login")
    public void inputInvalidPasswordLogin(){registerPage.inputPassword("notpassword");}
}
