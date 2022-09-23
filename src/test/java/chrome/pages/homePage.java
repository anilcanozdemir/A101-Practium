package chrome.pages;


import org.openqa.selenium.By;

public class homePage extends Header {
    By pageHomepage = By.className("page-homepage");
    By buttonCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");


    public void checkHomePage() {
        try {
            elementHelper.click(buttonCookies);
        } catch (Exception ignored) {

        } finally {
            elementHelper.findElement(pageHomepage);
        }

    }
}
