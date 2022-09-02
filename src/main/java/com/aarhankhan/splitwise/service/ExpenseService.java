package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.Expense;
import com.aarhankhan.splitwise.model.ExpenseModel;

import java.util.List;


public interface ExpenseService {
    Expense createExpense(ExpenseModel expenseModel);

    List<Expense> getGrpExpenses(Long groupId);

    String resolveExpense(Long expId);
}
