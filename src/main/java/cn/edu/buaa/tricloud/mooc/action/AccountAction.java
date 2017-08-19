package cn.edu.buaa.tricloud.mooc.action;


import cn.edu.buaa.tricloud.mooc.Request.AccountRegister;
import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.QueryParameterError;
import cn.edu.buaa.tricloud.mooc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * Created by qixiang on 8/14/17.
 */

@RestController
@Validated
@RequestMapping(value = "/account")
public class AccountAction {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Response register(@Valid AccountRegister accountRegister, BindingResult errors)
    {
       if ( errors.hasErrors() ) throw new QueryParameterError(errors.toString());
       accountService.insertAccount(accountRegister);
       return ResponseBuilder.build(null);
    }

    @RequestMapping(value = "/{login_name}/{password}/", method = RequestMethod.GET)
    public Response login(@PathVariable(name = "login_name") @Size(min=6,max=20,message = "login_name size must be 6~20") String login_name,
                          @PathVariable(name = "password") @Size(min=6,max=20,message = "password size must be 6~20") String password)

    {
        return ResponseBuilder.build(accountService.checkAccount(login_name,password));
    }
}
