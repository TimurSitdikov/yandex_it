package yandex_it.navigation.pages;

import org.openqa.selenium.WebDriver;
import yandex_it.driver.DriverManager;
import yandex_it.page.AbstractRealtyPage;

public class AdsPage extends AbstractRealtyPage{

    public AdsPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return null;
    }

    public void waitUntilPageCompletelyLoaded() {
        waitForElementClickable(typeSwitcher);
    }

    @Override
    public boolean isCorrectPageOpened() {
        return DriverManager.getDriver().getCurrentUrl().endsWith("/kvartira/");
    }
}
