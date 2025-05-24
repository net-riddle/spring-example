package com.netriddle.spring_example.repository;

import com.netriddle.spring_example.model.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserPO, Long> {
    List<UserPO> findAllUsers();

    UserPO updateUser(UserPO userPO);
}
