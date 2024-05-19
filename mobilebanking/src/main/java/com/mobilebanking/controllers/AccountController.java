package com.mobilebanking.controllers;

import com.mobilebanking.models.Account;
import com.mobilebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
