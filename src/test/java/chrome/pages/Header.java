package chrome.pages;

import org.openqa.selenium.By;
import util.ElementHelper;

public class Header {
    ElementHelper elementHelper;
    By menuHeaderitems= By.className("js-navigation-item");
    public Header()
    {
        elementHelper= elementHelper.getInstance();
    }
    public void selectCategory(String mainCategory, String category, String subCategory) {
        /*
        elementHelper.mouseHoverOnElement(elementHelper.findElementByText(menuHeaderItems, mainCategory));
        elementHelper.mouseHoverOnElement(elementHelper.findElementByText(zoneHeaders, category));
        elementHelper.click(elementHelper.findElementByText(zoneItems, subCategory));
         */
elementHelper.mouseHoverOnElement(elementHelper.findElementByText(menuHeaderitems,mainCategory));
    }


}
