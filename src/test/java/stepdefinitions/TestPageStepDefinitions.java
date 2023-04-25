package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestPages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestPageStepDefinitions {
    TestPages testPages = new TestPages();


    @Given("I enter username")
    public void i_enter_username() {
        testPages.username.setValue("techproed");
    }

    @Given("I enter password")
    public void i_enter_password() {
        testPages.password.setValue("SuperSecretPassword");
    }

    @Given("I enter submit button")
    public void i_enter_submit_button() {
        testPages.submitButton.click();
        sleep(3000);
    }

    @And("I enter logout")
    public void iEnterLogout() {
        testPages.lagout.click();
    }


    //check box and radiobutton
    @And("I click on the {string} if not already selected")
    public void iClickOnTheIfNotAlreadySelected(String string) {
        if (string.equals("Check box 1") && !testPages.checkBox1.isSelected()) {
            testPages.checkBox1.shouldNot(Condition.checked);
            testPages.checkBox1.click();
            testPages.checkBox1.shouldBe(Condition.checked);
        } else if (string.equals("Check box 2") && !testPages.checkBox2.isSelected()) {
            testPages.checkBox2.shouldNot(Condition.checked);
            testPages.checkBox2.click();
            testPages.checkBox2.shouldBe(Condition.checked);
        } else if (string.equals("Red") && !testPages.red.isSelected()) {
            testPages.red.shouldNot(Condition.checked);
            testPages.red.click();
            testPages.red.shouldBe(Condition.checked);
        } else if (string.equals("Yellow") && !testPages.yellow.isSelected()) {
            testPages.yellow.shouldNot(Condition.checked);
            testPages.yellow.click();
            testPages.yellow.shouldBe(Condition.checked);
        } else if (string.equals("Football") && !testPages.football.isSelected()) {
            testPages.football.shouldNot(Condition.checked);
            testPages.football.click();
            testPages.football.shouldBe(Condition.checked);
        }
    }

    // dropdown

    @Given("I select the year as {int}")
    public void i_select_the_year_as(Integer int1) {
        testPages.year.selectOptionByValue(String.valueOf(int1));//selecting by value dinamik oldu
    }

    @Given("I select the months as {string}")
    public void i_select_the_months_as(String string) {
        testPages.month.selectOption(string);//selecting by visible text dinamik

    }

    @Given("I select the day as {int}")
    public void i_select_the_day_as(Integer int1) {
        testPages.day.selectOption(int1 - 1);//sselecting by index index 0 dan başladigindan -1 yaptık

    }

    @And("I get the list of US states and click on {string}")
    public void iGetTheListOfUSStatesAndClickOn(String string) {
        for (SelenideElement myState : testPages.allStates) { //for each loop
            if (myState.getText().equals(string)) {// string texas ise texas getir dinamik yapı
                myState.click();
                break;
            }
        }

    }

    //alerts

    @Given("I click on alert prompt")
    public void i_click_on_alert_prompt() {
        testPages.jsPrompt.click();
    }

    @Given("I enter {string} and click OK")
    public void i_enter_and_click_ok(String string) {
        WebDriverRunner.getWebDriver().switchTo().alert().sendKeys(string);//text
        WebDriverRunner.getWebDriver().switchTo().alert().accept();//ok

    }

    @Given("I verify the result contains {string}")
    public void i_verify_the_result_contains(String string) {
        testPages.result.shouldHave(text(string));//SELENİDEDEN GELEN DOGRULAMA
        // Assert.assertTrue(testPages.result.getText().contains(string));//JUNIT DEN GELEN DOGRULAMA

    }

    // FRAMES

    @Given("I verify the page header contains {string}")
    public void i_verify_the_page_header_contains(String string) {
        // iframe in dışındayız
        testPages.pageHeader.shouldHave(text(string));

    }

    @Given("I switch to frame {int}")
    public void i_switch_to_frame(Integer int1) {
        //iframe window
        WebDriverRunner.getWebDriver().switchTo().frame(int1 - 1);//0 INCI İNDEX >>> 1 FRAME DEMEK

    }

    @Given("I click on back to TechProEducation.com")
    public void i_click_on_back_to_tech_pro_education_com() {
        //iframe in içindeyiz
        testPages.backtechpro.click();

    }

    //switch to window
    @When("I switch to window {int}")
    public void i_switch_to_window(Integer int1) {
        switchTo().window(int1 - 1);//YENİ SAYFAYA GECTİ
        System.out.println();

    }

    @Then("I get to URL of the page and verify it contains {string}")
    public void i_get_to_url_of_the_page_and_verify_it_contains(String string) {
        System.out.println(WebDriverRunner.url());//DRİVER HALA ESKİ PAGE DE
        Assert.assertTrue(WebDriverRunner.url().contains(string));

    }

    //actions dropanddrag
    @When("I drag the source in the target")
    public void iDragTheSourceInTheTarget() {
        // seleniumda olsaydı
        //Actions action = new Actions(driver) yapmamız lazımdı yanı driver actiona tanımlayacaktık ama selenide bunu otomatik yapıyor
        //en çok tercih edilen yol
        //     actions()
        //             .dragAndDrop(testPages.source,testPages.target)
        //             .build()
        //             .perform();

        //OR
        //     actions()
        //             .clickAndHold(testPages.source)
        //             .moveToElement(testPages.target)
        //             .build()
        //             .perform();

        //we can move the source to the specific coordinates
        actions()
                .dragAndDropBy(testPages.source, 6, 104)
                .build()
                .perform();
    }

    @And("Kullanici source elementini {int} by {int} koordinatlarına surukler")
    public void kullaniciSourceElementiniByKoordinatlarinaSurukler(int arg0, int arg1) {
        actions().dragAndDropBy(testPages.source,arg0,arg1).build().perform(); //hard corddan çıktı dinamik oldu

    }

    @And("Verilen koordinatlar ile {int} by {int} suruklendigini dogrular")
    public void verilenKoordinatlarIleBySuruklendiginiDogrular(int arg0, int arg1) {
        //dinamik yaptık
        String styvalue=testPages.source.getAttribute("style");
        System.out.println(styvalue);
        Assert.assertTrue(styvalue.contains(String.valueOf(arg0)) && styvalue.contains(String.valueOf(arg1)));
    }


    @Then("I scroll pagedown")
    public void iScrollPagedown() {
        actions().sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    //expicity_wait

    @Then("I click on the start button")
    public void i_click_on_the_start_button() {

        testPages.startButton.click();
    }

    @Then("verify the Hello world text is displayed")
    public void verify_the_hello_world_text_is_displayed() {
        //fails with no wait
        Assert.assertEquals("Hello World!",testPages.helloworld.getText());//fail

        //handle wait webdriverwait class
     //   WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10));
     //   wait.until(ExpectedConditions.visibilityOf(testPages.helloworld));
     //   Assert.assertEquals("Hello World!", testPages.helloworld.getText());//pass

        //Selenide wait
     //   testPages.helloworld.should(Condition.visible,Duration.ofSeconds(10));//SELENİDE WAİT  PASS

        // EN KULLANIŞLI assert bu çunku tek satırda dogruluyoruz
     //   testPages.helloworld.shouldHave(text("Hello World!"),Duration.ofSeconds(10));//sELENİDE WAİT PASS


    }


    @And("sadece google goruntusunu al")
    public void sadeceGoogleGoruntusunuAl() {
        testPages.googleimage.screenshot();

    }
}

