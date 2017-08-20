package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/20/17.
 */
public class AccountRolesNonValidate extends RuntimeExceptionWithErrorCode {

    public AccountRolesNonValidate(String message) {
        super(message, ResponseCodeMessage.ACCOUNT_ROLE_NONVALIDATE_CODE);
    }
}
