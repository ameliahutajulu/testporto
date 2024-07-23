package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import starter.pages.DashboardPage;
import starter.pages.DetailPage;
import starter.pages.CartPage;
import starter.pages.TransactionsPage;
public class ProductsSteps {
    @Steps
    DashboardPage dashboardPage;
    @Steps
    DetailPage detailPage;
    @Steps
    CartPage cartPage;
    @Steps
    TransactionsPage transactionsPage;

    @When("I click on product detail")
    public void clickDetailButton(){dashboardPage.clickDetailButton();}

    @Then("I redirected to product detail page")
    public void validateOnDetailPage(){
        Assertions.assertTrue(detailPage.validateOnDetailPage());
    }

    @When("I click on category field")
    public void clickCategoryField(){dashboardPage.clickCategoryField();}

    @And("I click on one of the option")
    public void clickCategoryOption(){dashboardPage.clickCategoryOption();}

    @Then("Product with specific category will appears \\(if there are any)")
    public void validateClearCategoryButton(){
        Assertions.assertTrue(dashboardPage.validateClearCategoryButton());
    }

    @When("I click Buy on one of the product")
    public void clickBuyButton(){dashboardPage.clickBuyButton();}

    @And("I go to Cart")
    public void clickCartButton(){
        dashboardPage.clickCartButton();
        Assertions.assertTrue(cartPage.validateOnCartPage());
    }

    @And("I click Pay")
    public void clickPayButton(){cartPage.clickPayButton();}

    @Then("I redirected to the Transactions Page")
    public void validateOnTransactionsPage(){
        Assertions.assertTrue(transactionsPage.validateOnTransactionsPage());
    }

    @And("I click minus button until empty")
    public void clickMinusButton(){cartPage.clickMinusButton();}

    @Then("I receive alert that Order is empty")
    public void validateAlertInfo(){
        Assertions.assertTrue(cartPage.validateAlertInfo());
    }
}
