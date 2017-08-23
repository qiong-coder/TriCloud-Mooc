package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by stupid-coder on 8/24/17.
 */
public class CourseOrderAlreadyOrdered extends RuntimeExceptionWithErrorCode {
    public CourseOrderAlreadyOrdered(String message) {
        super(message, ResponseCodeMessage.COURSE_ORDER_ALREADY_ORDERED);
    }
}
