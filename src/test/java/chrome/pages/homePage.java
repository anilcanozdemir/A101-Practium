package chrome.pages;


import org.openqa.selenium.By;

public class homePage extends Header {
    By pageHomepage = By.className("page-homepage");

    public void checkHomePage() {
        elementHelper.findElement(pageHomepage);
    }
}
