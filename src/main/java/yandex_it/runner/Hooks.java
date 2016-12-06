package yandex_it.runner;

import cucumber.api.java.After;
import yandex_it.driver.DriverManager;

public class Hooks {

    @After
    public void afterTests() {
        DriverManager.closeDriver();
    }
}
