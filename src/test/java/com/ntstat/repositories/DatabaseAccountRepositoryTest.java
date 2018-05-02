package com.ntstat.repositories;

import com.ntstat.entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class DatabaseAccountRepositoryTest {

    @Test
    public void getAccounts() {
        Mocks mocks = new Mocks().create();

        DatabaseAccountRepository fixture = new DatabaseAccountRepository(mocks.sessionFactory);

        ArrayList<Account> expectedAccounts = new ArrayList<Account>() {{
            add(mock(Account.class));
            add(mock(Account.class));
        }};

        when(mocks.session.createQuery("from Account").list())
                .thenReturn(expectedAccounts);

        Assert.assertEquals(expectedAccounts, fixture.getAccounts());

        InOrder inOrder = inOrder(mocks.session, mocks.transaction);

        mocks.preVerify(inOrder);
        inOrder.verify(mocks.session).createQuery("from Account");
        mocks.postVerify(inOrder);
    }

    @Test
    public void createAccount() {
        Mocks mocks = new Mocks().create();

        DatabaseAccountRepository fixture = new DatabaseAccountRepository(mocks.sessionFactory);

        Account account = mock(Account.class);

        fixture.createAccount(account);

        InOrder inOrder = inOrder(mocks.session, mocks.transaction);

        mocks.preVerify(inOrder);
        inOrder.verify(mocks.session).save(account);
        mocks.postVerify(inOrder);
    }

    @Test
    public void deleteAccount() {
        Mocks mocks = new Mocks().create();

        DatabaseAccountRepository fixture = new DatabaseAccountRepository(mocks.sessionFactory);

        Query query = mock(Query.class);
        when(mocks.session.createQuery("delete Account where id = :id")).thenReturn(query);

        fixture.deleteAccount(10);

        InOrder inOrder = inOrder(mocks.session, mocks.transaction, query);

        mocks.preVerify(inOrder);
        inOrder.verify(mocks.session).createQuery("delete Account where id = :id");
        inOrder.verify(query).setParameter("id", 10);
        mocks.postVerify(inOrder);
    }

    private class Mocks {
        public Transaction transaction;
        public Session session;
        public SessionFactory sessionFactory;

        public Mocks create() {
            transaction = mock(Transaction.class);

            session = mock(Session.class, RETURNS_DEEP_STUBS);
            when(session.getTransaction()).thenReturn(transaction);
            sessionFactory = mock(SessionFactory.class);
            when(sessionFactory.openSession()).thenReturn(session);
            return this;
        }

        public void preVerify(InOrder inOrder){
            inOrder.verify(this.session).beginTransaction();
        }

        public void postVerify(InOrder inOrder){
            inOrder.verify(session).getTransaction();
            inOrder.verify(transaction).commit();
            inOrder.verify(session).close();
        }
    }
}