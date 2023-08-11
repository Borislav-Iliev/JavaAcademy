package com.example.aopexample.service;

import com.example.aopexample.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private String name;

    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass().getSimpleName() + ": Doing some work in the account service.");
    }

    public List<Account> findAllAccounts() {
        return new ArrayList<>(List.of(new Account("Account", "VIP")));
    }

    public List<Account> findAllAccountsWithException() {
        List<Account> accounts;

        accounts = null;

        try {
            accounts.add(new Account("Account", "VIP"));
        } catch (RuntimeException ex) {
            throw ex;
        }

        return new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public AccountService setName(String name) {
        this.name = name;
        return this;
    }
}
