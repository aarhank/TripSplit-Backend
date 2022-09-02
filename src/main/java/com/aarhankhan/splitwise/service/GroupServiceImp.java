package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.FinalSplit;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.GroupModel;
import com.aarhankhan.splitwise.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Override
    public Group createGroup(GroupModel groupModel) {
        Group group = new Group();
        group.setGroupName(groupModel.getGrpName());
        group.setGroupType(groupModel.getGrpType());
        group.setGroupBudget(groupModel.getGrpBudget());
        group.setGroupUsers(groupModel.getGrpUser());
        group.setExpenses(null);
        group.setFinalSplits(null);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group getGroupById(Long groupId) {
        return groupRepository.findById(groupId).get();
    }

    @Override
    public List<User> addUser(Long grpId, List<User> user) {
        Optional<Group> grp1 = groupRepository.findById(grpId);
        if(grp1.isPresent()){
            grp1.get().getGroupUsers().addAll(user);
            groupRepository.save(grp1.get());
        }
        return grp1.get().getGroupUsers();
    }

    @Override
    public List<User> getGroupUsers(Long groupId) {
        return groupRepository.findById(groupId).get().getGroupUsers();
    }

    @Override
    public List<Expense> getGroupExpenses(Long groupId) {
        return groupRepository.findById(groupId).get().getExpenses();
    }

    @Override
    public List<FinalSplit> getGroupFinal(Long groupId) {
        return groupRepository.findById(groupId).get().getFinalSplits();
    }

    @Override
    public String deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
        return "Group Deleted";
    }
}
