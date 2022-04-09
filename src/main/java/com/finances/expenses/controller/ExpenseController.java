package com.finances.expenses.controller;

import com.finances.expenses.dto.ExpenseDto;
import com.finances.expenses.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/expenses")
public class ExpenseController extends SimpleController<ExpenseDto> {

    @Autowired
    public ExpenseController(SimpleService<ExpenseDto> service) {
        super(service);
    }
}
