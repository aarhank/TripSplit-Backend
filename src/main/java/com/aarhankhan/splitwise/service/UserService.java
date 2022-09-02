package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.UserLogin;
import com.aarhankhan.splitwise.model.UserModel;

import java.util.List;


public interface UserService {
    User createUser(UserModel userModel);

    User getUserById(Long userId);

    List<Group> getUserGroups(Long userId);

    List<Expense> getUserExpenses(Long userId);

    List<User> getAllUsers();

    String deleteUser(Long userId);

    User userLogin(UserLogin userLogin);
}
