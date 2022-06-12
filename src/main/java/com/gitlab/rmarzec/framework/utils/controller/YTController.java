package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.YTPageObjects;
import org.openqa.selenium.WebDriver;

public class YTController {

    private WebDriver driver;
    private YTPageObjects ytPageObjects;

    public YTController(final WebDriver driver) {
        this.driver = driver;
        this.ytPageObjects = new YTPageObjects();
    }
}