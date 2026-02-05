package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckboxesPage;
import pages.MainPage;

public class CheckboxesSteps {

    private final MainPage mainPage = new MainPage();
    private final CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Given("I open the main page")
    public void openMainPage() {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not opened");
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
    @Then("Checkbox 1 should not be selected")
    public void checkboxShouldNotBeSelected() {
        Assert.assertFalse(
                checkboxesPage.isCheckbox1Selected(),
                "Checkbox 1 is still selected after refresh"
        );
    }
}
