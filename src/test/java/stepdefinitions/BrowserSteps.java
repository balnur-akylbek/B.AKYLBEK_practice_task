package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.When;

public class BrowserSteps {

    @When("I refresh the page")
    public void refreshThePage() {
        AqualityServices.getBrowser().refresh();
    }
}
