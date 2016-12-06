package yandex_it.runner;

import org.openqa.selenium.WebDriver;
import yandex_it.driver.DriverManager;
import yandex_it.page.AbstractPage;
import yandex_it.page.MainPage;

import java.lang.reflect.Constructor;

public abstract class AbstractSteps {

    private WebDriver driver = DriverManager.getDriver();

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

    protected <T extends AbstractPage> T openPage(Class<T> clazz){
        T page = initPage(clazz);
        driver.get(page.getUrl());
        page.waitUntilPageCompletelyLoaded();
        return page;
    }

    protected MainPage openMainPage(){
        if(DriverManager.getDriver().getCurrentUrl().endsWith("realty.yandex.ru/")) return initPage(MainPage.class);
        return openPage(MainPage.class);
    }
}
