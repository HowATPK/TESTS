package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.W3SchoolPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolController {

    private static final long DEFAULT_S_TIMEOUT = 10;

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final W3SchoolPageObjects w3SchoolPageObjects;

    public W3SchoolController(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_S_TIMEOUT));
        this.w3SchoolPageObjects = new W3SchoolPageObjects(driver);
    }

    /**
     * Method checks W3 URL, if url is different from "https://www.w3schools.com/tags/tag_select.asp", method will print in console
     * actual URL and go to w3school url.
     */
    public void verifyW3URL() {
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.equals("https://www.w3schools.com/tags/tag_select.asp")) {
            System.out.println(currentURL);
            driver.get("https://www.w3schools.com/tags/tag_select.asp");
        }
    }

    /**
     * Method accept form with cookies inside W3School page by clicking on accept button.
     */
    public void acceptCookiesMethod() {
        w3SchoolPageObjects.getCookiesAcceptButton().click();
    }

    /**
     * Method checks if W3School main page is open.
     *
     * @return true if W3School logo is visible.
     */
    public boolean isW3SchoolPageOpen() {
        wait.until(ExpectedConditions.visibilityOf(w3SchoolPageObjects.getW3SchoolLogo()));
        return w3SchoolPageObjects.getW3SchoolLogo().isDisplayed();
    }

    /**
     * Method clicks TryItYourself Button inside W3School main page and switch to new window
     */
    public void clickTryItYourselfButtonAndSwitchToNewWindow() {
        wait.until(ExpectedConditions.visibilityOf(w3SchoolPageObjects.getTryItYourselfButton()));
        w3SchoolPageObjects.getTryItYourselfButton().click();
        driver.getWindowHandles().forEach(handle -> driver.switchTo().window(handle));
    }

    /**
     * Method switches current frame to iframeResult
     */
    public void switchToEditorIFrame() {
        wait.until(ExpectedConditions.visibilityOf(w3SchoolPageObjects.getEditorIFrame()));
        driver.switchTo().frame(w3SchoolPageObjects.getEditorIFrame());
    }

    /**
     * Method checks visibility of editor iframe Header and print its name to console.
     *
     * @return true if header is visible.
     */
    public boolean isW3EditorHeaderVisible() {
        wait.until(ExpectedConditions.visibilityOf(w3SchoolPageObjects.getResultIFrameH1()));
        if (w3SchoolPageObjects.getResultIFrameH1().isDisplayed()) {
            System.out.println(w3SchoolPageObjects.getResultIFrameH1().getText());
            return true;
        }
        return false;
    }

    /**
     * Method chose opel option from editor iframe car selector.
     */
    public void choseOpelOptionFromSelectorFromList() {
        wait.until(ExpectedConditions.visibilityOf(w3SchoolPageObjects.getCarSelector()));
        w3SchoolPageObjects.getCarSelector().click();
        wait.until(ExpectedConditions.visibilityOf(w3SchoolPageObjects.getOpelOption()));
        w3SchoolPageObjects.getOpelOption().click();
    }

    /**
     * Method gets Text From Car Selector Option and print them to console.
     *
     * @return Text attribute.
     */
    public String getTextFromCarSelectorOption() {
        String element = w3SchoolPageObjects.getOpelOption().getText();
        System.out.println(element);
        return element;
    }

    /**
     * Method gets Value Attribute From Car Selector Option and print them to console.
     *
     * @return String attribute with name: value
     */
    public String getValueAttributeFromCarSelectorOption() {
        String element = w3SchoolPageObjects.getOpelOption().getAttribute("value");
        System.out.println(element);
        return element;
    }
}