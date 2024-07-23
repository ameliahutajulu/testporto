package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class TransactionsPage extends PageObject {
    private By titleTransactions(){return By.xpath("//h1[text()=\"Transactions\"]");}

    @Step
    public boolean validateOnTransactionsPage(){
        waitBrowser(5);
        return $(titleTransactions()).isDisplayed();
    }
    private void waitBrowser(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
