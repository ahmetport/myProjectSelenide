package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import static com.codeborne.selenide.Selenide.*;

public class TechproeducationStepDefinitions {

    @Given("I get title of the current page and verify if it contains {string}")
    public void i_get_title_of_the_current_page_and_verify_if_it_contains(String string) {
        Assert.assertTrue(title().contains(string));
    }
}
