package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePages {

    public SelenideElement googlesearchbox=$(By.name("q"));
    public SelenideElement resultSection=$(By.xpath("//div[@id='result-stats']"));
    //div[@class='g']
    public ElementsCollection getAllSections=$$(By.xpath(" //div[@class='g']"));



}
