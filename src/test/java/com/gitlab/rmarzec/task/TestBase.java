package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.MainUtilitiesController;
import com.gitlab.rmarzec.framework.utils.DriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    public void deleteDriver()
    {
        webDriver.quit();
    }
}
