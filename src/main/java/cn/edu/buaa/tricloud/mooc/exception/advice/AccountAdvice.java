package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.AccountDuplicate;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import cn.edu.buaa.tricloud.mooc.exception.AccountPasswordError;
import cn.edu.buaa.tricloud.mooc.exception.AccountRolesNonValidate;
import jdk.Exported;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by qixiang on 8/19/17.
 */
@RestControllerAdvice
public class AccountAdvice  {

    @ExceptionHandler(AccountNotFound.class)
    //@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ResponseCodeMessage.ACCOUNT_NOT_FOUND_MESSAGE)
    public Response notFound(AccountNotFound accountNotFound) {
        return ResponseBuilder.build(0,accountNotFound);
    }

    @ExceptionHandler(AccountDuplicate.class)
    //@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = ResponseCodeMessage.ACCOUNT_DUPLICATE_MESSAGE)
    public Response duplicate(AccountDuplicate accountDuplicate) {
        return ResponseBuilder.build(0,accountDuplicate);
    }

    @ExceptionHandler(AccountRolesNonValidate.class)
    public Response roleNonValidate(AccountRolesNonValidate accountRolesNonValidate) {
        return ResponseBuilder.build(0,accountRolesNonValidate);
    }

    @ExceptionHandler(AccountPasswordError.class)
    public Response passwordError(AccountPasswordError accountPasswordError) {
        return ResponseBuilder.build(0,accountPasswordError);
    }
}

