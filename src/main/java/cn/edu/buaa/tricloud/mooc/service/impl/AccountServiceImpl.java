package cn.edu.buaa.tricloud.mooc.service.impl;

import cn.edu.buaa.tricloud.mooc.domain.Account;
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

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = getAccountByUsername(username);
        if ( account == null ) throw new UsernameNotFoundException(String.format("failure to find the account - username:%s",username));
        return new User(account.getUsername(),
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
