package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/20/17.
 */
public class ResourceNotFound extends RuntimeExceptionWithErrorCode {

    public ResourceNotFound(String message) {
        super(message, ResponseCodeMessage.RESOURCE_NOT_FOUND_CODE);
    }
}
