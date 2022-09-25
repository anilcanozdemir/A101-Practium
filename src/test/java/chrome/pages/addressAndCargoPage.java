package chrome.pages;

import org.openqa.selenium.By;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class addressAndCargoPage extends Header {
    By pageCheckout = By.className("page-checkout");
    By newAddress = By.className("new-address");
    By addressTitle = By.name("title");
    By firstName = By.name("first_name");
    By lastName = By.name("last_name");
    By phoneNumber = By.name("phone_number");
    By city = By.name("city");
    By township = By.name("township");
    By district = By.name("district");
    By addressDetails = By.name("line");
    By SaveAddress = By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/button[1]");
    By address = By.className("title");
    By cargoCheck = By.className("check");
    By saveAndProceed = By.cssSelector("body > section > section > div > div.checkout-addresses.js-tab-content.active > div > div.col-sm-9 > div > div.continue > form > div.cargo > button");
    By saveButton = By.cssSelector("button[type='button']");
    By form = By.cssSelector("#js-orders-modal-container > div > div.modal-content > form");

    public void checkAddressAndCargoPage() {
        elementHelper.findElement(pageCheckout);
    }

    public void clickToSaveAndProceedButton() {
        elementHelper.click(saveAndProceed);
    }

    public void addAddressAs(String addressName, String customerName, String customerSurname, String phone, String city, String township, String district) {
        elementHelper.click(newAddress);
        elementHelper.sendKeys(addressTitle, addressName);
        elementHelper.sendKeys(firstName, customerName);
        elementHelper.sendKeys(lastName, customerSurname);
        elementHelper.sendKeys(phoneNumber, phone);
        elementHelper.selectDropDown(this.city, city);

        elementHelper.selectDropDown(this.township, township);
        elementHelper.selectDropDown(this.district, district);
        byte[] array = new byte[50]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        elementHelper.sendKeys(this.addressDetails, generatedString);
        elementHelper.mouseHoverOnElement(SaveAddress);


        elementHelper.clickWithJS(elementHelper.findElement(form, saveButton));

    }

    public void selectCargoAs(String cargoName) {
        elementHelper.click(elementHelper.findElementByText(cargoCheck, " " + cargoName + " "));
    }

    public void selectAddress(String addressName) {
        elementHelper.click(elementHelper.findElementByText(address, addressName));
    }
}
