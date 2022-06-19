package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.YTController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class Task4Test extends TestBase{

    private static final String PAGE_URL = "https://www.youtube.com/";

    private final YTController ytController;

    public Task4Test() {
        super();
        this.ytController = new YTController(webDriver);
    }

    @Test
    @Order(1)
    public void openYTPageAndAcceptCookies(){
        mainUtilitiesController.goToURLMethod(PAGE_URL);
        ytController.acceptCookiesMethod();
        String logoTestMessage = "YT page does not open properly - does not see logo";
        String moviesTestMessage = "YT page does not open properly - does not see movies container";
        Assertions.assertAll(
                ()->Assertions.assertTrue(ytController.isYTPageVisible(), logoTestMessage),
                ()->Assertions.assertTrue(ytController.isYTFilmContainerVisible(), moviesTestMessage)
        );

    }

    @Test
    @Order(2)
    public void getInfoFromFirst12Movies(){
        ytController.getInformationFromMovies();
    }
}