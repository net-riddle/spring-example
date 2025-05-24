package com.netriddle.spring_example.repository;

import com.netriddle.spring_example.model.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserPO, Long> {
}
