package chrome.pages;

import org.openqa.selenium.By;

public class paymentPage extends Header {
    public void checkPaymentPage() {
        elementHelper.findElement(By.className("checkout-payment"));
    }
}
