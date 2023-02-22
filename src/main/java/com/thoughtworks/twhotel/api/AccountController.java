package com.thoughtworks.twhotel.api;

import com.thoughtworks.twhotel.common.BaseResult;
import com.thoughtworks.twhotel.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/register")
    public BaseResult register(@RequestParam("username") String username, @RequestParam("password") String password) {
        return accountService.createAccount(username, password);
    }
}
