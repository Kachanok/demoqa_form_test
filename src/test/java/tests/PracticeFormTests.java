package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        System.out.println("###  beforeAll()\n");
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ann");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("annsmth@yes.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("88002223366");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--010").click();
        $(".react-datepicker__month-select").click();
        $(byValue("10")).click();
        $(".react-datepicker__year-select").click();
        $(byValue("2005")).click();
        $("#subjectsContainer").val("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#currentAddress").setValue("220 East Chicago Avenue,Chicago");
        $("#react-select-3-input").val("Harayna").pressEnter();
        $("#react-select-4-input").val("Karnal").pressEnter();
        $("#submit").click();

        //Проверка

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
