package chrome.stepDefinitions;


import io.cucumber.java.en.When;

public class Header {
    chrome.pages.Header header = new chrome.pages.Header();

    @When("Select Category as {string} -- {string} -- {string}")
    public void selectCategoryAsMainCategoryCategorySubCategory(String mainCategory, String category, String subCategory) {
        header.selectCategory(mainCategory, category, subCategory);

    }


    @When("Select Category as {string} -- {string} -- {string} without click")
    public void selectCategoryAsWithoutClick(String mainCategory, String category, String subCategory) {
        header.selectCategoryWithoutClick(mainCategory, category, subCategory);
    }
}
