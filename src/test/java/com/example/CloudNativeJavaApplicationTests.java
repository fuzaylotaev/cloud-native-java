package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
class CloudNativeJavaApplicationTests {

	@MockBean
	private UserService userService;

	@MockBean
	private AccountRepository accountRepository;

	private AccountService accountService;

	@Test
	void contextLoads() {

	}

	@BeforeEach
	void before() {
		accountService = new AccountService(accountRepository, userService);
	}

	@Test
	void testGetAuthenticatedUserAccounts() {
		given(accountRepository.getAccountsByUsername("john"))
				.willReturn(List.of(new Account("55555"), new Account("11111")));

		given(userService.getAuthenticatedUser())
				.willReturn(new User(15, "john"));

		List<Account> accounts = accountService.getAuthenticatedUserAccounts();
		assertThat(accounts).size().isEqualTo(2);
		assertThat(accounts.get(0).getNumber()).isEqualTo("55555");
		assertThat(accounts.get(1).getNumber()).isEqualTo("11111");
	}

}
