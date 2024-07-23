package starter.pages;

import net.bytebuddy.pool.TypePool;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class LoginPage extends PageObject{
    private By titleLogin(){return By.xpath("//div[@class='v-card__title' and text()='Login']");}
    private By fieldEmail(){return By.xpath("//label[text()='Email']");}
    private By fieldPassword(){return By.xpath("//label[text()='Password']");}
    private By buttonLogin(){return By.xpath("//span[text()='Login']");}

    @Step
    public boolean validateOnLoginPage(){
        waitBrowser(5);
        return $(titleLogin()).isDisplayed();
    }

/*    @Step
    public void inputEmail(String email) {
        $(fieldEmail()).type(email);
    }

    @Step
    public void inputPassword(String password) {
        $(fieldPassword()).type(password);
    }

 */

    @Step
    public void clickLoginButton() {
        $(buttonLogin()).click();
    }


    private void waitBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
