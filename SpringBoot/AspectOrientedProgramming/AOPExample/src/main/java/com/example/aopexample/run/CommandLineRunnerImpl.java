package com.example.aopexample.run;

import com.example.aopexample.model.Account;
import com.example.aopexample.service.AccountService;
import com.example.aopexample.service.MembershipService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final AccountService accountService;
    private final MembershipService membershipService;

    public CommandLineRunnerImpl(AccountService accountService, MembershipService membershipService) {
        this.accountService = accountService;
        this.membershipService = membershipService;
    }

    @Override
    public void run(String... args) throws Exception {
        addAccountAccountService();
        System.out.println("============");
        findAllAccounts();
        //findAllAccountsWithException();
        System.out.println("============");
        addAccountMembershipService();
    }

    private void findAllAccountsWithException() {
        System.out.println(this.accountService.findAllAccountsWithException());
    }

    private void findAllAccounts() {
        System.out.println(this.accountService.findAllAccounts());
    }

    private void addAccountAccountService() {
        Account account = new Account();
        this.accountService.addAccount(account, true);
    }

    private void addAccountMembershipService() {
        this.membershipService.addAccount();
    }
}
