package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.YTPageObjects;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import com.gitlab.rmarzec.framework.utils.model.YTTile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class YTController {

    private static final long DEFAULT_S_TIMEOUT = 10;

    private final WebDriverWait wait;
    private final YTPageObjects ytPageObjects;
    private final FluentWait<WebDriver> fluentWait;

    public YTController(final WebDriver driver) {
        this.ytPageObjects = new YTPageObjects(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_S_TIMEOUT));
        this.fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(DEFAULT_S_TIMEOUT)).pollingEvery(Duration.ofMillis(500)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
    }

    /**
     * Method accept form with cookies inside yt page by clicking on accept button.
     */
    public void acceptCookiesMethod() {
        wait.until(ExpectedConditions.visibilityOf(ytPageObjects.getAcceptCookiesButton()));
        ytPageObjects.getAcceptCookiesButton().click();
    }

    /**
     * Method checks if YT page is open.
     *
     * @return true if YT logo is visible inside opened page.
     */
    public boolean isYTPageVisible() {
        fluentWait.until(ExpectedConditions.visibilityOf(ytPageObjects.getYtLogo()));
        return ytPageObjects.getYtLogo().isDisplayed();
    }

    /**
     * Method checks if YT page is open.
     *
     * @return true if YT logo is visible inside opened page.
     */
    public boolean isYTFilmContainerVisible() {
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(ytPageObjects.getVideoContent()));
        return ytPageObjects.getVideoContent().stream().allMatch(WebElement::isDisplayed);
    }

    private List<YTTile> initMovieModel() {
        List<YTTile> ytTileList = new ArrayList<>();
        int iteration = 1;
        for (WebElement element : ytPageObjects.getMovieList()) {
            if (iteration > 12) break;
            String liveRecognizer;
            if (ytPageObjects.getLiveMovieRecognizer(iteration).size() > 0) liveRecognizer = "live";
            else {
                fluentWait.until(ExpectedConditions.visibilityOf(ytPageObjects.getTimeOfMovie(iteration)));
                liveRecognizer = ytPageObjects.getTimeOfMovie(iteration).getText();
            }
            fluentWait.until(ExpectedConditions.visibilityOf(ytPageObjects.getTitleOfMovie(iteration)));
            fluentWait.until(ExpectedConditions.visibilityOf(ytPageObjects.getAuthorOfMovie(iteration)));
            ytTileList.add(new YTTile(ytPageObjects.getTitleOfMovie(iteration).getText(), ytPageObjects.getAuthorOfMovie(iteration).getText(), liveRecognizer));
            iteration++;
        }
        return ytTileList;
    }

    /**
     * Method prints to console title, change name, and movie length of first 12 movies from yt page.
     * If move is broadcast in live mode then the information is skipped.
     */
    public void getInformationFromMovies() {
        for (YTTile movie : initMovieModel()) {
            if (movie.getLength().contains("live"))
                System.out.printf("Title: %s, Author: %s, time: %s%n", movie.getTitle(), movie.getChannel(), movie.getLength());
        }
    }
}
