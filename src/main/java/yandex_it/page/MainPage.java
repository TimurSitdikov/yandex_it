package yandex_it.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='header2__main']")
    private HtmlElement header;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return "https://realty.yandex.ru/";
    }

    public void waitUntilPageCompletelyLoaded() {
        waitForElementVisible(header);
    }
}
