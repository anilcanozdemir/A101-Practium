package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;



public class ElementHelper {

    private static ElementHelper elementHelper = null;
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    private ElementHelper() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    public static ElementHelper getInstance() {
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
            System.out.println(element.getText());
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

    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }


    public WebElement findElement(By parentElement, By key) {

        return presenceElement(parentElement, key);
    }

    public WebElement presenceElement(By parent, By key) {
        try{
            return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, key));
        }
       catch (TimeoutException e)
       {
           return null;
       }
    }


    public void gotoHref(String href) {
        driver.get(href);
        wait.until(ExpectedConditions.urlContains(href));
    }

    public void sendKeys(By key, String text) {
        findElement(key).click();
        findElement(key).sendKeys(text);
    }

    public void selectDropDown(By dropDown, String choice) {
        try {
            click(dropDown);
            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(dropDown, By.xpath("//*[contains(text(),'" + choice.trim() + "')]")));
            Select select = new Select(findElement(dropDown));
            System.out.println(select.getOptions().get(1).getText());
            select.selectByVisibleText(choice.trim());
            if(!Objects.equals(select.getFirstSelectedOption().getText(), choice.trim()))
            {
                selectDropDown(dropDown,choice);
            }
        }catch (StaleElementReferenceException e)
        {
            selectDropDown(dropDown,choice);
        }

    }

    public void clickwithAction(WebElement element) {
        actions.moveToElement(element).click().perform();
    }
    public  void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
