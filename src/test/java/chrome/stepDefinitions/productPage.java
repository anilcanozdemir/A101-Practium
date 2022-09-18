package chrome.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class productPage {
    chrome.pages.productPage productPage = new chrome.pages.productPage();
    @Then("should see ProductPage")
    public void shouldSeeProductPage() {
        productPage.checkProductPage();
    }

    @And("Check Color to be {string}")
    public void checkColorToBe(String color) {
        productPage.checkColor(color);
    }

    @When("Click to Add to CartButton")
    public void clickToAddToCartButton() {
        productPage.addToCart();
    }

    @And("Click to ViewCartButton")
    public void clickToViewCartButton() {
        productPage.viewCart();
    }

}
