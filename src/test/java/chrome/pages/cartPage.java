package chrome.pages;

import org.openqa.selenium.By;

public class cartPage extends Header {
    By basket = By.className("basket");
    By confirmBasket = By.cssSelector("body > section > div.page-basket > div.container.js-basket-container > div > div.col-sm-3 > div > a");

    public void ProceedToCheckout() {
        elementHelper.click(confirmBasket);
    }

    public void checkCartPage() {
        elementHelper.findElement(basket);
    }
}
