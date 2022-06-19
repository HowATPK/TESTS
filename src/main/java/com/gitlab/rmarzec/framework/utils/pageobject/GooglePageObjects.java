package com.gitlab.rmarzec.framework.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class GooglePageObjects {
    @FindBy(xpath = "//img[@class='lnXdpd']")
    private WebElement googleLogo;
    @FindBy(xpath = "//input[@title='Szukaj']")
    private WebElement googleSearchField;
    @FindBy(xpath = "//input[@value='Szczęśliwy traf']")
    private WebElement googleLuckyShotButton;
    @FindBy(id="L2AGLb")
    private WebElement cookiesAcceptButton;

    private final WebDriver driver;

    public GooglePageObjects(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}