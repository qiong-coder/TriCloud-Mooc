package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.CourseOrderNotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by qixiang on 8/21/17.
 */
@RestControllerAdvice
public class CourseOrderAdvice {

    @ExceptionHandler(CourseOrderNotFound.class)
    public Response notFound(CourseOrderNotFound courseOrderNotFound) {
        return ResponseBuilder.build(0, courseOrderNotFound);
    }

}
