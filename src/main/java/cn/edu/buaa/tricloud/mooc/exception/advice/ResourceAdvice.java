package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.ResourceNotFound;
import cn.edu.buaa.tricloud.mooc.exception.ResourceNotInCourse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by qixiang on 8/20/17.
 */
@RestControllerAdvice
public class ResourceAdvice {

    @ExceptionHandler(ResourceNotFound.class)
    public Response notFound(ResourceNotFound resourceNotFound) {
        return ResponseBuilder.build(0,resourceNotFound);
    }

    @ExceptionHandler(ResourceNotInCourse.class)
    public Response notInCourse(ResourceNotInCourse resourceNotInCourse) {
        return ResponseBuilder.build(0, resourceNotInCourse);
    }

}
