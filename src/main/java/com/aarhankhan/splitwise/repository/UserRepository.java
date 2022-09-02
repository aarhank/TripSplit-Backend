package com.aarhankhan.splitwise.repository;

import com.aarhankhan.splitwise.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserMail(String userMail);
}
