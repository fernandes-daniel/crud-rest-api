package com.ntstat.controllers;

import com.ntstat.datatransfer.AccountDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public List<AccountDto> getAccounts(){
        List<AccountDto> accountDtos = new ArrayList<AccountDto>();
        return accountDtos;
    }

}
