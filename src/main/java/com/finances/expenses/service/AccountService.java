package com.finances.expenses.service;

import com.finances.expenses.dto.AccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAll();
}
