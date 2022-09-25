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
    When Add address as "<AddressName>" --"<CustomerName>" -- "<CustomerSurname>" -- "<Phone>" -- "<City>" -- " <County>" -- "<Distrct>"
    And Click to SaveAndProceedButton
    Then should see PaymentPage
    Examples:
      | MainCategory     | Category       | Sub-Category  | ProductName                                | Value | Email              | AddressName | CustomerName | CustomerSurname | Phone      | City  | County    | Distrct                 |
      | Giyim & Aksesuar | Kadın İç Giyim | Dizaltı Çorap | Penti Kadın 50 Denye Pantolon Çorabı Siyah | SİYAH | customer@gmail.com | asdasd      | Example      | Customer        | 5000000000 | BURSA | OSMANGAZİ | EMEK ADNAN MENDERES MAH |

  @Main @WithOutSingUp @WithOutAuth @Alternative
  Scenario Outline:Customer search,select,add to cart and proceeds to Checkout Alternative
    Given Customer is on HomePage
    When  Select Category as "<MainCategory>" -- "<Category>" -- "<Sub-Category>" without click
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
    When Add address as "<AddressName>" --"<CustomerName>" -- "<CustomerSurname>" -- "<Phone>" -- "<City>" -- " <County>" -- "<District>"
    And Click to SaveAndProceedButton
    Then should see PaymentPage
    Examples:
      | MainCategory     | Category       | Sub-Category  | ProductName                                | Value | Email              | AddressName | CustomerName | CustomerSurname | Phone      | City  | County    | District     |
      | Giyim & Aksesuar | Kadın İç Giyim | Dizaltı Çorap | Penti Kadın 50 Denye Pantolon Çorabı Siyah | SİYAH | customer@gmail.com | asdasd      | Example      | Customer        | 5000000000 | BURSA | OSMANGAZİ | İSTİKLAL MAH |