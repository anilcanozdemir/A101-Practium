package chrome.pages;

import org.openqa.selenium.By;
import util.ElementHelper;

public class Header {
    ElementHelper elementHelper;
    By menuHeaderitems = By.className("js-navigation-item");
    By subMenuItems = By.className("submenu-items");

    public Header() {
        elementHelper = ElementHelper.getInstance();
    }

    public void selectCategory(String mainCategory, String category, String subCategory) {

        elementHelper.mouseHoverOnElement(elementHelper.findElementByText(menuHeaderitems, mainCategory));
        elementHelper.mouseHoverOnElement(elementHelper.findElement(subMenuItems, By.xpath("//*[contains(text(),'" + category + "')]")));
        elementHelper.click(elementHelper.findElement(subMenuItems, By.xpath("//*[contains(text(),'" + subCategory + "')]")));


    }


    public void selectCategoryWithoutClick(String mainCategory, String category, String subCategory) {
        elementHelper.mouseHoverOnElement(elementHelper.findElementByText(menuHeaderitems, mainCategory));
        elementHelper.mouseHoverOnElement(elementHelper.findElement(subMenuItems, By.xpath("//*[contains(text(),'" + category + "')]")));
        elementHelper.gotoHref(elementHelper.findElement(subMenuItems, By.xpath("//*[contains(text(),'" + subCategory + "')]")).getAttribute("href"));
    }
}
