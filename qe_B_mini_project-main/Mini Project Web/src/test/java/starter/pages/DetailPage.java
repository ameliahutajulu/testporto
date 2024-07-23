package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class DetailPage extends PageObject{
    private By titleDetail(){return By.xpath("//p[text()=\"Sony PS5\"]");}


    @Step
    public boolean validateOnDetailPage(){
        waitBrowser(5);
        return $(titleDetail()).isDisplayed();
    }

    private void waitBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
