package com.simbirsoft.pages;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.pages.components.CalendarComponent;
import com.simbirsoft.pages.components.DropdownComponent;
import com.simbirsoft.pages.components.ModalWindowComponent;
import com.simbirsoft.pages.components.SubjectInputComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.simbirsoft.tests.TestData.userPicClasspath;

public class RegistrationPage {

    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("input#firstName"),
            lastNameInput = $("input#lastName"),
            emailInput = $("input#userEmail"),
            phoneInput = $("input#userNumber"),
            userPicUpload = $("input#uploadPicture"),
            selectorMaleGender = $("input#gender-radio-1").parent(),
            selectorFemaleGender = $("input#gender-radio-2").parent(),
            selectorOtherGender = $("input#gender-radio-3").parent(),
            checkboxHobby = $("#hobbiesWrapper"),
            userAddressInput = $("textarea#currentAddress"),
            submitButton = $("button#submit");

    private final String FORM_TITLE = "Student Registration Form";

    public CalendarComponent calendarComponent = new CalendarComponent();
    public SubjectInputComponent subjectInputComponent = new SubjectInputComponent();
    public DropdownComponent dropdownComponent = new DropdownComponent();
    public ModalWindowComponent modalWindowComponent = new ModalWindowComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void typeEmail(String email) {
        emailInput.setValue(email);
    }

    public void typePhone(String phone) {
        phoneInput.setValue(phone);
    }

    public void uploadUserPic() {
        userPicUpload.uploadFromClasspath(userPicClasspath);
    }

    public void selectMaleGender() {
        selectorMaleGender.click();
    }

    public void selectFemaleGender() {
        selectorFemaleGender.click();
    }

    public void selectOtherGender() {
        selectorOtherGender.click();
    }

    public void clickHobby(String hobby) {
        checkboxHobby.$(byText(hobby)).click();
    }

    public void typeAddress(String address) {
        userAddressInput.setValue(address);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
