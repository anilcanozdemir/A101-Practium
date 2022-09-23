package chrome.pages;

import org.openqa.selenium.By;

public class loginPage extends Header {
    By pageAuth = By.className("page-auth");
    By proceedToCheckOutbtn = By.className("js-proceed-to-checkout-btn");
    By guestForm = By.className("guest-form");
    By submitButton = By.cssSelector("body > section > div.page-auth > div > div.row.js-block-email > div > div > form > button");
    By edtEmail=By.name("user_email");

    public void checkLoginPage() {
        elementHelper.findElement(pageAuth);
    }

    public void proceedWithOutAuth() {

        elementHelper.click(proceedToCheckOutbtn);
    }

    public void checkEmailContainer() {
        elementHelper.findElement(guestForm);
    }

    public void enterEmail(String email) {
        elementHelper.sendKeys(edtEmail,email);
    }

    public void clickToContinueButton() {
        elementHelper.click(submitButton);
    }
}
