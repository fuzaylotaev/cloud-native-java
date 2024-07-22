package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService {

    private AccountRepository accountRepository;
    private UserService userService;

    @Autowired
    public AccountService(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    public List<Account> getAuthenticatedUserAccounts() {
        User user = userService.getAuthenticatedUser();
        return accountRepository.getAccountsByUsername(user.getUsername());
    }
}
