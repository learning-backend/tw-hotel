package com.thoughtworks.twhotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestApplicationService {

    public String hello() {
        return "hello";
    }

}
