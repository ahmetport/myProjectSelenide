package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.TestPages;

import static com.codeborne.selenide.Selenide.sleep;


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
}
