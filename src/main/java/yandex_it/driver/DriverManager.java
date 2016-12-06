package yandex_it.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver driver;
    private static final DriverType DEFAULT_DRIVER_TYPE = DriverType.CHROME;

    public static WebDriver getDriver(){
        if(driver == null) driver = getDriver(DEFAULT_DRIVER_TYPE);
        return driver;
    }

    public static WebDriver getDriver(DriverType driverType){
        if(driver != null) driver.close();
        switch (driverType){
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unknown type of driver: " + driverType);
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null) driver.close();
    }
}
