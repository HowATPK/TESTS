package com.gitlab.rmarzec.framework.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Data
public class WikipediaPageObjects {

    @FindBy(xpath = "//a[contains(@class,'mw-wiki-logo')]")
    private WebElement wikipediaPageRecognizer;
    @FindBy(xpath = "//nav[@id='p-lang']//li")
    private List<WebElement> languagesList;

    private final WebDriver driver;

    public WikipediaPageObjects(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSubElementOfLanguageWebElement(final String languageName)
    {
        return driver.findElement(By.xpath(String.format("//nav[@id='p-lang']//li[contains(text(),%s)]//a",languageName)));
    }
}