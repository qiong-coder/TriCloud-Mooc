package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/15/17.
 */
public class AccountDuplicate extends RuntimeExceptionWithErrorCode {

    public AccountDuplicate(String message) {
        super(message, ResponseCodeMessage.ACCOUNT_DUPLICATE_CODE);
    }

}
