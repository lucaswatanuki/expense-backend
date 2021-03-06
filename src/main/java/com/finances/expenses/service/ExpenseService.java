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

import static com.finances.expenses.utils.Converter.*;

@Service
public class ExpenseService implements SimpleService<ExpenseDto> {

    private final ExpenseRepository expenseRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, AccountRepository accountRepository) {
        this.expenseRepository = expenseRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public ExpenseDto get(String id) {
        final Expense expense = expenseRepository.findById(id).orElse(null);

        if (expense != null) {
            return mapToExpenseDto(expense);
        }

        return null;
    }

    @Override
    public List<ExpenseDto> getAll() {
        List<Expense> expenseList = expenseRepository.findAll();

        final List<ExpenseDto> res = new ArrayList<>();

        expenseList.forEach(e -> {
            res.add(mapToExpenseDto(e));
        });

        return res;
    }

    @Override
    public ExpenseDto create(ExpenseDto dto) {
        final Expense expense = mapToExpense(dto);
        final Account account = mapToAccount(dto.getAccount());

        final Category category = mapToCategory(dto.getAccount().getCategory());
        account.setCategory(category);

        accountRepository.insert(account);
        expense.setAccount(account);

        String expenseId = expenseRepository.insert(expense).getId();

        return dto.toBuilder()
                .id(expenseId)
                .build();
    }

    @Override
    public ExpenseDto update(String id, ExpenseDto body) {
        return null;
    }

    @Override
    public void delete(String id) {
        expenseRepository.findById(id)
                .ifPresent(expenseRepository::delete);
    }

    @Override
    public void deleteAll() {
        expenseRepository.deleteAll();
    }
}
