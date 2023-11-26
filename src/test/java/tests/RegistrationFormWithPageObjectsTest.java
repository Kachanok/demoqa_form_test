package tests;

import Pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        //заполнение всех полей
        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Smith")
                .setEmail("annsmth@yes.com")
                .setGender("Female")
                .setUserNumber("8800222336")
                .setDateOfBirth("10", "September", "1992")
                .setSubjects("English")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture()
                .setCurrentAddress("220 East Chicago Avenue,Chicago")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .pressSubmit();


        //Проверка
        registrationPage.checkResult("Student Name", "Ann Smith")
                .checkResult("Student Email", "annsmth@yes.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800222336")
                .checkResult("Date of Birth", "10 September,1992")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "PictureForTest.png")
                .checkResult("Address", "220 East Chicago Avenue,Chicago")
                .checkResult("State and City", "Uttar Pradesh Lucknow");
    }

    @Test
    void minimalDataTest() {
        //заполнение обязательных полей

        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Smith")
                .setGender("Female")
                .setEmail("annsmth@yes.com")
                .setUserNumber("8800222336")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Ann Smith")
                .checkResult("Student Email", "annsmth@yes.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800222336");

    }

    @Test
    void negativeTest() {

        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Smith")
                .setGender("Female")
                .pressSubmit()
                .checkNotCompleteForm();


    }

}


