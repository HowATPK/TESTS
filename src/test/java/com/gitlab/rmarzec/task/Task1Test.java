package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.WikipediaController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class Task1Test extends TestBase {

    private static final String PAGE_URL = "https://pl.wikipedia.org/wiki/Wiki";
    private static final String EXPECTED_LANGUAGE = "English";

    private final WikipediaController wikipediaController;

    public Task1Test() {
        super();
        this.wikipediaController = new WikipediaController(webDriver);
    }

    @Test
    @Order(1)
    public void openWikipediaPageTest() {
        mainUtilitiesController.goToURLMethod(PAGE_URL);
        String testMessage = "Wikipedia page does not open";
        Assertions.assertTrue(wikipediaController.isWikipediaPageVisible(), testMessage);
    }

    @Test
    @Order(2)
    public void openWikipediaPageTest2() {

        String testMessage = String.format("Cannot find URL of %s language", EXPECTED_LANGUAGE);
        Assertions.assertNotEquals(testMessage, "", wikipediaController.printAllLanguagesAndFindURLOfChosenLanguage(EXPECTED_LANGUAGE));
    }
}