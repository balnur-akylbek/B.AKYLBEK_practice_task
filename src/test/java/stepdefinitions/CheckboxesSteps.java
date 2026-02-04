package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckboxesPage;
import pages.MainPage;
import aquality.selenium.browser.AqualityServices;

public class CheckboxesSteps {

    private final MainPage mainPage = new MainPage();
    private final CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Given("the browser is opened in incognito mode")
    public void browserOpenedInIncognito() {
        // handled in Hooks
    }

    @Given("I open the main page")
    public void openMainPage() {
        AqualityServices.getBrowser()
                .goTo("https://the-internet.herokuapp.com");
    }

    @When("I click on the Checkboxes link")
    public void clickCheckboxesLink() {
        mainPage.clickCheckboxes();
    }

    @When("I select Checkbox 1")
    public void selectCheckbox1() {
        checkboxesPage.selectCheckbox1();
    }

    @Then("Checkbox 1 should be selected")
    public void checkboxShouldBeSelected() {
        Assert.assertTrue(
                checkboxesPage.isCheckbox1Selected(),
                "Checkbox 1 is not selected"
        );
    }

    @When("I refresh the page")
    public void refreshPage() {
        AqualityServices.getBrowser().refresh();
    }

    @Then("Checkbox 1 should not be selected")
    public void checkboxShouldNotBeSelected() {
        Assert.assertFalse(
                checkboxesPage.isCheckbox1Selected(),
                "Checkbox 1 is still selected after refresh"
        );
    }
}
