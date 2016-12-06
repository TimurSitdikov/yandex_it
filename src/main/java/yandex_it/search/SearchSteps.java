package yandex_it.search;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import yandex_it.page.MainPage;
import yandex_it.runner.AbstractSteps;

public class SearchSteps extends AbstractSteps {
    @Given("^User opens main realty.yandex page$")
    public void userOpensMainRealtyYandexPage() {
        MainPage mainPage = openPage(MainPage.class);
        Assert.assertTrue(mainPage.isCorrectPageOpened());
    }
}
