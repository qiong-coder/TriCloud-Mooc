package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by qixiang on 8/17/17.
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccounts() {
        List<Account> accountList = accountRepository.getAccounts();
        return accountList;
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername(username);
    }

    public boolean checkAccount(Account account) {
        return accountRepository.checkAccount(account);
    }

    public int updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }

    public int insertAccount(Account account) {
        return accountRepository.insertAccount(account);
    }
}
