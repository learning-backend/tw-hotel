package com.thoughtworks.twhotel.service;

import com.thoughtworks.twhotel.common.BaseResult;
import com.thoughtworks.twhotel.domain.Account;
import com.thoughtworks.twhotel.repository.AccountRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    private final AccountRepository accountRepository = mock(AccountRepository.class);
    private final AccountService accountService = new AccountService(accountRepository);

    @Test
    public void shouldCreateAccountSuccess() {
        String username = "test";
        String password = "123456";
        when(accountRepository.findAccountByOpenCode(username)).thenReturn(Optional.empty());
        BaseResult actual = accountService.createAccount(username, password);
        assertEquals(200, actual.getCode());
    }

    @Test
    public void shouldCreateAccountFailWhenAccountIsExist() {
        String username = "test";
        String password = "123456";
        when(accountRepository.findAccountByOpenCode(username)).thenReturn(Optional.of(Account.builder().build()));
        BaseResult actual = accountService.createAccount(username, password);
        assertEquals(500, actual.getCode());
    }
}
