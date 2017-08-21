package cn.edu.buaa.tricloud.mooc.exception.advice;

import cn.edu.buaa.tricloud.mooc.Response.Response;
import cn.edu.buaa.tricloud.mooc.Response.ResponseBuilder;
import cn.edu.buaa.tricloud.mooc.exception.OrderNotFound;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by qixiang on 8/21/17.
 */
@RestControllerAdvice
public class OrderAdvice {

    @ExceptionHandler(OrderNotFound.class)
    public Response notFound(OrderNotFound orderNotFound) {
        return ResponseBuilder.build(0, orderNotFound);
    }

}
