package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;

public class MultipleWindowsPage extends Form {

    private final ILink clickHereLink =
            AqualityServices.getElementFactory().getLink(By.linkText("Click Here"), "Click Here link");

    public MultipleWindowsPage() {
        super(By.xpath("//h3[normalize-space()='Opening a new window']"), "Multiple Windows Page");
    }

    public boolean isClickHereDisplayed() {
        return clickHereLink.state().isDisplayed();
    }

    public void clickClickHere() {
        clickHereLink.click();
    }
}
