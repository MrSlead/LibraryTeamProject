package com.dream.team.library.entity.authorization.converter;

public enum Role {
    ORDINARY("ORDINARY"),
    PREMIUM("PREMIUM");

    private final String role;

    Role(String format) {
        this.role = format;
    }

    public String getRole() {
        return role;
    }
}
