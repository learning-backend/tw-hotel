package com.thoughtworks.twhotel.repository;

import com.thoughtworks.twhotel.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByOpenCode(String openCode);
}
