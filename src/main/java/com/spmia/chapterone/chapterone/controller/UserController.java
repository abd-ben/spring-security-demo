package com.spmia.chapterone.chapterone.controller;

import com.spmia.chapterone.chapterone.dto.UserDto;
import com.spmia.chapterone.chapterone.entity.User;
import com.spmia.chapterone.chapterone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public List<UserDto> lookup() {
        return userService.lookup();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create')")
    public List<UserDto> add(@RequestBody UserDto user) {
        userService.add(user);
        return lookup();
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('delete')")
    public List<UserDto> delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return lookup();
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('update')")
    public List<UserDto> update(@RequestBody UserDto user) {
        userService.update(user);
        return lookup();
    }
}
