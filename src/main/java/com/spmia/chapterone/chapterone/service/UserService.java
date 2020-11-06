package com.spmia.chapterone.chapterone.service;

import com.spmia.chapterone.chapterone.dto.UserDto;
import com.spmia.chapterone.chapterone.entity.User;
import com.spmia.chapterone.chapterone.mapper.UserMapper;
import com.spmia.chapterone.chapterone.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;

    public UserService() {
    }

    public List<UserDto> lookup() {
        return userMapper.toUserDto(userRepo.findAll());
    }

    public UserDto add(UserDto userDto) {
        User user = userRepo.save(userMapper.toUser(userDto));
        return userMapper.toUserDto(user);

    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }

    public UserDto update(UserDto userDto) {
        User user = userRepo.save(userMapper.toUser(userDto));
        return userMapper.toUserDto(user);
    }
}
