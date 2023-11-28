package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestDate.*;

public class RegistrationFormWithTestDataTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        //заполнение всех полей
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubjects(subjects)
                .setHobbies(hobbyFirst)
                .setHobbies(hobbySecond)
                .setHobbies(hobbyThird)
                .uploadPicture()
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();


        //Проверка
        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbyFirst + ", " + hobbySecond + ", " + hobbyThird)
                .checkResult("Picture", "PictureForTest.png")
                .checkResult("Address", currentAddress)
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

