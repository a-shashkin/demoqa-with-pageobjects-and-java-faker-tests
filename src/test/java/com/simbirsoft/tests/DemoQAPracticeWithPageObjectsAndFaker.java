package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.simbirsoft.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQAPracticeWithPageObjectsAndFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userPhone = faker.phoneNumber().subscriberNumber(10);
    String userCurrentAddress = faker.address().fullAddress();

    @Test
    void fillFormAndSubmit() {

        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.selectMaleGender();
        registrationPage.typePhone(userPhone);
        registrationPage.calendarComponent.setDate("11", "May", "1992");
        registrationPage.subjectInputComponent.selectSubject("Maths");
        registrationPage.subjectInputComponent.selectSubject("Computer Science");
        registrationPage.subjectInputComponent.selectSubject("English");
        registrationPage.clickHobby("Reading");
        registrationPage.clickHobby("Music");
        registrationPage.uploadUserPic();
        registrationPage.typeAddress(userCurrentAddress);
        registrationPage.dropdownComponent.selectElementFromDropdown("state", "NCR");
        registrationPage.dropdownComponent.selectElementFromDropdown("city", "Noida");
        registrationPage.clickSubmitButton();

        registrationPage.modalWindowComponent.modalContentWindow.shouldBe(visible);
        registrationPage.modalWindowComponent.modalWindowHeader.shouldHave(text("Thanks for submitting the form"));
        registrationPage.modalWindowComponent.table.$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        registrationPage.modalWindowComponent.table.$(byText("Student Email")).parent().shouldHave(text(userEmail));
        registrationPage.modalWindowComponent.table.$(byText("Gender")).parent().shouldHave(text("Male"));
        registrationPage.modalWindowComponent.table.$(byText("Mobile")).parent().shouldHave(text(userPhone));
        registrationPage.modalWindowComponent.table.$(byText("Date of Birth")).parent().shouldHave(text("11 May,1992"));
        registrationPage.modalWindowComponent.table.$(byText("Subjects")).parent().shouldHave(text("Maths, Computer Science, English"));
        registrationPage.modalWindowComponent.table.$(byText("Hobbies")).parent().shouldHave(text("Reading, Music"));
        registrationPage.modalWindowComponent.table.$(byText("Picture")).parent().shouldHave(text("7dBulQtN5gc.jpg"));
        registrationPage.modalWindowComponent.table.$(byText("Address")).parent().shouldHave(text(userCurrentAddress));
        registrationPage.modalWindowComponent.table.$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
        registrationPage.modalWindowComponent.closeModalButton.shouldBe(visible);
    }
}
