package com.finances.expenses.client;

import com.finances.expenses.dto.ExpenseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "expenseClient", url = "${url}", configuration = ClientConfiguration.class)
public interface ExpenseClient {

    @GetMapping("/api/v1/expenses")
    List<ExpenseDto> findAll();

    @GetMapping("/api/v1/expenses/{id}")
    ExpenseDto find(@PathVariable("id") String id);

    @PostMapping(value = "/api/v1/expenses")
    ExpenseDto create(ExpenseDto dto);

    @DeleteMapping(value = "api/v1/expenses")
    void deleteAll();
}
