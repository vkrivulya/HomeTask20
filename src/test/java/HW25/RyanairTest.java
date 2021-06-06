package HW25;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RyanairTest {

    @Test
    public void ticketsSearchRyanair() {
        Configuration.timeout = 15000;

        open("https://www.ryanair.com/");

        $("[class='cookie-popup-with-overlay__button']").click();
        $("#input-button__departure").clear();
        $("#input-button__departure").val("Vienna");
        $("[data-id='VIE']").click();

        $("#input-button__destination").clear();
        $("#input-button__destination").val("Kyiv");
        $("[data-id='KBP']").click();

        $x("//span[contains(., 'Точні дати')]").click();
        $("[data-id='2021-06-18']").click();
        $("[data-id='2021-06-25']").click();

        $x("//div[@class='counter__button-wrapper--enabled'][1]").click();
        $("[class*='passengers__confirm-button']").click();
        $("button[class*='start-search']").click();

        $$("[class*='card-info__cols-container']").shouldHaveSize(2);

        $$("[class*='day-of-month--selected']").get(0).shouldHave(Condition.text("18"));
        $$("[class*='date-item__month--selected']").get(0).shouldHave(Condition.text("черв."));

        $$("[class*='day-of-month--selected']").get(1).shouldHave(Condition.text("25"));
        $$("[class*='date-item__month--selected']").get(1).shouldHave(Condition.text("черв."));

        $("[class*='details__bottom-bar b2']").shouldHave(Condition.text(" 2 "));

    }

}
