package cn.edu.buaa.tricloud.mooc.repository;

import cn.edu.buaa.tricloud.mooc.Request.AccountRegister;
import cn.edu.buaa.tricloud.mooc.domain.Account;

import java.awt.event.HierarchyBoundsListener;
import java.util.List;

/**
 * Created by qixiang on 8/15/17.
 */
public interface AccountRepository {

    List<Account> getAccounts();

    Account getAccountByLoginName(String loginName);

    void insertAccount(Account account);

}
