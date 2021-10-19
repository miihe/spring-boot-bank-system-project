package com.bank.service;

import com.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final AccountService accountService;

    @Autowired
    public PaymentService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account makePayment(Long id, Integer paymentSum) {
        return accountService.payment(id, paymentSum);
    }
}
