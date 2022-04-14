package com.finances.expenses.integration;

import com.finances.expenses.dto.AccountDto;
import com.finances.expenses.dto.CategoryDto;
import com.finances.expenses.dto.ExpenseDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExpenseSuiteIT extends IntegrationTestSupport {

    @BeforeAll
    public void cleanPreviousData() {
        expenseClient.deleteAll();
    }

    @AfterAll
    public void removeData() {
        expenseClient.deleteAll();
    }

    @Test
    void shouldSaveCustomer() {
        final ExpenseDto dto = ExpenseDto.builder()
                .description("Barril")
                .total(new BigDecimal("100"))
                .date(LocalDateTime.now())
                .account(AccountDto.builder()
                        .name("restaurante")
                        .category(CategoryDto.builder()
                                .name("alimentacao")
                                .build())
                        .build())
                .build();

        final String newExpenseId = expenseClient.create(dto).getId();

        final ExpenseDto expense = expenseClient.find(newExpenseId);

        assertThat(expense.getId()).isEqualTo(newExpenseId);
    }
}
