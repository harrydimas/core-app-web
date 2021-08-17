package com.app.web.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public enum PermissionEnum {

    PERM_USER_VIEW(0, "Can view user list"),
    PERM_USER_ADD(1, "Can add new user"),
    PERM_USER_EDIT(2, "Can edit existing user"),
    PERM_USER_DELETE(3, "Can delete existing user");

    private final int id;
    private final String description;

    public static Set<String> getUserPermissions(String permissions) {

        Set<String> userPermissions = new HashSet<>();
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(values()).forEach(p -> {
            char permission = permissions.charAt(i.get());
            if (permission == '1') userPermissions.add(p.name());
            i.getAndIncrement();
        });
        return userPermissions;
    }
}
