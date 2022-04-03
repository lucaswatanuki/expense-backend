package com.finances.expenses.service;

import com.finances.expenses.dto.ExpenseDto;

public interface ExpenseService {

    void saveExpense(ExpenseDto dto);
    ExpenseDto getExpense(String id);
    void deleteExpense(String id);
    void deleteAllExpenses();
}
