package cn.edu.buaa.tricloud.mooc.repository.impl;

import cn.edu.buaa.tricloud.mooc.Request.AccountRegister;
import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.repository.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by qixiang on 8/15/17.
 */
@Repository("AccountRepository")
@Transactional
public class AccountRepositoryImpl extends HibernateSessionFactory implements AccountRepository {

    public List<Account> getAccounts() {
        return (List<Account>) getCurrentSession().createCriteria(Account.class).list();
    }

    public Account getAccountByLoginName(String loginName) {
        return (Account) getCurrentSession().byNaturalId(Account.class).using("login_name",loginName).load();
    }

    public void insertAccount(Account account) {
        getCurrentSession().persist(account);
    }

}
