package com.gitlab.rmarzec.task;

import com.gitlab.rmarzec.framework.utils.controller.YTController;
import com.gitlab.rmarzec.model.YTTile;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Task4Test extends TestBase{

    private YTController ytController;

    public Task4Test() {
        super();
        this.ytController = new YTController(webDriver);
    }

    @Test
    public void Task4Test(){
        //Lista kafelkow
        List<YTTile> ytTileList = new ArrayList<YTTile>();
        
    }
}
