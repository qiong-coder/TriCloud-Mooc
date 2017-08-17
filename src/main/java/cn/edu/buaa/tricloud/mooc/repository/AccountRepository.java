package cn.edu.buaa.tricloud.mooc.repository;

import cn.edu.buaa.tricloud.mooc.domain.Account;

import java.util.List;

/**
 * Created by qixiang on 8/15/17.
 */
public interface AccountRepository {

    List<Account> getAccounts();

    Account getAccountByUsername(String username);

    boolean checkAccount(Account account);

    int insertAccount(Account account);

    int updateAccount(Account account);
}
