package com.ntstat.controllers;

import com.ntstat.datatransfer.AccountDto;
import com.ntstat.datatransfer.ApiResponseDto;
import com.ntstat.exceptions.AccountWithIdNotFoundException;
import com.ntstat.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account-project/rest/account/json")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<AccountDto> getAccounts(){
        return accountService.getAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponseDto createAccount(@RequestBody AccountDto accountDto){
        try{
            accountService.createAccount(accountDto);
            return new ApiResponseDto("account has been successfully added");
        }catch (Exception e){
            return new ApiResponseDto("could not create account");
        }
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    public ApiResponseDto createAccount(@PathVariable int accountId){
        try{
            int result = accountService.deleteAccount(accountId);
            if(result > 0)
                return new ApiResponseDto("account successfully deleted");
            else
                throw new AccountWithIdNotFoundException(accountId);
        }catch (Exception e){
            return new ApiResponseDto("could not delete account");
        }
    }

}
