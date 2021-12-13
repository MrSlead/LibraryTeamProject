package com.dream.team.library.entity.lib.converter;

public enum BookFormat {
    EPUB("EPUB"),
    FB2("FB2");

    private final String format;

    BookFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
