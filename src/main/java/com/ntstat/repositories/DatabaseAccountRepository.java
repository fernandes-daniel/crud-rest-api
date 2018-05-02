package com.ntstat.repositories;

import com.ntstat.entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class DatabaseAccountRepository implements AccountRepository {

    private final SessionFactory sessionFactory;

    public DatabaseAccountRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Account> getAccounts() {
        Session session = beginSessionTransaction();
        List<Account> accounts = session.createQuery("from Account").list();
        finishSessionTransaction(session);
        return accounts;
    }

    @Override
    public void createAccount(Account account) {
        Session session = beginSessionTransaction();
        session.save( account);
        finishSessionTransaction(session);
    }

    @Override
    public int deleteAccount(int id) {
        Session session = beginSessionTransaction();
        Query query = session.createQuery("delete Account where id = :id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        finishSessionTransaction(session);
        return result;
    }

    private Session beginSessionTransaction() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    private void finishSessionTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
