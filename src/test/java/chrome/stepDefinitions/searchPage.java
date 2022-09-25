package chrome.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchPage {
    chrome.pages.searchPage searchPage = new chrome.pages.searchPage();

    @Then("should see SearchPage")
    public void shouldSeeSearchPage() {
        searchPage.checkSearchPage();
    }

    @When("Click Product {string}")
    public void clickProduct(String productName) {
        searchPage.clickProduct(productName);
    }
}
