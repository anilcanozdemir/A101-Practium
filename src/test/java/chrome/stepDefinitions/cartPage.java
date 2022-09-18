package chrome.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cartPage {
    chrome.pages.cartPage cartPage = new chrome.pages.cartPage();
    @When("Click to proceed to CheckoutButton")
    public void clickToProceedToCheckoutButton() {
        cartPage.ProceedToCheckout();
    }

    @Then("should see CartPage")
    public void shouldSeeCartPage() {
        cartPage.checkCartPage();
    }

}
