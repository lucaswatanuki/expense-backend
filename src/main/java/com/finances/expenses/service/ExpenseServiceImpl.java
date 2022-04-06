package com.finances.expenses.service;

import com.finances.expenses.dto.ExpenseDto;
import com.finances.expenses.model.Account;
import com.finances.expenses.model.Category;
import com.finances.expenses.model.Expense;
import com.finances.expenses.repositories.AccountRepository;
import com.finances.expenses.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.finances.expenses.utils.ExpenseConverter.*;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, AccountRepository accountRepository) {
        this.expenseRepository = expenseRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void saveExpense(ExpenseDto dto) {

        final Expense expense = mapToExpense(dto);
        final Account account = mapToAccount(dto.getAccount());

        final Category category = mapToCategory(dto.getAccount().getCategory());
        account.setCategory(category);

        accountRepository.insert(account);
        expense.setAccount(account);

        expenseRepository.insert(expense);
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
    public List<ExpenseDto> getAllExpenses(String account) {
        List<Expense> expenseList = expenseRepository.findAllByAccountName(account);

        final List<ExpenseDto> res = new ArrayList<>();

        expenseList.forEach(e -> {
            res.add(mapToExpenseDto(e));
        });

        return res;
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
