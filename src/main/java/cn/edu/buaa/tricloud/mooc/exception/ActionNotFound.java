package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by stupid-coder on 8/22/17.
 */
public class ActionNotFound extends RuntimeExceptionWithErrorCode {

    public ActionNotFound(String message) {
        super(message, ResponseCodeMessage.ACTION_NOT_FOUND_CODE);
    }

}
