package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class DashboardPage extends PageObject{
    private By titleDashboard(){return By.xpath("//i[contains(@class, 'fa-user')]");}
    private By buttonDetail(){return By.xpath("//span[text()='Detail']");}
    private By buttonBuy(){return By.xpath("//span[text()='Beli']");}
    private By fieldCategory(){return By.xpath("//div[@aria-haspopup=\"listbox\"]");}
    private By optionCategory(){return By.xpath("//div[@class=\"v-list-item__content\"]/div[@class=\"v-list-item__title\"][1]");}
    private By clearCategory(){return By.xpath("//button[contains(@class, 'fa-times-circle')]");}
    private By buttonCart(){return By.xpath("//i[contains(@class, 'fa-shopping-cart')]");}

    @Step
    public boolean validateOnDashboardPage(){
        waitBrowser(5);
        return $(titleDashboard()).isDisplayed();
    }

    @Step
    public void clickDetailButton(){
        $(buttonDetail()).click();
    }

    @Step
    public void clickBuyButton(){
        $(buttonBuy()).click();
    }

    @Step
    public void clickCategoryField(){
        $(fieldCategory()).click();
    }

    @Step
    public void clickCategoryOption(){
        $(optionCategory()).click();
    }

    @Step
    public boolean validateClearCategoryButton(){
        waitBrowser(5);
        return $(clearCategory()).isDisplayed();
    }

    @Step
    public void clickCartButton(){
        $(buttonCart()).click();
    }


    private void waitBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
