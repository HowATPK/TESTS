package com.gitlab.rmarzec.framework.utils.pageobject;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class W3SchoolPageObjects {

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement w3SchoolLogo;
    @FindBy(xpath = "//div[@id='accept-choices']")
    private WebElement cookiesAcceptButton;
    @FindBy(xpath = "(//a[text()='Try it Yourself »'])[1]")
    private WebElement tryItYourselfButton;
    @FindBy(xpath = "//h1")
    private WebElement resultIFrameH1;
    @FindBy(xpath = "//div[@id='iframe']//iframe")
    private WebElement editorIFrame;
    @FindBy(xpath = "//select[@id='cars']")
    private WebElement carSelector;
    @FindBy(xpath = "//option[@value='opel']")
    private WebElement opelOption;

    private final WebDriver driver;

    public W3SchoolPageObjects(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}