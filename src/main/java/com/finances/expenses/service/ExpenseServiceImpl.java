package com.finances.expenses.service;

import com.finances.expenses.dto.ExpenseDto;
import com.finances.expenses.model.Expense;
import com.finances.expenses.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.finances.expenses.utils.ExpenseConverter.mapToExpense;
import static com.finances.expenses.utils.ExpenseConverter.mapToExpenseDto;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void saveExpense(ExpenseDto dto) {
        final Expense expense = mapToExpense(dto);

        expenseRepository.save(expense);
    }



    @Override
    public ExpenseDto getExpense(String id) {
        final Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense != null) {
            return mapToExpenseDto(expense);
        }

        return null;
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.findById(id)
                .ifPresent(expenseRepository::delete);
    }

    @Override
    public void deleteAllExpenses() {
        expenseRepository.deleteAll();
    }


}
