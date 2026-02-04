package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;

public class NewWindowPage extends Form {

    private final ILabel header =
            AqualityServices.getElementFactory().getLabel(By.tagName("h3"), "Header");

    public NewWindowPage() {
        super(By.tagName("h3"), "New Window Page");
    }

    public String getHeaderText() {
        return header.getText();
    }
}
