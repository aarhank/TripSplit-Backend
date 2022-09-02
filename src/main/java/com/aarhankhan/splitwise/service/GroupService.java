package com.aarhankhan.splitwise.service;


import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.FinalSplit;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.GroupModel;

import java.util.List;

public interface GroupService {
    Group createGroup(GroupModel groupModel);

    Group getGroupById(Long groupId);

    List<User> addUser(Long grpId, List<User> user);

    List<User> getGroupUsers(Long groupId);

    List<Expense> getGroupExpenses(Long groupId);

    List<FinalSplit> getGroupFinal(Long groupId);

    String deleteGroup(Long groupId);
}
