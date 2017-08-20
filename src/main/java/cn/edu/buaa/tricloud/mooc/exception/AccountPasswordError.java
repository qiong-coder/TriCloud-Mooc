package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/20/17.
 */
public class AccountPasswordError extends RuntimeExceptionWithErrorCode {

    public AccountPasswordError(String message) {
        super(message, ResponseCodeMessage.ACCOUNT_PASSWORD_ERROR_CODE);
    }
}
