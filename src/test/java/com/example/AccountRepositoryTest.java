package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//@DataJpaTest(properties = {
//        "spring.datasource.url=jdbc:h2:mem:testdb",
//        "spring.jpa.hibernate.ddl-auto=create-drop"
//})
@DataJpaTest
@Import(AccountRepository.class)
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findUserAccountsShouldReturnAccounts() {
        entityManager.persist(new Account("33333"));
        Account account = accountRepository.findAccountByNumber("33333");
        assertEquals("33333", account.getNumber());
    }
}
