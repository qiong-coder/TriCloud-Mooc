package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.Request.AccountRegister;
import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.exception.AccountDuplicate;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
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

    public List<Account> getAccounts() {
        List<Account> accountList = accountRepository.getAccounts();
        return accountList;
    }

    public Account getAccountByLoginName(String loginName) {
        Account account = accountRepository.getAccountByLoginName(loginName);
        if ( account == null ) throw new AccountNotFound(String.format("failure to find the account by login_name:%s",loginName));
        return account;
    }

    public boolean checkAccount(String loginName, String password) {
        Account account = getAccountByLoginName(loginName);
        return account.getPassword().compareTo(password) == 0;
    }

//    public int updateAccount(Account account) {
//        return accountRepository.updateAccount(account);
//    }

    public void insertAccount(AccountRegister accountRegister) {
        if ( accountRepository.getAccountByLoginName(accountRegister.getLoginame()) != null )
            throw new AccountDuplicate("failure to insert account because of duplication");
        accountRepository.insertAccount(accountRegister.build());
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
