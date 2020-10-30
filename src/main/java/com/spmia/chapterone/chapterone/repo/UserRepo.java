package com.spmia.chapterone.chapterone.repo;

import com.spmia.chapterone.chapterone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
