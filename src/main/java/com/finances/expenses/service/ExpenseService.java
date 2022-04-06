package com.finances.expenses.service;

import com.finances.expenses.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    void saveExpense(ExpenseDto dto);
    ExpenseDto getExpense(String id);
    List<ExpenseDto> getAllExpenses(String account);
    void deleteExpense(String id);
    void deleteAllExpenses();
}
