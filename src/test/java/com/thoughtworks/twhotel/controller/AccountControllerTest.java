package com.thoughtworks.twhotel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.twhotel.common.BaseResultGenerator;
import com.thoughtworks.twhotel.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class AccountControllerTest {
    @Autowired
    private MockMvc mvc;


    @MockBean
    public AccountService accountService;

    @Test
    public void shouldCreateAccountSuccess() throws Exception {
        String username = "test";
        String password = "123456";
        when(accountService.createAccount(username, password)).thenReturn(BaseResultGenerator.success());
        mvc.perform(MockMvcRequestBuilders
                        .post("/users/register")
                        .param("username", username)
                        .param("password", password)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));
    }
}
