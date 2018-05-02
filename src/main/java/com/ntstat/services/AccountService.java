package com.ntstat.services;

import com.ntstat.datatransfer.AccountDto;
import com.ntstat.entities.Account;
import com.ntstat.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountDto> getAccounts() {
        return accountRepository
                .getAccounts()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    public void createAccount(AccountDto accountDto) {
        accountRepository.createAccount(Account.fromDto(accountDto));
    }

    public int deleteAccount(int id) {
        return accountRepository.deleteAccount(id);
    }
}
