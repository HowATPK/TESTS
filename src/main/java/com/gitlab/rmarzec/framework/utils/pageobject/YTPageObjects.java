package com.gitlab.rmarzec.framework.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class YTPageObjects {

    @FindBy(xpath = "//*[@id='button' and contains(@aria-label,'Zaakceptuj wykorzystywanie')]")
    private WebElement acceptCookiesButton;
    @FindBy(xpath = "//*[@id='logo']//a[@id='logo']")
    private WebElement ytLogo;
    @FindBy(xpath = "//ytd-rich-item-renderer")
    private List<WebElement> movieList;
    @FindBy(xpath = " //div[@id='contents']")
    private List<WebElement> videoContent;

    private final WebDriver driver;

    public YTPageObjects(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getAuthorOfMovie(final int elementNumber) {
        return driver.findElement(By.xpath(String.format("//ytd-rich-item-renderer[%d]//div[@id='metadata']//a", elementNumber)));
    }

    public WebElement getTitleOfMovie(final int elementNumber) {
        return driver.findElement(By.xpath(String.format("//ytd-rich-item-renderer[%d]//a[@id='video-title-link']", elementNumber)));
    }

    public WebElement getTimeOfMovie(final int elementNumber) {
        return driver.findElement(By.xpath(String.format("//ytd-rich-item-renderer[%d]//span[@id='text']", elementNumber)));
    }

    public List<WebElement> getLiveMovieRecognizer(final int elementNumber){
        return driver.findElements(By.xpath(String.format("//ytd-rich-item-renderer[%d]//span[text()='NA ŻYWO']", elementNumber)));
    }
}