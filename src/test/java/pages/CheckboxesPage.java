package pages;

import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;

public class CheckboxesPage extends Form {

    private final ICheckBox checkbox1 =
            AqualityServices.getElementFactory().getCheckBox(
                    By.xpath("(//input[@type='checkbox'])[1]"),
                    "Checkbox 1");

    public CheckboxesPage() {
        super(By.id("content"), "Checkboxes Page");
    }

    public void selectCheckbox1() {
        if (!checkbox1.isChecked()) {
            checkbox1.check();
        }
    }

    public boolean isCheckbox1Selected() {
        return checkbox1.isChecked();
    }
}
