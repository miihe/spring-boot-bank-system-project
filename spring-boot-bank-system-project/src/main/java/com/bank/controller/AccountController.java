package com.bank.controller;

import com.bank.service.AccountService;
import com.bank.controller.dto.AccountRequestDTO;
import com.bank.controller.dto.AccountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getAccount(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getAccountById(id));
    }

    @PostMapping("/create")
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDTO(accountService.createAccount(accountRequestDTO.getFirstName(), accountRequestDTO.getLastName(),
                accountRequestDTO.getAge(), accountRequestDTO.getBill().getAmount()));
    }
}
