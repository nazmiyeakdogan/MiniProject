package StepDefinitions;

import Pages.DialogContent;
import Utilities.WebDriverBasic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBoxSteps {
    DialogContent dc = new DialogContent();
    @Given("Navigate to Website")
    public void navigateToWebsite() {
        WebDriverBasic.getDriver().get("https://www.logo.com.tr/");
        WebDriverBasic.getDriver().manage().window().maximize();
    }
    @When("Click contact Logo in the search box")
    public void clickContactLogoInTheSearchBox() {
        dc.findAndClick("clickButton");
        dc.findAndClick("searchBox");
        dc.findAndClick("clickText");
        dc.findAndClick("clickBranch");
    }

    @Then("Elazig Branch should be displayed")
    public void elazigBranchShouldBeDisplayed() {
        dc.findAndContainsText("verification", "Elazığ Şubesi");
    }



}
