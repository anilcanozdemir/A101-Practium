@A101 @Chrome
Feature: A101 PRACTIUM
  Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome
  browser kullanarak test otomasyon ödevi yapılacak.

  @Main @WithOutSingUp @WithOutAuth
  Scenario Outline:Customer search,select,add to cart and proceeds to Checkout
    Given Customer is on HomePage
    When  Select Category as "<MainCategory>" -- "<Category>" -- "<Sub-Category>"
    Then should see SearchPage
    When Click Product "<ProductName>"
    Then should see ProductPage
    And Check Color to be "<Value>"
    When Click to Add to CartButton
    And Click to ViewCartButton
    Then should see CartPage
    When Click to proceed to CheckoutButton
    Then should see LoginPage
    When Click to Proceed WithOutAuth
    Then should see EmailContainer
    When Enter Email "<Email>" and click to ContinueButton
    Then should see AddressAndCargoPage
    When Add address as "<AddressName>" --"<CustomerName>" -- "<CustomerSurname>" -- "<Phone>" -- "<City>" -- " <County>" -- "<Distrct>" -- "<AddressDetails>" -- "<PostalCode>"
    And Select Cargo as "<Cargo>"
    And Click to SaveAndProceedButton
    Then should see PaymentPage
    Examples:
      | MainCategory | Category | Sub-Category | ProductName | Value | Email | AddressName | CustomerName | CustomerSurname | Phone | City | County | Distrct | AddressDetails | PostalCode | Cargo |
      |              |          |              |             |       |       |             |              |                 |       |      |        |         |                |            |       |