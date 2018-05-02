package com.ntstat.services;


import com.ntstat.datatransfer.AccountDto;
import com.ntstat.entities.Account;
import com.ntstat.repositories.AccountRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @Test
    public void getAccounts() {
        AccountRepository accountRepository = mock(AccountRepository.class);

        AccountService fixture = new AccountService(accountRepository);

        Account account1 = Account.fromDefault("firstname1", "secondname1", "accnum1");
        Account account2 = Account.fromDefault("firstname2", "secondname2", "accnum2");

        when(accountRepository.getAccounts()).thenReturn(new ArrayList<Account>(){{
            add(account1);
            add(account2);
        }});

        assertEquals( new ArrayList<AccountDto>(){{
            add(AccountDto.fromEntity(account1));
            add(AccountDto.fromEntity(account2));
        }}, fixture.getAccounts() );

        verify(accountRepository).getAccounts();
        verifyNoMoreInteractions(accountRepository);
    }

    @Test
    public void createAccount() {
        AccountRepository accountRepository = mock(AccountRepository.class);

        AccountService fixture = new AccountService(accountRepository);

        AccountDto accountDto = AccountDto.fromDefault(1, "fname", "sname", "accnum");

        fixture.createAccount(accountDto);

        verify(accountRepository).createAccount(Account.fromDto(accountDto));
        verifyNoMoreInteractions(accountRepository);
    }

    @Test
    public void deleteAccount() {
        AccountRepository accountRepository = mock(AccountRepository.class);

        AccountService fixture = new AccountService(accountRepository);

        when(accountRepository.deleteAccount(123 )).thenReturn(1);

        assertEquals(1, fixture.deleteAccount(123 ));

        verify(accountRepository).deleteAccount(123 );
        verifyNoMoreInteractions(accountRepository);
    }
}