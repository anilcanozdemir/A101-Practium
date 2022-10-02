package chrome.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPage {
    chrome.pages.loginPage loginPage = new chrome.pages.loginPage();
    @Then("should see LoginPage")
    public void shouldSeeLoginPage() {
        loginPage.checkLoginPage();
    }

    @When("Click to Proceed WithOutAuth")
    public void clickToProceedWithOutAuth() {
        loginPage.proceedWithOutAuth();
    }

    @Then("should see EmailContainer")
    public void shouldSeeEmailContainer() {
        loginPage.checkEmailContainer();
    }

    @When("Enter Email {string} and click to ContinueButton")
    public void enterEmailAndClickToContinueButton(String email) {
        loginPage.enterEmail(email);
        loginPage.clickToContinueButton();
    }


}
