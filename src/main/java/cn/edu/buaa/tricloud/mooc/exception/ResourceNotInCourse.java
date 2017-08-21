package cn.edu.buaa.tricloud.mooc.exception;

import static cn.edu.buaa.tricloud.mooc.Response.ResponseCodeMessage.RESOURCE_NOT_IN_COURSE_CODE;

/**
 * Created by qixiang on 8/21/17.
 */
public class ResourceNotInCourse extends RuntimeExceptionWithErrorCode {

    public ResourceNotInCourse(String message) {
        super(message, RESOURCE_NOT_IN_COURSE_CODE);
    }
}
