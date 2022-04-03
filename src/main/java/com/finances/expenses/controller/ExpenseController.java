package com.finances.expenses.controller;

import com.finances.expenses.dto.ExpenseDto;
import com.finances.expenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<Void> createExpense(@RequestBody ExpenseDto dto) {
        expenseService.saveExpense(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable String id) {
        return ResponseEntity.ok(expenseService.getExpense(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpenseDto> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<ExpenseDto> deleteAllExpenses() {
        expenseService.deleteAllExpenses();
        return ResponseEntity.noContent().build();
    }
}
