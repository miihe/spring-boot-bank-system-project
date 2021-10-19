package com.bank.dao;

import com.bank.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AccountDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private SessionFactory getSessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    public Account save(Account account) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return account;
    }

    public Account findById(Long id) {
        Session session = getSessionFactory().openSession();
        Account account = session.find(Account.class, id);
        session.close();
        return account;
    }

    public Account payment(Long id, Integer paymentSum) {
        Session session = getSessionFactory().openSession();
        Account account = session.find(Account.class, id);
        session.beginTransaction();
        account.getBill().setAmount(account.getBill().getAmount() - paymentSum);
        Account accountAfterPayment = (Account) session.merge(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return accountAfterPayment;
    }

    public Account adjustment(Long id, Integer adjustmentSum) {
        Session session = getSessionFactory().openSession();
        Account account = session.find(Account.class, id);
        session.beginTransaction();
        account.getBill().setAmount(account.getBill().getAmount() + adjustmentSum);
        Account accountAfterAdjustment = (Account) session.merge(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return accountAfterAdjustment;
    }

    public Account[] transfer(Long senderId, Long payeeId, Integer transferSum) {
        Session session = getSessionFactory().openSession();
        Account senderAccount = session.find(Account.class, senderId);
        Account payeeAccount = session.find(Account.class, payeeId);
        session.beginTransaction();
        senderAccount.getBill().setAmount(senderAccount.getBill().getAmount() - transferSum);
        Account senderAccountAfterTransfer = (Account) session.merge(senderAccount);
        payeeAccount.getBill().setAmount(payeeAccount.getBill().getAmount() + transferSum);
        Account payeeAccountAfterTransfer = (Account) session.merge(payeeAccount);
        Account[] accounts = new Account[]{senderAccountAfterTransfer, payeeAccountAfterTransfer};
        session.flush();
        session.getTransaction().commit();
        session.close();
        return accounts;
    }
}
