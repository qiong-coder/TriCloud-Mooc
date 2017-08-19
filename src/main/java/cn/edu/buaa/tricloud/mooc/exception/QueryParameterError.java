package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/19/17.
 */
public class QueryParameterError extends RuntimeExceptionWithErrorCode {

    public QueryParameterError(String message) {
        super(message, ResponseCodeMessage.QUERY_PARAMETERS_ERROR_CODE);
    }

}
