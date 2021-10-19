package com.bank.service;

import com.bank.entity.Bill;
import com.bank.exception.AccountNotFoundException;
import com.bank.exception.InsufficientFundsException;
import com.bank.dao.AccountDAO;
import com.bank.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountDAO accountDAO;

    @Autowired
    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account getAccountById(Long id) {
        Account account = accountDAO.findById(id);
        if(account == null) {
            throw new AccountNotFoundException("Account is not found with ID: " + id);
        }
        return account;
    }

    public Account createAccount(String firstName, String lastName, Integer age, Integer amount) {
        Bill bill = new Bill(amount);
        Account account = new Account(firstName, lastName, age, bill);
        return accountDAO.save(account);
    }

    public Account payment(Long id, Integer paymentSum) {
        Account account = getAccountById(id);
        if (account.getBill().getAmount() < paymentSum) {
            throw new InsufficientFundsException("Insufficient fund for payment.");
        }
        return accountDAO.payment(id, paymentSum);
    }

    public Account adjustment(Long id, Integer adjustmentSum) {
        getAccountById(id);
        return accountDAO.adjustment(id, adjustmentSum);
    }

    public Account[] transfer(Long senderId, Long payeeId, Integer transferSum) {
        Account accountSender = getAccountById(senderId);
        getAccountById(payeeId);
        if (accountSender.getBill().getAmount() < transferSum) {
            throw new InsufficientFundsException("Insufficient fund for transfer.");
        }
        return accountDAO.transfer(senderId, payeeId, transferSum);
    }
}
