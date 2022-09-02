package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.UserLogin;
import com.aarhankhan.splitwise.model.UserModel;
import com.aarhankhan.splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserModel userModel) {
        User user = new User();
        user.setUserMail(userModel.getUserMail());
        user.setUserFirstName(userModel.getUserFirstName());
        user.setUserLastName(userModel.getUserLastName());
        user.setUserPassword(passwordEncoder.encode(userModel.getUserPassword()));
        user.setUserGroups(null);
        user.setRole("USER");
        userRepository.save(user);
        System.out.println(user.toString());
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<Group> getUserGroups(Long userId) {
        return userRepository.findById(userId).get().getUserGroups();
    }

    @Override
    public List<Expense> getUserExpenses(Long userId) {
        return userRepository.findById(userId).get().getExpenses();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "user deleted";
    }

    @Override
    public User userLogin(UserLogin userLogin) {
        User user = userRepository.findByUserMail(userLogin.getEmail());
        if(passwordEncoder.matches(userLogin.getPassword(),user.getUserPassword())){
            return user;
        }
        return null;
    }
}
