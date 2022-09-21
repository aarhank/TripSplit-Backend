package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.UserLogin;
import com.aarhankhan.splitwise.model.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;


public interface UserService {
    User createUser(UserModel userModel);

    User getUserById(Long userId);

    List<Group> getUserGroups(Long userId);

    List<Expense> getUserExpenses(Long userId);

    List<User> getAllUsers();

    String deleteUser(Long userId);

    User userLogin(UserLogin userLogin);

    UserDetails loadUserByUserId(Long userId);

    User loadUserByUserName(String userName);
}
