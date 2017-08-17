package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by qixiang on 8/15/17.
 */
@Repository("accountRepository")
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    public List<Account> getAccounts() {

        return (List<Account>) getCurrentSession().createCriteria(Account.class).list();
    }

    public Account getAccountByUsername(String username) {
        return (Account) getCurrentSession().byNaturalId(Account.class).using("username",username).load();
    }

    public boolean checkAccount(Account account) {
        Account targetAccount = getAccountByUsername(account.getUsername());
        return targetAccount ==null?false: targetAccount.getPassword().compareTo(account.getPassword())==0;
    }

    public int insertAccount(Account account) {
        if ( getAccountByUsername(account.getUsername()) == null ) {
            getCurrentSession().persist(account);
            return 1;
        } else {
            return 0;
        }
    }

    public int updateAccount(Account account) {
        getCurrentSession().update(account);
        return 1;
    }
}
