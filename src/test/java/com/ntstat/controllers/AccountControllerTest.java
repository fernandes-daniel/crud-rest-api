package com.ntstat.controllers;

import com.ntstat.datatransfer.AccountDto;
import com.ntstat.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccounts() throws Exception {
        given(this.accountService.getAccounts())
                .willReturn(new ArrayList<AccountDto>(){{
                    add(AccountDto.fromDefault(1,"fName1", "sName1","accNum1"));
                }});

        this.mockMvc.perform(get("/account-project/rest/account/json")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("[{\"id\":1,\"firstName\":\"fName1\",\"secondName\":\"sName1\",\"accountNumber\":\"accNum1\"}]"));

    }

    @Test
    public void testCreateAccount() throws Exception {
        AccountDto accountDto = AccountDto.fromDefault(1, "fName1", "sName1", "accNum1");


        this.mockMvc.perform(
                 post("/account-project/rest/account/json")
                         .content("{\"id\":1,\"firstName\":\"fName1\",\"secondName\":\"sName1\",\"accountNumber\":\"accNum1\"}")
                         .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("{\"message\":\"account has been successfully added\"}"));

        then(accountService).should().createAccount(accountDto);

    }

    @Test
    public void testDeleteAccount() throws Exception {
        given(this.accountService.deleteAccount(200))
                .willReturn(1);
        this.mockMvc.perform(
                delete("/account-project/rest/account/json/200")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("{\"message\":\"account successfully deleted\"}"));

        then(accountService).should().deleteAccount(200);

    }
}