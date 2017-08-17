package cn.edu.buaa.tricloud.mooc.service;

import cn.edu.buaa.tricloud.mooc.domain.Account;

import java.util.List;

/**
 * Created by qixiang on 8/17/17.
 */
public interface AccountService {

    List<Account> getAccounts();

    Account getAccountByUsername(String username);

    boolean checkAccount(Account account);

    int updateAccount(Account account);

    int insertAccount(Account account);

}
