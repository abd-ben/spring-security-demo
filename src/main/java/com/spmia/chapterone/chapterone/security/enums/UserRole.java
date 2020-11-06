package com.spmia.chapterone.chapterone.security.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.spmia.chapterone.chapterone.security.enums.UserPermission.CREATE;
import static com.spmia.chapterone.chapterone.security.enums.UserPermission.DELETE;
import static com.spmia.chapterone.chapterone.security.enums.UserPermission.READ;
import static com.spmia.chapterone.chapterone.security.enums.UserPermission.UPDATE;

public enum UserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(CREATE, READ, UPDATE, DELETE));

    private final Set<UserPermission> premissions;

    UserRole(Set<UserPermission> premissions) {
        this.premissions = premissions;
    }

    public Set<UserPermission> getPremissions() {
        return premissions;
    }
}
