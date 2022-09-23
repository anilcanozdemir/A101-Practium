package chrome.pages;

import org.openqa.selenium.By;

public class addressAndCargoPage extends Header {
    By pageCheckout = By.className("page-checkout");
    By newAddress = By.className("new-address");
    By addressTitle = By.name("title");
    By firstName = By.name("first_name");
    By lastName = By.name("last_name");
    By phoneNumber = By.name("phone_number");
    By city=By.name("city");
    By township=By.name("township");
    By district=By.className("js-district");
    By addressDetails=By.name("line");
    By SaveAddress=By.className("js-set-country");

    By cargoCheck=By.className("check");


    public void checkAddressAndCargoPage() {
        elementHelper.findElement(pageCheckout);
    }

    public void clickToSaveAndProceedButton() {
    }

    public void addAddressAs(String addressName, String customerName, String customerSurname, String phone, String city, String township, String district, String addressDetails) {
        elementHelper.click(newAddress);
        elementHelper.sendKeys(addressTitle,addressName);
        elementHelper.sendKeys(firstName,customerName);
        elementHelper.sendKeys(lastName,customerSurname);
        elementHelper.sendKeys(phoneNumber,phone);
        elementHelper.selectDropDown(this.city,city);
        elementHelper.selectDropDown(this.township,township);
        elementHelper.selectDropDown(this.district,district);
        elementHelper.sendKeys(this.addressDetails,addressDetails);
        elementHelper.click(SaveAddress);
    }

    public void selectCargoAs(String cargoName) {
        elementHelper.click(elementHelper.findElementByText(cargoCheck,cargoName));
    }
}
