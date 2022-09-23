package chrome.pages;

import org.openqa.selenium.By;

public class productPage extends Header {
    By productName = By.className("product-name");
    By selectedVariant = By.className("selected-variant-text");
    By addToCartIcon = By.className("icon-sepetekle");
    By gotoCart = By.className("go-to-shop");

    public void checkProductPage() {
        elementHelper.findElement(productName);
    }

    public void checkColor(String color) {

        elementHelper.checkElementText(elementHelper.findElement(selectedVariant),
                " Seçılen Renk: " + color);
    }

    public void addToCart() {
        elementHelper.click(addToCartIcon);
    }

    public void viewCart() {
        elementHelper.click(gotoCart);
    }
}
