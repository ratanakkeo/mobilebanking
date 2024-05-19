package com.mobilebanking.services;

import com.mobilebanking.base.service.BaseService;
import com.mobilebanking.models.Account;
import com.mobilebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService extends BaseService<Account> {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
