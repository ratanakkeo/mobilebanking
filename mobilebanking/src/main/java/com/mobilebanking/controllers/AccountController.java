package com.mobilebanking.controllers;

import com.mobilebanking.base.controller.BaseController;
import com.mobilebanking.models.Account;
import com.mobilebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseController<Account> {
    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }
}
