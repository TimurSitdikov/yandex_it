package yandex_it.runner;

import cucumber.api.java.en.Then;
import org.testng.asserts.SoftAssert;
import yandex_it.driver.DriverManager;
import yandex_it.navigation.bo.RealtyType;
import yandex_it.page.MainPage;
import yandex_it.runner.AbstractSteps;

public class NavigationSteps extends AbstractSteps {

    @Then("^User checks that type switch works correctly$")
    public void checkRealtyTypesNavigation() {
        MainPage mainPage = openMainPage();
        SoftAssert softAssert = new SoftAssert();
        for(RealtyType realtyType: RealtyType.values()){
            softAssert.assertTrue(mainPage.chooseRealtyType(realtyType).isCorrectPageOpened(),
                    "Incorrect page opened. Expected: " + realtyType.name() + ", but found: " + DriverManager.getDriver().getCurrentUrl());
        }
        softAssert.assertAll();
    }
}
