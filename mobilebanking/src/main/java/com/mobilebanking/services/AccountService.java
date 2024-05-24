package com.mobilebanking.services;

import com.mobilebanking.base.service.BaseService;
import com.mobilebanking.models.Account;
import com.mobilebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account> {

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }
}
