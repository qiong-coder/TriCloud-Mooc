package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/21/17.
 */
public class OrderNotFound extends RuntimeExceptionWithErrorCode {

    public OrderNotFound(String message) {
        super(message, ResponseCodeMessage.ORDER_NOT_FOUND_CODE);
    }
}
