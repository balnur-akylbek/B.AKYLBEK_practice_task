package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final ILink checkboxesLink =
            AqualityServices.getElementFactory().getLink(By.linkText("Checkboxes"), "Checkboxes link");

    private final ILink multipleWindowsLink =
            AqualityServices.getElementFactory().getLink(By.linkText("Multiple Windows"), "Multiple Windows link");

    public MainPage() {
        super(By.id("content"), "Main Page");
    }

    public void clickCheckboxes() {
        checkboxesLink.click();
    }

    public void clickMultipleWindows() {
        // Scroll to element (Aquality will scroll to clickable element in most cases, but we do it explicitly)
        multipleWindowsLink.getJsActions().scrollToTheCenter();
        multipleWindowsLink.click();
    }

    public boolean isDisplayed() {
        return state().isDisplayed();
    }
}
