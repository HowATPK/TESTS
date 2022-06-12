package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.GoogleController;
import com.gitlab.rmarzec.framework.utils.controller.W3SchoolController;
import org.testng.annotations.Test;


public class Task2Test extends TestBase {

    private GoogleController googleController;
    private W3SchoolController w3SchoolController;

    public Task2Test() {
        super();
        this.googleController = new GoogleController(webDriver);
        this.w3SchoolController = new W3SchoolController(webDriver);
    }

    @Test
    public void Task2Test() {
    }
}
