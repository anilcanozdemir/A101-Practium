package chrome.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addressAndCargoPage {
    chrome.pages.addressAndCargoPage addressAndCargoPage = new chrome.pages.addressAndCargoPage();
    @Then("should see AddressAndCargoPage")
    public void shouldSeeAddressAndCargoPage() {
 addressAndCargoPage.checkAddressAndCargoPage();
    }

    @And("Click to SaveAndProceedButton")
    public void clickToSaveAndProceedButton() {
        addressAndCargoPage.clickToSaveAndProceedButton();
    }

    @When("Add address as {string} --{string} -- {string} -- {string} -- {string} -- {string} -- {string} -- {string}")
    public void addAddressAs(String AddressName, String CustomerName, String CustomerSurname, String Phone, String City, String Township, String District, String AddressDetails) {
        addressAndCargoPage.addAddressAs(AddressName,CustomerName,CustomerSurname,Phone,City,Township,District,AddressDetails);
    }

    @And("Select Cargo as {string}")
    public void selectCargoAs(String cargoName) {
        addressAndCargoPage.selectCargoAs(cargoName);
    }
}
