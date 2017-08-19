package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;
import cn.edu.buaa.tricloud.mooc.exception.AccountDuplicate;
import cn.edu.buaa.tricloud.mooc.exception.AccountNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by qixiang on 8/19/17.
 */
@RestControllerAdvice
public class AccountAdvice  {

    @ExceptionHandler(AccountNotFound.class)
    //@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ResponseCodeMessage.ACCOUNT_NOT_FOUND_MESSAGE)
    public Response notFound(AccountNotFound accountNotFound) {
        return ResponseBuilder.build(ResponseCodeMessage.ACCOUNT_NOT_FOUND_CODE,accountNotFound);
    }

    @ExceptionHandler(AccountDuplicate.class)
    //@ResponseStatus(value = HttpStatus.ALREADY_REPORTED, reason = ResponseCodeMessage.ACCOUNT_DUPLICATE_MESSAGE)
    public Response duplicate(AccountDuplicate accountDuplicate) {
        return ResponseBuilder.build(ResponseCodeMessage.ACCOUNT_DUPLICATE_CODE,accountDuplicate);
    }
}
