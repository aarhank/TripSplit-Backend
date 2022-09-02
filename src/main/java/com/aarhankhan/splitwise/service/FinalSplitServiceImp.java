package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import com.aarhankhan.splitwise.model.FinalSplitModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FinalSplitServiceImp implements FinalSplitService{

    @Autowired
    private GroupService groupService;

    static float minOf2(float x, float y)
    {
        return Math.min(x, y);
    }

    static int getMin(Map<Long,Float> map, List<User> users)
    {
        int minInd = 0;

        for (int i = 1; i < users.size(); i++) {

            if (map.get(users.get(i).getId()) < map.get(users.get(minInd).getId())) {
                minInd = i;

            }
        }
        return minInd;
    }

    static int getMax(Map<Long,Float> map, List<User> users)
    {
        int maxInd = 0;

        for (int i = 1; i < users.size(); i++) {
            if (map.get(users.get(i).getId()) > map.get(users.get(maxInd).getId())) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    static List<FinalSplitModel> minCashFlowRec(Map<Long,Float> map, List<User> users, List<FinalSplitModel> finalSplitModels, Group group)
    {

        DecimalFormat f = new DecimalFormat("##.00");

        int mxCredit =  getMax(map, users);
        int mxDebit =  getMin(map, users);

        float min = Float.parseFloat(f.format(minOf2(-map.get(users.get(mxDebit).getId()), map.get(users.get(mxCredit).getId()))));

        if (map.get(users.get(mxCredit).getId()) == 0 && map.get(users.get(mxDebit).getId()) == 0 || min<=0)
            return finalSplitModels;

        map.put(users.get(mxCredit).getId(),map.get(users.get(mxCredit).getId()) - min);
        map.put(users.get(mxDebit).getId(),map.get(users.get(mxDebit).getId()) + min);

        Float finalAmt = min;
        Long finalPayBy = users.get(mxDebit).getId();
        Long finalPayTo = users.get(mxCredit).getId();
        Group finalSplitGrp = group;

        FinalSplitModel obj = new FinalSplitModel(finalPayTo,finalPayBy,finalAmt,finalSplitGrp);
        finalSplitModels.add(obj);

        minCashFlowRec(map, users, finalSplitModels, group);
        return finalSplitModels;
    }
    @Override
    public List<FinalSplitModel> getFinalSplit(Long groupId) {

        List<Expense> exp = groupService.getGroupExpenses(groupId);
        List<User> users = groupService.getGroupUsers(groupId);

        DecimalFormat f = new DecimalFormat("##.00");

        Map<Long,Float> map = new HashMap<>();

        for (Expense expense : exp) {
            Long expAmt = expense.getExpAmt();
            int totalUser = expense.getUsrSplitBtw().size() + 1;
            long totalUsr = totalUser;

            map.putIfAbsent(expense.getExpPaidBy(), 0F);

            Float val = map.get(expense.getExpPaidBy()) + ((float) expAmt -  ( (float) expAmt / (float) totalUsr));
            map.put(expense.getExpPaidBy(), Float.valueOf(f.format(val)));

            for (int j = 0; j < totalUser - 1; j++) {
                map.putIfAbsent(expense.getUsrSplitBtw().get(j).getId(), 0F);
                map.put(expense.getUsrSplitBtw().get(j).getId(), Float.valueOf(f.format(map.get(expense.getUsrSplitBtw().get(j).getId()) - ((float) expAmt / (float) totalUsr))));
            }
        }

        List<FinalSplitModel> finalSplitModels = new ArrayList<>();;


        return minCashFlowRec(map, users,finalSplitModels,exp.get(0).getExpGrp());


    }
}
