package com.finances.expenses.service;

import com.finances.expenses.dto.AccountDto;
import com.finances.expenses.model.Account;
import com.finances.expenses.repositories.AccountRepository;
import com.finances.expenses.utils.ExpenseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements SimpleService<AccountDto> {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto get(String id) {
        return null;
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

    @Override
    public void create(AccountDto dto) {

    }

    @Override
    public void update(String id, AccountDto dto) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
