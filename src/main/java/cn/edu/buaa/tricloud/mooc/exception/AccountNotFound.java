package cn.edu.buaa.tricloud.mooc.exception;


import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/15/17.
 */
public class AccountNotFound extends RuntimeExceptionWithErrorCode {

    public AccountNotFound(String message) {
        super(message, ResponseCodeMessage.ACCOUNT_NOT_FOUND_CODE);
    }

}
