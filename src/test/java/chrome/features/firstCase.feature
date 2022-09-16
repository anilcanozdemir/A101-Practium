@A101 @Chrome
  Feature: A101 PRACTIUM
    Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome
    browser kullanarak test otomasyon ödevi yapılacak.
    @Main @WithOutSingUp @WithOutAuth
    Scenario Outline:Customer search,select,add to cart and proceeds to Checkout
      Given Customer is on HomePage
      When  Select Category as "<MainCategory>" -- "<Category>" -- "<Sub-Category>"
      Then should see SearchPage


      Examples:
        |  |