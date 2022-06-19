package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.WikipediaPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaController {

    private static final long DEFAULT_S_TIMEOUT = 10;

    private final WikipediaPageObjects wikipediaPageObjects;
    private final WebDriverWait wait;

    public WikipediaController(final WebDriver driver) {
        this.wikipediaPageObjects = new WikipediaPageObjects(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_S_TIMEOUT));
    }

    /**
     * Method checks if wikipedia logo is displayed in page.
     *
     * @return true if wikipedia logo is visible.
     */
    public boolean isWikipediaPageVisible() {
        wait.until(ExpectedConditions.visibilityOf(wikipediaPageObjects.getWikipediaPageRecognizer()));
        return wikipediaPageObjects.getWikipediaPageRecognizer().isDisplayed();
    }

    /**
     * Method prints name of all accessible languages form wikipedia page. If name of language equals provided String argument, method will print href related
     * of language's child object.
     *
     * @param expectedLanguage - the name of the language for which we want to get the URL.
     * @return String with URL related to language with name indicated in method argument.
     */
    public String printAllLanguagesAndFindURLOfChosenLanguage(final String expectedLanguage) {
        String url = "";
        wait.until(ExpectedConditions.visibilityOf(wikipediaPageObjects.getLanguagesList().get(0)));
        for (WebElement language : wikipediaPageObjects.getLanguagesList()) {
            String languageName = language.getText();
            System.out.println(languageName);
            if (languageName.equals(expectedLanguage)) {
                url = wikipediaPageObjects.getSubElementOfLanguageWebElement(languageName).getAttribute("href");
                System.out.println(url);
            }
        }
        return url;
    }
}