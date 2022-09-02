package com.aarhankhan.splitwise.model;

import com.aarhankhan.splitwise.entity.Group;
import com.aarhankhan.splitwise.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseModel {
    private String expName;
    private Long expAmt;
    private Long expPaidBy;
    private List<User> usrSplitBtw;
    private Group expGrp;
}
