package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/21/17.
 */
public class CourseOrderNotFound extends RuntimeExceptionWithErrorCode {

    public CourseOrderNotFound(String message) {
        super(message, ResponseCodeMessage.COURSE_ORDER_NOT_FOUND_CODE);
    }
}
