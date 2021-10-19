package com.bank.service;

import com.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdjustmentService {

    private final AccountService accountService;

    @Autowired
    public AdjustmentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account makeAdjustment(Long id, Integer adjustmentSum) {
        return accountService.adjustment(id, adjustmentSum);
    }
}
