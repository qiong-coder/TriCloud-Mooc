package cn.edu.buaa.tricloud.mooc.service;

import cn.edu.buaa.tricloud.mooc.Request.AccountRegister;
import cn.edu.buaa.tricloud.mooc.Response.AccountResponse;
import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by qixiang on 8/17/17.
 */
public interface AccountService extends UserDetailsService {

    List<Account> getAccounts();

    Account getAccountByLoginName(String loginName);

    AccountResponse getAccountResponseByLoginName(String loginName);

    AccountResponse checkAccount(String loginName, String password);

    //int updateAccount(Account account);

    void insertAccount(AccountRegister accountRegister);

}
