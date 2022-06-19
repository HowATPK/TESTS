package com.gitlab.rmarzec.framework.utils.model;

import lombok.Data;

@Data
public class YTTile {
    String title;
    String channel;
    String length;

    public YTTile(final String title, final String channel, final String length) {
        this.title = title;
        this.channel = channel;
        this.length = length;
    }
}