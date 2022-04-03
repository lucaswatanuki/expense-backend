package com.finances.expenses.utils;

import com.finances.expenses.dto.ExpenseDto;
import com.finances.expenses.model.Account;
import com.finances.expenses.model.Expense;

import java.time.LocalDateTime;

public class ExpenseConverter {
    public static ExpenseDto mapToExpenseDto(Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .date(expense.getDate())
                .description(expense.getDescription())
                .total(expense.getTotal())
                .installment(expense.getInstallment())
                .account(mapToAccountDto(expense.getAccount()))
                .build();
    }

    public static Expense mapToExpense(ExpenseDto dto) {
        final Expense expense = new Expense();
        expense.setDate(LocalDateTime.now());
        expense.setDescription(dto.getDescription());
        expense.setTotal(dto.getTotal());
        expense.setInstallment(dto.getInstallment());
        expense.setAccount(mapToAccount(dto.getAccount()));
        return expense;
    }

    public static ExpenseDto.AccountDto mapToAccountDto(Account account) {
        return ExpenseDto.AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .build();
    }

    public static Account mapToAccount(ExpenseDto.AccountDto accountDto) {
        return Account.builder()
                .name(accountDto.getName())
                .build();
    }
}
