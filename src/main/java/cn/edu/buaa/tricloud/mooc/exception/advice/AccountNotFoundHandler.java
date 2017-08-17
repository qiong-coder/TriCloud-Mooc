package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qixiang on 8/15/17.
 */

@ControllerAdvice
public class AccountNotFoundHandler {

    @ExceptionHandler(AccountNotFound.class)
    @ResponseBody
    public String userNotFound() {
        return "error/error";
    }

}
