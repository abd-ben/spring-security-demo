package com.spmia.chapterone.chapterone.service;

import com.spmia.chapterone.chapterone.dto.UserDto;
import com.spmia.chapterone.chapterone.entity.User;
import com.spmia.chapterone.chapterone.mapper.UserMapper;
import com.spmia.chapterone.chapterone.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService() {
    }

    public List<UserDto> lookup() {
        return userMapper.toUserDto(userRepo.findAll());
    }

    public UserDto add(UserDto userDto) {
        String pw = userDto.getPassword();
        userDto.setPassword(passwordEncoder.encode(pw));
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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepo.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("userName %s not found", userName)));
    }
}
