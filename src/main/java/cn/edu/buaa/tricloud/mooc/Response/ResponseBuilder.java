package cn.edu.buaa.tricloud.mooc.Response;

import cn.edu.buaa.tricloud.mooc.exception.RuntimeExceptionWithErrorCode;

/**
 * Created by qixiang on 8/19/17.
 */
public class ResponseBuilder {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Response build(Object data) {
        return new Response(ResponseCodeMessage.OK_CODE, ResponseCodeMessage.OK_MESSAGE ,data);
    }

    public static Response build(int code, String message) {
        return new Response(code,message,null);
    }

    public static Response build(int i,RuntimeExceptionWithErrorCode exception) {
        return new Response(exception.getCode(),exception.getMessage(),null);
    }

}
