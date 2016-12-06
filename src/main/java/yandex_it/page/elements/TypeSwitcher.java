package yandex_it.page.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import yandex_it.navigation.bo.RealtyType;

@FindBy(xpath = "//*[contains(@class,'type-switcher ')]")
public class TypeSwitcher extends HtmlElement {

    @FindBy(xpath = "//*[contains(@href,'kvartira')]")
    private HtmlElement adsType;

    @FindBy(xpath = "//*[contains(@href,'kommercheskaya')]")
    private HtmlElement commercialType;

    @FindBy(xpath = "//*[contains(@href,'novostrojka')]")
    private HtmlElement newBuildingsType;

    @FindBy(xpath = "//*[contains(@href,'campaign=pik')]")
    private HtmlElement pikType;

    public void chooseType(RealtyType realtyType) {
        switch (realtyType) {
            case ADS:
                adsType.click();
                break;
            case COMMERCIAL:
                commercialType.click();
                break;
            case NEW_BUILDINGS:
                newBuildingsType.click();
                break;
            case PIK:
                if(pikType.isDisplayed()) pikType.click();
                break;
            default:
                throw new RuntimeException("Opening method is not implemented for realty type: " + realtyType);
        }
//TODO Have to find another way to wait until realty type will be chosen.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
