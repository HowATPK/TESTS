package com.gitlab.rmarzec.framework.utils.controller;

import com.gitlab.rmarzec.framework.utils.pageobject.W3SchoolPageObjects;
import org.openqa.selenium.WebDriver;

public class W3SchoolController {

    private WebDriver driver;
    private W3SchoolPageObjects w3SchoolPageObjects;

    public W3SchoolController(final WebDriver driver) {
        this.driver = driver;
        this.w3SchoolPageObjects = new W3SchoolPageObjects();
    }
}