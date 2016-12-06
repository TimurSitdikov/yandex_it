package yandex_it.navigation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import yandex_it.driver.DriverManager;
import yandex_it.page.AbstractRealtyPage;

public class PikPage extends AbstractRealtyPage{

    @FindBy(xpath = "//*[@class='pik-nav__logo']")
    private HtmlElement pikLogo;

    public PikPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return null;
    }

    public void waitUntilPageCompletelyLoaded() {
        waitForElementClickable(pikLogo);
    }

    @Override
    public boolean isCorrectPageOpened() {
        return DriverManager.getDriver().getCurrentUrl().contains("campaign=pik");
    }
}
