package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementHelper {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    private ElementHelper elementHelper = null;

    private ElementHelper() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public ElementHelper getInstance() {
        if (elementHelper == null) elementHelper = new ElementHelper();
        return elementHelper;
    }
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }
    public WebElement presenceElement(WebElement element, By key) {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, key));
    }
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    private List<WebElement> presenceElements(By parent, By key) {
        return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parent, key));
    }

    public WebElement findElement(By key) {
        return presenceElement(key);
    }

    public WebElement findElement(WebElement parentElement, By key) {

        return presenceElement(parentElement, key);
    }

    public void click(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key))).click();
    }
    public void mouseHoverOnElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).perform();

    }

    public void mouseHoverOnElement(By key) {
        wait.until(ExpectedConditions.elementToBeClickable(findElement(key)));
        actions.moveToElement(findElement(key)).perform();

    }
    public WebElement findElementByText(By key, String text) {
        boolean find = false;
        for (WebElement element : findElements(key)) {

            if (checkElementText(element, text)) {
                find = true;
                return element;
            }
        }
        Assert.assertTrue(find);
        return null;
    }
    public List<WebElement> findElements(By key) {

        return presenceElements(key);
    }
    public boolean checkElementText(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(element));
        } catch (Exception ignored) {
        }

        return element.getText().contains(text);
    }

}
