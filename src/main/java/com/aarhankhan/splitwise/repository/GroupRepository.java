package com.aarhankhan.splitwise.repository;

import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
