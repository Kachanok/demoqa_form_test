package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        System.out.println("###  beforeAll()\n");
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000; //4000 default


    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ann");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("annsmth@yes.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8800222336");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--030").click();

        $("#subjectsInput").val("English").pressEnter();
        $("[#hobbiesWrapper").$(byText("Sports")).click();
        $("[#hobbiesWrapper").$(byText("Reading")).click();
        $("[#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("PictureForTest.png");
        $("#currentAddress").setValue("220 East Chicago Avenue,Chicago");
        $("#state").click();
        $("#react-select-3-input").val("Uttar Pradesh").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Lucknow").pressEnter();
        $("#submit").click();

        //Проверка

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ann Smith"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("annsmth@yes.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8800222336"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("30 December,1999"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("PictureForTest.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("220 East Chicago Avenue,Chicago"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Lucknow"));



    }
}
