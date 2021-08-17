package com.app.web.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@RequiredArgsConstructor
public enum RoleEnum {

    ROLE_ADMINISTRATOR(0, "full access user", "1111"),
    ROLE_USER(1, "limited access user", "1000");

    private final int id;
    private final String description;
    private final String defaultPermission;

    public static String getRole(int roles) {
        AtomicReference<String> role = new AtomicReference<>("");
        Arrays.stream(values()).forEach(r -> {
            if(r.getId() == roles) role.set(r.name());
        });
        return role.get();
    }
}
