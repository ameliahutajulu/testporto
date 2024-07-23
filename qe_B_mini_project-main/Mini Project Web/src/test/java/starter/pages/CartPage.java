package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class CartPage extends PageObject {
    private By titleTotal(){return By.xpath("//div[@class=\"v-list-item__title\" and text()=\"Total Qty\"]");}
    private By buttonMinus(){return By.xpath("//span[@class=\"v-btn__content\" and text()=\"-\"]");}
    private By alertInfo(){return By.xpath("//i[contains(@class, 'fa-info-circle')]");}
    private By buttonBayar(){return By.id("button-bayar");}

    @Step
    public boolean validateOnCartPage(){
        waitBrowser(5);
        return $(titleTotal()).isDisplayed();
    }

    @Step
    public void clickMinusButton(){
        $(buttonMinus()).click();
    }

    @Step
    public boolean validateAlertInfo(){
        waitBrowser(5);
        return $(alertInfo()).isDisplayed();
    }

    @Step
    public void clickPayButton(){
        $(buttonBayar()).click();
    }

    private void waitBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
