package com.example;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("accountRepository")
public class AccountRepository extends SimpleJpaRepository<Account, Long> {

    private static final Map<String, List<Account>> usernameToAccountsMap = new HashMap<>() {{
        put("frank", List.of(new Account("12345"), new Account("77777")));
    }};

    private final EntityManager entityManager;

    public AccountRepository(EntityManager entityManager) {
        super(Account.class, entityManager);
        this.entityManager = entityManager;
    }

    public List<Account> getAccountsByUsername(String username) {
        return usernameToAccountsMap.get(username);
    }

    public Account findAccountByNumber(String accountNumber) {
        return entityManager.find(Account.class, accountNumber);
    }
}
