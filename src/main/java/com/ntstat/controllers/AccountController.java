package com.ntstat.controllers;

import com.ntstat.datatransfer.AccountDto;
import com.ntstat.services.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public List<AccountDto> getAccounts(){
        return null;
    }

}
