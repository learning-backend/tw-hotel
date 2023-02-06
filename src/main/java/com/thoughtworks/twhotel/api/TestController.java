package com.thoughtworks.twhotel.api;

import com.thoughtworks.twhotel.service.TestApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestApplicationService testApplicationService;

    @GetMapping("/hello")
    public String hello() {
        return testApplicationService.hello();
    }

}
