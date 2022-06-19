package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.GoogleController;
import com.gitlab.rmarzec.framework.utils.controller.W3SchoolController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class Task2Test extends TestBase {

    private static final String PAGE_URL = "https://www.google.com/";
    private static final String SEARCH_STRING = "HTML select tag - W3Schools";
    private static final String CAR_OPTION = "Opel";

    private final GoogleController googleController;
    private final W3SchoolController w3SchoolController;

    public Task2Test() {
        super();
        this.googleController = new GoogleController(webDriver);
        this.w3SchoolController = new W3SchoolController(webDriver);
    }

    @Test
    @Order(1)
    public void openGoogleAndAcceptCookiesTest() {
        mainUtilitiesController.goToURLMethod(PAGE_URL);
        googleController.acceptCookiesMethod();
        String testMessage = "Google page does not open properly";
        Assertions.assertTrue(googleController.isGooglePageVisible(), testMessage);
    }

    @Test
    @Order(2)
    public void openW3SchoolPageByClickingLuckyShotSearchButton() {
        googleController.setSearchField(SEARCH_STRING);
        googleController.clickLuckyShotButton();
        w3SchoolController.verifyW3URL();
        w3SchoolController.acceptCookiesMethod();
        String testMessage = "W3School page does not open properly";
        Assertions.assertTrue(w3SchoolController.isW3SchoolPageOpen(), testMessage);
    }

    @Test
    @Order(3)
    public void clickTryItButtonAndCheckHeader() {
        w3SchoolController.clickTryItYourselfButtonAndSwitchToNewWindow();
        w3SchoolController.switchToEditorIFrame();
        String testMessage = "W3Editor header in not visible";
        Assertions.assertTrue(w3SchoolController.isW3EditorHeaderVisible(), testMessage);
    }

    @Test
    @Order(3)
    public void choseOpelOptionFromSelectorList() {

        w3SchoolController.choseOpelOptionFromSelectorFromList();
        String textFromCarOption = w3SchoolController.getTextFromCarSelectorOption();
        String valueFromCarOption = w3SchoolController.getValueAttributeFromCarSelectorOption();
        String textMessage = String.format("Text from opel option is invalid. Current value: %s, expected: %s", textFromCarOption, CAR_OPTION);
        String valueMessage = String.format("Value from opel option is invalid. Current value: %s, expected: %s", valueFromCarOption, CAR_OPTION);
        Assertions.assertAll(
                () -> Assertions.assertEquals(CAR_OPTION, textFromCarOption, textMessage),
                () -> Assertions.assertEquals(CAR_OPTION.toLowerCase(Locale.ROOT), valueFromCarOption, valueMessage)
        );
    }
}