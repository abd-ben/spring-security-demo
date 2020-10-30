package com.spmia.chapterone.chapterone.service;

import com.spmia.chapterone.chapterone.entity.User;
import com.spmia.chapterone.chapterone.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> lookup() {
        return userRepo.findAll();
    }

    public User add(User user) {
        return userRepo.save(user);
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }

    public User update(User user) {
        return userRepo.save(user);
    }
}
