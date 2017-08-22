package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.CourseNotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by stupid-coder on 8/22/17.
 */
@RestControllerAdvice
public class CourseAdvice {

    @ExceptionHandler(CourseNotFound.class)
    public Response notFound(CourseNotFound courseNotFounde) {
        return ResponseBuilder.build(0,courseNotFounde);
    }

}
