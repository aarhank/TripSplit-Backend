package com.aarhankhan.splitwise.controller;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.FinalSplit;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.GroupModel;
import com.aarhankhan.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "*")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public Group createGroup(@RequestBody GroupModel groupModel){
        System.out.println(groupModel.toString());
        return groupService.createGroup(groupModel);
    }

    @PostMapping("/adduser/{id}")
    public List<User> addUser(@PathVariable("id") Long GrpId, @RequestBody List<User> user){
        return groupService.addUser(GrpId, user);
    }


    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable("id") Long GroupId ){
        return groupService.getGroupById(GroupId);
    }

    @GetMapping("/users/{id}")
    public List<User> getGroupUsers(@PathVariable("id") Long GroupId){
        return groupService.getGroupUsers(GroupId);
    }

    @GetMapping("/expenses/{id}")
    public List<Expense> getGroupExpenses(@PathVariable("id") Long groupId){
        return groupService.getGroupExpenses(groupId);
    }

    @GetMapping("/finalsplit/{id}")
    public List<FinalSplit> getGroupFinal(@PathVariable("id") Long groupId){
        return groupService.getGroupFinal(groupId);
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable("id") Long groupId){
        return groupService.deleteGroup(groupId);
    }
}
