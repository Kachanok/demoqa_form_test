package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--030").click();

        $("#subjectsInput").val("English").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#currentAddress").setValue("220 East Chicago Avenue,Chicago");
        $("#state").click();
        $("#react-select-3-input").val("Harayna").pressEnter();
        $("#city").scrollTo().click();
        $("#react-select-4-input").val("Karnal").pressEnter();

        $("#submit").click();

        //Проверка

        $(".table-responsive").$(byText("Sudent Name")).shouldHave(text("Ann Smith"));
        $(".table-responsive").$(byText("Student Email")).shouldHave(text("annsmth@yes.com"));
        $(".table-responsive").$(byText("Gender")).shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).shouldHave(text("88002223366"));
        $(".table-responsive").$(byText("Date of Birth")).shouldHave(text("30.01.2000"));
        $(".table-responsive").$(byText("Subjects")).shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Address")).shouldHave(text("220 East Chicago Avenue,Chicago"));
        $(".table-responsive").$(byText("State and City")).shouldHave(text("Harayna Karnal"));



    }
}
