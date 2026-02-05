package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.MainPage;
import pages.MultipleWindowsPage;
import pages.NewWindowPage;
import utils.ScenarioContext;

import java.util.Set;

public class MultipleWindowsSteps {

    private final MainPage mainPage = new MainPage();
    private final MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage();
    private final NewWindowPage newWindowPage = new NewWindowPage();

    @When("I scroll to the Multiple Windows link and click it")
    public void scrollAndClickMultipleWindows() {
        mainPage.clickMultipleWindows();
    }

    @Then("the Click Here link should be displayed")
    public void clickHereShouldBeDisplayed() {
        Assert.assertTrue(multipleWindowsPage.isClickHereDisplayed(), "Click Here link is not displayed");
    }

    @When("I click the Click Here link")
    public void clickClickHere() {
        String original = AqualityServices.getBrowser()
                .getDriver()
                .getWindowHandle();

        ScenarioContext.setOriginalWindow(original);

        multipleWindowsPage.clickClickHere();
    }

    @When("I switch to the newly opened tab")
    public void switchToNewTab() {
        String original = ScenarioContext.getOriginalWindow();

        Set<String> handles = AqualityServices.getBrowser()
                .getDriver()
                .getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(original)) {
                AqualityServices.getBrowser()
                        .getDriver()
                        .switchTo()
                        .window(handle);
                return;
            }
        }

        throw new IllegalStateException("New tab was not opened");
    }



    @Then("the header of the opened tab should be {string}")
    public void headerShouldBe(String expected) {
        Assert.assertEquals(newWindowPage.getHeaderText(), expected, "Header text is incorrect");
    }

    @When("I go back to the main page using browser navigation")
    public void goBackToMainUsingBrowserNavigation() {
        String original = ScenarioContext.getOriginalWindow();
        Assert.assertNotNull(original, "Original window handle is null. It was not saved before opening new tab.");

        AqualityServices.getBrowser().getDriver().switchTo().window(original);

        AqualityServices.getBrowser().goBack();
    }

    @Then("the main page should be displayed")
    public void mainPageShouldBeDisplayed() {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not displayed");

    }
}
