package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.exception.AccountDuplicate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qixiang on 8/15/17.
 */
@ControllerAdvice
public class AccountDuplicateHandler {

    @ExceptionHandler(AccountDuplicate.class)
    @ResponseBody
    public String userDuplicate() {
        return "error/error";
    }


}
