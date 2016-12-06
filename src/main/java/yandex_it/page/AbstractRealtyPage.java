package yandex_it.page;

import org.openqa.selenium.WebDriver;
import yandex_it.navigation.bo.RealtyType;
import yandex_it.navigation.pages.AdsPage;
import yandex_it.navigation.pages.CommercialBuildingsPage;
import yandex_it.navigation.pages.NewBuildingsPage;
import yandex_it.navigation.pages.PikPage;
import yandex_it.page.elements.TypeSwitcher;

public abstract class AbstractRealtyPage extends AbstractPage {

    protected TypeSwitcher typeSwitcher;

    public AbstractRealtyPage(WebDriver driver) {
        super(driver);
    }

    public AbstractRealtyPage chooseRealtyType(RealtyType realtyType) {
        typeSwitcher.chooseType(realtyType);
        waitForJSComplete();
        switch (realtyType) {
            case ADS:
                return initPage(AdsPage.class);
            case COMMERCIAL:
                return initPage(CommercialBuildingsPage.class);
            case NEW_BUILDINGS:
                return initPage(NewBuildingsPage.class);
            case PIK:
                return initPage(PikPage.class);
            default:
                throw new RuntimeException("Unknown realty type page: " + realtyType);
        }
    }
}
