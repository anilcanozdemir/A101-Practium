package chrome.stepDefinitions;

import io.cucumber.java.en.Then;

public class paymentPage {
    chrome.pages.paymentPage paymentPage = new chrome.pages.paymentPage();

    @Then("should see PaymentPage")
    public void shouldSeePaymentPage() {
        paymentPage.checkPaymentPage();
    }

}
