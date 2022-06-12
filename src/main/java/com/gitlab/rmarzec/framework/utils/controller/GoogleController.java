package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.GooglePageObjects;
import org.openqa.selenium.WebDriver;

public class GoogleController {

    private WebDriver driver;
    private GooglePageObjects googlePageObjects;

    public GoogleController(final WebDriver driver) {
        this.driver = driver;
        this.googlePageObjects = new GooglePageObjects();
    }
}