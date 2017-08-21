package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.Request.AccountRegister;
import cn.edu.buaa.tricloud.mooc.Response.AccountResponse;
import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;
import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.exception.AccountDuplicate;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.exception.AccountPasswordError;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
import cn.edu.buaa.tricloud.mooc.utils.FileUpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixiang on 8/17/17.
 */
@Component("AccountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    FileUpLoadUtils fileUpLoadUtils;

    public List<Account> getAccounts() {
        List<Account> accountList = accountRepository.getAccounts();
        return accountList;
    }

    public Account getAccountByLoginName(String loginName) {
        Account account = accountRepository.getAccountByLoginName(loginName);
        if ( account == null ) throw new AccountNotFound(String.format("failure to find the account by login_name:%s",loginName));
        return account;
    }

    public AccountResponse getAccountResponseByLoginName(String loginName) {
        return AccountResponse.build(getAccountByLoginName(loginName));
    }

    public AccountResponse checkAccount(String loginName, String password) {
        Account account = accountRepository.getAccountByLoginName(loginName);
        if ( account == null ) throw new AccountNotFound(String.format("failure to find the account by login_name:%s",loginName));
        if ( account.getPassword().compareTo(password) == 0 ) return AccountResponse.build(account);
        else throw new AccountPasswordError(ResponseCodeMessage.ACCOUNT_PASSWORD_ERROR_MESSAGE);
    }

//    public int updateAccount(Account account) {
//        return accountRepository.updateAccount(account);
//    }

    public void insertAccount(AccountRegister accountRegister) {
        if ( accountRepository.getAccountByLoginName(accountRegister.getLogin_name()) != null )
            throw new AccountDuplicate("failure to insert account because of duplication");
        accountRepository.insertAccount(accountRegister.build());
        fileUpLoadUtils.mkdir(accountRegister.getLogin_name());
    }

    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        Account account = getAccountByLoginName(loginName);
        if ( account == null ) throw new UsernameNotFoundException(String.format("failure to find the account - login_name:%s",loginName));
        return new User(account.getLogin_name(),
                account.getPassword(),
                account.getStatus().compareTo(0) == 0,
                true,
                true,
                true,
                parseAuthorities(account.getRoles()));
    }

    private List<GrantedAuthority> parseAuthorities(String roles_str) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if ( roles_str != null && roles_str.length() != 0 ) {
            String[] roles = roles_str.split(",");
            for ( String role : roles ) {
                if ( role.startsWith("ROLE_") ) authorities.add(new SimpleGrantedAuthority(role));
                else authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
            }
        }
        return authorities;
    }
}
