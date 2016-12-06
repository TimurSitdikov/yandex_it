package yandex_it.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.lang.reflect.Constructor;

public abstract class AbstractPage {

    private final WebDriver driver;
    private final int DEFAULT_TIMEOUT = 15;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),this);
    }

    public abstract String getUrl();

    public abstract void waitUntilPageCompletelyLoaded();

    protected void waitForElementVisible(WebElement webElement, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForElementVisible(WebElement webElement){
        waitForElementVisible(webElement, DEFAULT_TIMEOUT);
    }

    protected void waitForElementClickable(int timeout, WebElement... webElements){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        for (WebElement webElement: webElements){
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }
    }

    protected  <T extends AbstractPage> T initPage(Class<T> clazz){
        try {
            try {
                Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException e) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isCorrectPageOpened(){
        return true;
    }
}
