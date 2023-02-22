package com.thoughtworks.twhotel.repository;

import com.thoughtworks.twhotel.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    @Sql("/sql/insert_account.sql")
    public void shouldReturnAccountWhenAccountIsExist() {
        String username = "test";
        String password = "123456";
        Optional<Account> actual = accountRepository.findAccountByOpenCode(username);
        assertTrue(actual.isPresent());
        assertEquals(1L, actual.get().getId());
        assertEquals(password, actual.get().getPassword());
    }
}
