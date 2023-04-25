package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestPages {
    public SelenideElement username=$(By.id("exampleInputEmail1"));
    public SelenideElement password=$(By.id("exampleInputPassword1"));
    public SelenideElement submitButton=$(By.xpath("//button[@type='submit']"));
    public SelenideElement lagout=$(By.cssSelector(".fa.fa-sign-out-alt"));

    //locating checksbox
    public SelenideElement checkBox1=$(By.id("box1"));
    public SelenideElement checkBox2=$(By.id("box2"));

    //locating radiobutton
    public SelenideElement red=$(By.id("red"));
    public SelenideElement yellow=$(By.id("yellow"));
    public SelenideElement football=$(By.id("football"));

    //locating dropdown
    public SelenideElement year=$(By.id("year"));
    public SelenideElement month=$(By.id("month"));
    public SelenideElement day=$(By.id("day"));
    public ElementsCollection allStates=$$(By.xpath("//select[@id='state']//option"));

    //locating alerts
    public SelenideElement jsPrompt=$(By.xpath("//button[@onclick='jsPrompt()']"));
    public SelenideElement result =$(By.id("result"));

    //iframes

    public SelenideElement pageHeader=$(By.xpath("//h3"));
    public SelenideElement backtechpro=$(By.xpath("//a[@type='button']"));

    //actions
    public SelenideElement source=$(By.id("draggable"));
    public SelenideElement target=$(By.id("droppable"));

    //expicity wait
    public SelenideElement startButton=$(By.xpath("//div[@id='start']//button"));
    public SelenideElement helloworld=$(By.xpath("//div[@id='finish']//h4"));

    //SCREENSHOT
    public SelenideElement googleimage=$(By.cssSelector(".lnXdpd"));




}

