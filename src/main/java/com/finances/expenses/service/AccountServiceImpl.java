package com.finances.expenses.service;

import com.finances.expenses.dto.AccountDto;
import com.finances.expenses.model.Account;
import com.finances.expenses.repositories.AccountRepository;
import com.finances.expenses.utils.ExpenseConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        final List<AccountDto> response = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(account -> {
           response.add(ExpenseConverter.mapToAccountDto(account));
        });

        return response;
    }
}
