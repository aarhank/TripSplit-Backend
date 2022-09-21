package com.aarhankhan.splitwise.controller;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.event.RegistrationCompleteEvent;
import com.aarhankhan.splitwise.model.JWTModel;
import com.aarhankhan.splitwise.model.UserLogin;
import com.aarhankhan.splitwise.model.UserModel;
import com.aarhankhan.splitwise.service.UserService;
import com.aarhankhan.splitwise.utility.JWTUtility;
import org.apache.catalina.Authenticator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtility jwtUtility;


    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public JWTModel registerUser(@RequestBody UserModel userModel){

        User user =userService.createUser(userModel);

        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                "url"
        ));

        final String token = jwtUtility.generateToken(user);

        return new JWTModel(token);
    }
    
    @PostMapping("/login")
    public JWTModel userLogin(@RequestBody UserLogin userLogin) throws Exception{

        User user = userService.userLogin(userLogin);
        if(user == null){
            throw new Exception("INVALID_CREDENTIALS");
        }



        final String token = jwtUtility.generateToken(user);

        return new JWTModel(token);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/groups/{id}")
    public List<Group> getUserGroups(@PathVariable("id") Long userId){
        return userService.getUserGroups(userId);
    }

    @GetMapping("/expenses/{id}")
    public List<Expense> getUserExpenses(@PathVariable("id") Long userId){
        return userService.getUserExpenses(userId);
    }
    
    

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        return userService.deleteUser(userId);
    }
}
