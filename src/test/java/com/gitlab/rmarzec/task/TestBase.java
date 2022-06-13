package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.MainUtilitiesController;
import com.gitlab.rmarzec.framework.utils.DriverFactory;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

    protected WebDriver webDriver;
    protected MainUtilitiesController mainUtilitiesController;

    public TestBase()
    {
        DriverFactory driverFactory = new DriverFactory();
        this.webDriver = driverFactory.initDriver();
        this.mainUtilitiesController = new MainUtilitiesController(webDriver);
    }

    @AfterAll
    public void cleanUp(){
        this.webDriver.quit();
    }
}