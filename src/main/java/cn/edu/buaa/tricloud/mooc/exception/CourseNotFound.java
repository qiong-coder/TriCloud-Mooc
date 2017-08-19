package cn.edu.buaa.tricloud.mooc.exception;

import cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage;

/**
 * Created by qixiang on 8/19/17.
 */
public class CourseNotFound extends RuntimeExceptionWithErrorCode {

    public CourseNotFound(String message) {
        super(message, ResponseCodeMessage.COURSE_NOT_FOUND_CODE);
    }

}
