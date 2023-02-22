package com.thoughtworks.twhotel.service;

import com.thoughtworks.twhotel.common.BaseResult;
import com.thoughtworks.twhotel.common.BaseResultGenerator;
import com.thoughtworks.twhotel.common.exception.BaseException;
import com.thoughtworks.twhotel.domain.Account;
import com.thoughtworks.twhotel.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public BaseResult createAccount(String username, String password) {
        Optional<Account> account = accountRepository.findAccountByOpenCode(username);
        if (account.isPresent()) {
            return BaseResultGenerator.error("用户名被占用!");
        }
        accountRepository.save(Account.builder()
                .openCode(username)
                .password(password)
                .createdAt(Instant.now().getEpochSecond())
                .updateAt(Instant.now().getEpochSecond())
                .build());
        return BaseResultGenerator.success();
    }
}
