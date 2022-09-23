package chrome.pages;


import org.openqa.selenium.By;

public class searchPage extends Header {
    By productsList = By.className("products-list");
    By productnameHolders = By.className("name");

    public void clickProduct(String productName) {

        elementHelper.click(elementHelper.findElementByText(productnameHolders, productName));
    }

    public void checkSearchPage() {
        elementHelper.findElement(productsList);
    }
}
