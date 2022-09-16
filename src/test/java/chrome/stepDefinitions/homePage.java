package chrome.stepDefinitions;


import io.cucumber.java.en.Given;


public class homePage {
    chrome.pages.homePage homePage=new  chrome.pages.homePage();

    @Given("Customer is on HomePage")
    public void customerIsonHomePage() {
        homePage.checkHomePage();
    }




}
