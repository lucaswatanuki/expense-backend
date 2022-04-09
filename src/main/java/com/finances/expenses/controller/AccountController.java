package com.finances.expenses.controller;

import com.finances.expenses.dto.AccountDto;
import com.finances.expenses.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController extends SimpleController<AccountDto> {

    @Autowired
    public AccountController(SimpleService<AccountDto> service) {
        super(service);
    }
}
