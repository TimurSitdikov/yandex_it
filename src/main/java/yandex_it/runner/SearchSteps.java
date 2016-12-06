package yandex_it.runner;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import yandex_it.page.MainPage;

public class SearchSteps extends AbstractSteps {

    @Given("^User opens main yandex realty page$")
    public void userOpensMainRealtyYandexPage() {
        MainPage mainPage = openPage(MainPage.class);
        Assert.assertTrue(mainPage.isCorrectPageOpened());
    }
}
