package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
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


//check box and radiobutton
    @And("I click on the {string} if not already selected")
    public void iClickOnTheIfNotAlreadySelected(String string) {
        if (string.equals("Check box 1")&&!testPages.checkBox1.isSelected()) {
            testPages.checkBox1.shouldNot(Condition.checked);
            testPages.checkBox1.click();
            testPages.checkBox1.shouldBe(Condition.checked);
        } else if (string.equals("Check box 2")&&!testPages.checkBox2.isSelected()) {
            testPages.checkBox2.shouldNot(Condition.checked);
            testPages.checkBox2.click();
            testPages.checkBox2.shouldBe(Condition.checked);
        } else if (string.equals("Red")&&!testPages.red.isSelected()) {
            testPages.red.shouldNot(Condition.checked);
            testPages.red.click();
            testPages.red.shouldBe(Condition.checked);
        } else if (string.equals("Yellow")&&!testPages.yellow.isSelected()) {
            testPages.yellow.shouldNot(Condition.checked);
            testPages.yellow.click();
            testPages.yellow.shouldBe(Condition.checked);
        } else if (string.equals("Football")&&!testPages.football.isSelected()) {
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
        testPages.day.selectOption(int1-1);//sselecting by index index 0 dan başladigindan -1 yaptık

    }
    @And("I get the list of US states and click on {string}")
    public void iGetTheListOfUSStatesAndClickOn(String string) {
        for (SelenideElement myState:testPages.allStates){ //for each loop
            if (myState.getText().equals(string)){// string texas ise texas getir dinamik yapı
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
        WebDriverRunner.getWebDriver().switchTo().alert().sendKeys("Hello portakal");//text
        WebDriverRunner.getWebDriver().switchTo().alert().accept();//ok

    }
    @Given("I verify the result contains {string}")
    public void i_verify_the_result_contains(String string) {
        testPages.result.shouldHave(Condition.text(string));

    }
}
