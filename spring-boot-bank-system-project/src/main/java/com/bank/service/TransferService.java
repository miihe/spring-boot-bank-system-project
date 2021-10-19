package com.bank.service;

import com.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final AccountService accountService;

    @Autowired
    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account[] makeTransfer(Long senderId, Long payeeId, Integer transferSum) {
        return accountService.transfer(senderId, payeeId, transferSum);
    }
}
