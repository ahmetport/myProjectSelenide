package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePages;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class googlestepdefinitions {
    GooglePages googlePages = new GooglePages();

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {
//       open("https://www.google.com");
        open(string); // goıngto URL
        sleep(10000); // 10 second


    }

    @Given("I wait for {int} seconds")
    public void i_wait_for_seconds(Integer int1) {
        sleep(int1 * 3000);
    }

    @Given("I navigate to back")
    public void i_navigate_to_back() {
        back();

    }

    @Given("I navigate forward")
    public void i_navigate_forward() {
        forward();

    }

    @Given("I refresh the page")
    public void i_refresh_the_page() {
        refresh();

    }

    @Given("I hold the browser open")
    public void i_hold_the_browser_open()
    {
        Configuration.holdBrowserOpen = true;
    }

    @When("I search for {string}")
    public void iSearchFor(String string)
    {
        googlePages.googlesearchbox.setValue(string).pressEnter();
    }

    @Then("verify page source contains {string}")
    public void verifyPageSourceContains(String string) {
//        WebDriverRunner.url() return thr url of the page
        String pageSource = WebDriverRunner.source(); // page source
       // System.out.println(pageSource);
        Assert.assertTrue(pageSource.contains(string));

    }
    @Then("verify the results should contains {string} keyword")
    public void verify_the_results_should_contains_keyword(String string) {
  //      Assert.assertTrue(googlePages.resultSection.toString().contains(string));//OR BELOW CAN BE USED
//        googlePages.resultSection.shouldHave(text(string));//about 712,000
        googlePages.resultSection.shouldNotHave(text("mercedes"));//negative test checking
        googlePages.resultSection.shouldBe(visible);//checks if visible on the page
        sleep(60000);

  //      googlePages.resultSection.shouldHave(exactText("Yaklaşık 786.000.000 sonuç bulundu"));//check the exact text match
    }

    @Then("the firstb result in the page sections should contain {string}")
    public void theFirstbResultInThePageSectionsShouldContain(String string) {
        googlePages.getAllSections.get(0).shouldHave(text(string));//checks is the first section contains Tesla keyword

    }
    @And("tum sayfanın ekran goruntusunu alır.")
    public void tumSayfaninEkranGoruntusunuAlir() {
       // screenshot(new Date().toString());//ekran goruntusu ismi için dinamik yapıldı java date kullanıldı
        screenshot("ekran goruntusu1");

    }
}

