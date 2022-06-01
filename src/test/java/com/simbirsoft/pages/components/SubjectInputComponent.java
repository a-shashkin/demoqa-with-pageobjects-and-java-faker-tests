package com.simbirsoft.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectInputComponent {

    public void selectSubject(String subject) {
        $("input#subjectsInput").setValue(subject).pressEnter();
    }
}
