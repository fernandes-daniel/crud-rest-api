package com.ntstat.repositories;

import com.ntstat.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository {

    public List<Account> getAccounts();

    public void createAccount(Account account);

    public void deleteAccount(int id);
}