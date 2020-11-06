package com.spmia.chapterone.chapterone.security.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getPremissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
