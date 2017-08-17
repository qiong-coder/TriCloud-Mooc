package cn.edu.buaa.tricloud.mooc.action;

import cn.edu.buaa.tricloud.mooc.domain.Account;
import cn.edu.buaa.tricloud.mooc.repository.AccountRepository;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by qixiang on 8/14/17.
 */

@Controller
@RequestMapping(value = "/account")
public class AccountAction {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String selectUsers(Model model) {
        List<Account> accountList = accountService.getAccounts();
        model.addAttribute(accountList);
        return "users";
    }

    @RequestMapping(value = "/{username}/", method = RequestMethod.GET)
    public String selectByName(@PathVariable String username,
                               Model model) {
        Account account = accountService.getAccountByUsername(username);
        model.addAttribute(account);
        return "user";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.GET)
    public String getRegisterForm(Model model)
    {
        model.addAttribute(new Account());
        return "registerForm";
    }

    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    public String insertUser(@Valid Account account, BindingResult errors)
    {
       if ( errors.hasErrors() ) return "registerForm";
        accountService.insertAccount(account);
        return "redirect:/account/"+ account.getUsername()+"/";
    }

}
