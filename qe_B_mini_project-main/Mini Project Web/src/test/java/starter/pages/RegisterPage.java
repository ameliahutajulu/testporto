package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class RegisterPage extends PageObject{
    private By titleRegister(){return By.xpath("//div[@class='v-card__title' and text()='Register']");}
    private By fieldFullName(){return By.xpath("//label[text()='Nama Lengkap']/following-sibling::input");}

    private By fieldEmail(){return By.xpath("//label[text()='Email']/following-sibling::input");}

    private By fieldPassword(){return By.xpath("//label[text()='Password']/following-sibling::input");}

    private By buttonRegister(){return By.xpath("//span[text()='Register']");}

    private By alertError(){return By.className("v-alert__wrapper");}

    @Step
    public boolean validateOnRegisterPage(){
        waitBrowser(5);
        return $(titleRegister()).isDisplayed();
    }

    @Step
    public void inputFullName(String fullname) {
        $(fieldFullName()).type(fullname);
    }

    @Step
    public void inputEmail(String email) {
        $(fieldEmail()).type(email);
    }
    @Step
    public void inputPassword(String password) {
        $(fieldPassword()).type(password);
    }

    @Step
    public void clickRegisterButton() {
        $(buttonRegister()).click();
    }

    @Step
    public boolean validateAlertErrorIsDisplayed() {
        waitBrowser(3);
        return $(alertError()).isDisplayed();
    }

    //============================================//
    private void waitBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
