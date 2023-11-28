package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static tests.TestDate.*;

public class RegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {

        Faker faker = new Faker(new Locale("eng"));


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();

        //заполнение всех полей
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth("10", "September", "1992")
                .setSubjects(subjects)
                .setHobbies(hobbyFirst)
                .setHobbies(hobbySecond)
                .setHobbies(hobbyThird)
                .uploadPicture()
                .setCurrentAddress(streetAddress)
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .pressSubmit();


        //Проверка
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "10 September,1992")
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbyFirst + ", " + hobbySecond + ", " + hobbyThird)
                .checkResult("Picture", "PictureForTest.png")
                .checkResult("Address", streetAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void minimalDataTest() {
        //заполнение обязательных полей

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setEmail(userEmail)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber);

    }

    @Test
    void negativeTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .pressSubmit()
                .checkNotCompleteForm();


    }

}

