Feature: screenshot

    @tumekrangoruntusu
    Scenario: tum ekran goruntusunu al
       Given I navigate to "https://www.google.com"
       And    tum sayfanın ekran goruntusunu alır.
    @googleimage
    Scenario: tek element ekran görüntüsü alma
      Given I navigate to "https://www.google.com"
      And   sadece google goruntusunu al


