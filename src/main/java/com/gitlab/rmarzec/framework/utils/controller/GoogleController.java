package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.GooglePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleController {

    private static final long DEFAULT_S_TIMEOUT = 10;

    private final WebDriverWait wait;
    private final GooglePageObjects googlePageObjects;


    public GoogleController(final WebDriver driver) {
        this.googlePageObjects = new GooglePageObjects(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_S_TIMEOUT));
    }

    /**
     * Method checks if google page is open.
     *
     * @return true if google logo is visible inside opened page.
     */
    public boolean isGooglePageVisible() {
        wait.until(ExpectedConditions.visibilityOf(googlePageObjects.getGoogleLogo()));
        return googlePageObjects.getGoogleLogo().isDisplayed();
    }

    /**
     * Method sets google search filed by expected string value.
     *
     * @param text expected string that will be set in google search field.
     */
    public void setSearchField(final String text) {
        googlePageObjects.getGoogleSearchField().sendKeys(text);
        googlePageObjects.getGoogleSearchField().click();
    }

    /**
     * Method clicks lucky shot button.
     */
    public void clickLuckyShotButton() {
        wait.until(ExpectedConditions.visibilityOf(googlePageObjects.getGoogleLuckyShotButton()));
        googlePageObjects.getGoogleLuckyShotButton().click();
    }

    /**
     * Method accept form with cookies inside Google page by clicking on accept button.
     */
    public void acceptCookiesMethod() {
        googlePageObjects.getCookiesAcceptButton().click();
    }
}