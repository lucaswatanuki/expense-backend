package com.finances.expenses.utils;

import com.finances.expenses.dto.AccountDto;
import com.finances.expenses.dto.CategoryDto;
import com.finances.expenses.dto.ExpenseDto;
import com.finances.expenses.model.Account;
import com.finances.expenses.model.Category;
import com.finances.expenses.model.Expense;

public class Converter {
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
        expense.setDate(dto.getDate());
        expense.setDescription(dto.getDescription());
        expense.setTotal(dto.getTotal());
        expense.setInstallment(dto.getInstallment());
        return expense;
    }

    public static AccountDto mapToAccountDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .name(account.getName())
                .build();
    }

    public static Account mapToAccount(AccountDto accountDto) {
        return Account.builder()
                .name(accountDto.getName())
                .build();
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category mapToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .build();
    }


}
