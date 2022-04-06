package com.finances.expenses.controller;

import com.finances.expenses.dto.AccountDto;
import com.finances.expenses.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    private final AccountService account;

    @Autowired
    public AccountController(AccountService account) {
        this.account = account;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity.ok(account.getAll());
    }
}
