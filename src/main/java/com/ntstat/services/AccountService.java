package com.ntstat.services;

import com.ntstat.datatransfer.AccountDto;
import com.ntstat.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountDto> getAccounts(){
        return null;
    }
}
